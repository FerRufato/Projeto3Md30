package br.com.rpires.services;

import br.com.rpires.domain.Cliente;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

public interface IClienteService extends IProdutoService {

    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException, DAOException;

    Cliente buscarPorCPF(Long cpf) throws DAOException, MaisDeUmRegistroException, TableException;

    void excluir(Long cpf) throws DAOException;

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException, DAOException;

    Collection<Cliente> buscarTodos() throws DAOException;
}