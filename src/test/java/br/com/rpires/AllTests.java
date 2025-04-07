/**
 * 
 */
package br.com.rpires;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import src.test.java.br.com.rpires.VendaDAOTest;

/**
 * @author rodrigo.pires
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
	ProdutoServiceTest.class, ProdutoDAOTest.class,
	VendaDAOTest.class})
public class AllTests {

}
