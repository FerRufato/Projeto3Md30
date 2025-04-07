package br.com.rpires.dao.generic;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T, K> {
    Boolean cadastrar(T entity) throws SQLException;
    T consultar(K id) throws SQLException;
    void excluir(K id) throws SQLException;
    void alterar(T entity) throws SQLException;
    List<T> buscarTodos() throws SQLException;
}