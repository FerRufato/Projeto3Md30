package br.com.rpires.services;

import br.com.rpires.dao.generic.IGenericDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.List;

public class IProdutoServiceImpl implements IProdutoService {
    /**
     * Método para cadastrar novos registro no banco de dados
     *
     * @param entity a ser cadastrado
     * @return retorna verdadeiro para cadastrado e falso para não cadastrado
     * @throws DAOException
     */
    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException, TipoChaveNaoEncontradaException, IGenericDAO.DAOException {
        return null;
    }

    /**
     * Método para excluir um registro do banco de dados
     *
     * @param valor chave única do dado a ser excluído
     * @throws DAOException
     */
    @Override
    public void excluir(String valor) throws DAOException, DAOException, IGenericDAO.DAOException {

    }

    /**
     * Método para alterar um registro no bando de dados.
     *
     * @param entity a ser atualizado
     * @throws DAOException
     */
    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException, IGenericDAO.DAOException, IGenericDAO.TipoChaveNaoEncontradaException {

    }

    /**
     * Método para consultar um registro no banco de dados
     *
     * @param valor chave única do dado a ser consultado
     * @return
     * @throws DAOException
     */
    @Override
    public Produto consultar(String valor) throws DAOException {
        return null;
    }

    /**
     * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
     *
     * @return Registros encontrados
     * @throws DAOException
     */
    @Override
    public Collection<Cliente> buscarTodos() throws DAOException, IGenericDAO.DAOException {
        return List.of();
    }
}
