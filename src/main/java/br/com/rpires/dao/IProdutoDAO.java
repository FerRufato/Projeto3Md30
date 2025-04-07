package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;

import java.util.Collection;

public interface IProdutoDAO {
    Boolean cadastrar(Produto produto) throws DAOException;
    Produto consultar(Long id) throws DAOException;
    void excluir(Long id) throws DAOException;
    void alterar(Produto produto) throws DAOException;

    Collection<Cliente> buscarTodos();
}