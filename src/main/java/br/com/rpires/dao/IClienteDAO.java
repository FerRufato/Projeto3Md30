package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;
import br.com.rpires.exceptions.DAOException;

public interface IClienteDAO {
    Boolean cadastrar(Cliente cliente) throws DAOException;
    Cliente consultar(Long cpf) throws DAOException;
    void excluir(Long cpf) throws DAOException;
    void alterar(Cliente cliente) throws DAOException;
}