package br.com.rpires.dao.generic;

import br.com.rpires.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public abstract class GenericDAO<T, K> implements IGenericDAO<T, K> {

    protected abstract String getInsertQuery();
    protected abstract void setInsertParameters(PreparedStatement stmt, T entity) throws SQLException;
    protected abstract String getUpdateQuery();
    protected abstract void setUpdateParameters(PreparedStatement stmt, T entity) throws SQLException;
    protected abstract String getDeleteQuery();
    protected abstract String getSelectQuery();
    protected abstract T extractEntityFromResultSet(ResultSet rs) throws SQLException;
    protected abstract List<T> extractEntitiesFromResultSet(ResultSet rs) throws SQLException;

    protected abstract Connection getConnection() throws SQLException;

    @Override
    public Boolean cadastrar(T entity) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(getInsertQuery())) {
            setInsertParameters(stmt, entity);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public T consultar(K id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(getSelectQuery())) {
            stmt.setObject(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractEntityFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public void excluir(K id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(getDeleteQuery())) {
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void alterar(T entity) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(getUpdateQuery())) {
            setUpdateParameters(stmt, entity);
            stmt.executeUpdate();
        }
    }

    @Override
    public Collection<Cliente> buscarTodos() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(getSelectQuery());
             ResultSet rs = stmt.executeQuery()) {
            return extractEntitiesFromResultSet(rs);
        }
    }
}