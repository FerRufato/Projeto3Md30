/**
 * 
 */
package br.com.rpires;

import br.com.rpires.domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rpires.dao.ClienteDaoMock;
import br.com.rpires.dao.IClienteDAO;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.services.IClienteService;

import java.util.Collection;
import java.util.List;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new IClienteService() {
            /**
             * Método para cadastrar novos registro no banco de dados
             *
             * @param entity a ser cadastrado
             * @return retorna verdadeiro para cadastrado e falso para não cadastrado
             * @throws DAOException
             */
            @Override
            public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
                return null;
            }

            /**
             * Método para excluir um registro do banco de dados
             *
             * @param valor chave única do dado a ser excluído
             * @throws DAOException
             */
            @Override
            public void excluir(Long valor) throws DAOException {

            }

            /**
             * Método para alterar um registro no bando de dados.
             *
             * @param entity a ser atualizado
             * @throws DAOException
             */
            @Override
            public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {

            }

            /**
             * Método para consultar um registro no banco de dados
             *
             * @param valor chave única do dado a ser consultado
             * @return
             * @throws DAOException
             */
            @Override
            public Cliente consultar(Long valor) throws DAOException {
                return null;
            }

            /**
             * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
             *
             * @return Registros encontrados
             * @throws DAOException
             */
            @Override
            public Collection<Cliente> buscarTodos() throws DAOException {
                return List.of();
            }

            @Override
            public Cliente buscarPorCPF(Long cpf) throws DAOException {
                return null;
            }
        };
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Rodrigo Pires");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Rodrigo Pires", cliente.getNome());
	}
}
