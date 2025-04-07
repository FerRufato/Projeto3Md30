package br.com.rpires;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.rpires.dao.ProdutoDAO;
import br.com.rpires.dao.IProdutoDAO;
import br.com.rpires.domain.Produto;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDAOTest {

    private Connection connection;
    private IProdutoDAO produtoDao;

    @Before
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/vendas_online_2", "postgres", "admin");
        produtoDao = new ProdutoDAO();
    }

    @After
    public void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testCadastrar() throws Exception {
        Produto produto = new Produto();
        produto.setCodigo("P123");
        produto.setNome("Produto Teste");
        produto.setDescricao("Descrição do Produto Teste");
        produto.setValor(new BigDecimal("99.99"));

        Boolean result = produtoDao.cadastrar(produto);
        assertTrue(result);
    }

    @Test
    public void testConsultar() throws Exception {
        Produto produto = produtoDao.consultar(Long.valueOf("P123"));
        assertNotNull(produto);
    }

    @Test
    public void testBuscarTodos() throws Exception {
        Collection<Produto> produtos = produtoDao.buscarTodos();
        assertFalse(produtos.isEmpty());
    }

    @Test
    public void testConsultarComDataValidade() throws Exception {
        Produto produto = produtoDao.consultar(Long.valueOf("P124"));
        assertNotNull(produto);
        assertNotNull(produto.getDataValidade());
    }
}