package br.com.rpires;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Date;

import br.com.rpires.dao.ClienteDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.exceptions.DAOException;

public class ClienteDAOTest {

    @Test
    public void testCadastrarCliente() throws DAOException, SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Rodrigo Pires");
        cliente.setCpf(12345678901L);
        cliente.setTel(987654321L);
        cliente.setEnd("Rua A");
        cliente.setNumero(123);
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
        cliente.setDataNascimento(new Date());

        Boolean result = clienteDAO.cadastrar(cliente);
        assertTrue(result);
    }

    @Test
    public void testConsultarCliente() throws DAOException, SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.consultar(12345678901L);
        assertNotNull(cliente);
        assertNotNull(cliente.getDataNascimento());
    }
}