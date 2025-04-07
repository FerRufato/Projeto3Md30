package br.com.rpires.services;

import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.dao.Persistente;
import br.com.rpires.dao.generic.IGenericDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public class ClienteServiceImpl extends ClienteService {

    private Persistente entity;

    public ClienteServiceImpl(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException, DAOException, IGenericDAO.DAOException, IGenericDAO.TipoChaveNaoEncontradaException {
        return super.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException, MaisDeUmRegistroException, TableException, IGenericDAO.DAOException {
        return super.buscarPorCPF(cpf);
    }

    @Override
    public Boolean cadastrar(Persistente entity) throws TipoChaveNaoEncontradaException, DAOException, IGenericDAO.DAOException, IGenericDAO.TipoChaveNaoEncontradaException {
        this.entity = entity;
        return null;
    }

    @Override
    public void excluir(Serializable valor) throws DAOException, IGenericDAO.DAOException {

    }

    @Override
    public void excluir(Long cpf) throws DAOException {
        super.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(cliente);
    }

    @Override
    public Persistente consultar(Serializable valor) throws DAOException {
        return null;
    }

    @Override
    public void alterar(Persistente entity) throws TipoChaveNaoEncontradaException, DAOException, IGenericDAO.DAOException, IGenericDAO.TipoChaveNaoEncontradaException {

    }

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
        return null;
    }

    @Override
    public void excluir(String valor) throws DAOException {

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {

    }

    @Override
    public Produto consultar(String valor) throws DAOException {
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() throws DAOException {
        return super.buscarTodos();
    }
}