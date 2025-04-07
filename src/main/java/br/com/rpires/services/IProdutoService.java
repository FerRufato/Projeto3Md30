package br.com.rpires.services;

import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.services.generic.IGenericService;

import java.util.Collection;

public interface IProdutoService extends IGenericService<Produto, String> {

    Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException;

    void excluir(String valor) throws DAOException;

    void alterar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException;

    Produto consultar(String valor) throws DAOException;

    Collection<Cliente> buscarTodos() throws DAOException;
}