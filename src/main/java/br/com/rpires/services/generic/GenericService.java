package br.com.rpires.services.generic;

import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.services.IProdutoService;

import java.util.Collection;

class IProdutoServiceImpl implements IProdutoService {

    private IProdutoDAO produtoDAO;

    public IProdutoServiceImpl(IProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
        return produtoDAO.cadastrar(entity);
    }

    @Override
    public void excluir(String valor) throws DAOException {
        produtoDAO.excluir(Long.valueOf(valor));
    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
        produtoDAO.alterar(entity);
    }

    @Override
    public Produto consultar(String valor) throws DAOException {
        return produtoDAO.consultar(Long.valueOf(valor));
    }

    @Override
    public Collection<Cliente> buscarTodos() throws DAOException {
        return produtoDAO.buscarTodos();
    }
}