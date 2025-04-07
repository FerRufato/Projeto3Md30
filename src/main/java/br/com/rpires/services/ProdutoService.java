package br.com.rpires.services;

import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.services.generic.GenericService;

import java.util.Collection;

public abstract class ProdutoService extends GenericService<Produto, Long> implements IProdutoService {

    private IProdutoDAO produtoDAO;

    public ProdutoService(IProdutoDAO produtoDAO) {
        super(produtoDAO);
        this.produtoDAO = produtoDAO;
    }

    @Override
    public Boolean cadastrar(Produto produto) throws TipoChaveNaoEncontradaException, DAOException {
        return produtoDAO.cadastrar(produto);
    }

    @Override
    public Produto buscarPorId(Long id) throws DAOException, MaisDeUmRegistroException, TableException {
        return produtoDAO.consultar(id);
    }

    @Override
    public void excluir(Long id) throws DAOException {
        produtoDAO.excluir(id);
    }

    @Override
    public void alterar(Produto produto) throws TipoChaveNaoEncontradaException, DAOException {
        produtoDAO.alterar(produto);
    }

    @Override
    public Collection<Produto> buscarTodos() throws DAOException {
        return produtoDAO.buscarTodos();
    }
}