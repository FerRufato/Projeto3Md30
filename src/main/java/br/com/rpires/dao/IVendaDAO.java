/**
 * 
 */
package src.main.java.br.com.rpires.dao;

import src.main.java.br.com.rpires.dao.generic.IGenericDAO;
import src.main.java.br.com.rpires.domain.Venda;
import src.main.java.br.com.rpires.exceptions.DAOException;
import src.main.java.br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
