package br.com.rpires.services;

import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.services.generic.GenericService;

import java.util.Collection;

public abstract class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException, DAOException {
        return clienteDAO.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException, MaisDeUmRegistroException, TableException {
        return clienteDAO.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) throws DAOException {
        clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException, DAOException {
        clienteDAO.alterar(cliente);
    }

    @Override
    public Collection<Cliente> buscarTodos() throws DAOException {
        return clienteDAO.buscarTodos();
    }
}