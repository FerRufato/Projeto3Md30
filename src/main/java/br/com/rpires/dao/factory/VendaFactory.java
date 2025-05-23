/**
 * 
 */
package src.main.java.br.com.rpires.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.main.java.br.com.rpires.domain.Cliente;
import src.main.java.br.com.rpires.domain.Venda;
import src.main.java.br.com.rpires.domain.Venda.Status;

/**
 * @author rodrigo.pires
 *
 */
public class VendaFactory {

	public static Venda convert(ResultSet rs) throws SQLException {
		Cliente cliente = ClienteFactory.convert(rs);
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setId(rs.getLong("ID_VENDA"));
		venda.setCodigo(rs.getString("CODIGO"));
		venda.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
		venda.setDataVenda(rs.getTimestamp("DATA_VENDA").toInstant());
		venda.setStatus(Status.getByName(rs.getString("STATUS_VENDA")));
		return venda;
	}
}
