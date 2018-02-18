package pl.michalskrzypek.tests;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Address;
import pl.michalskrzypek.entity.Cart;

public class AccountTestCase {

	private static AnnotationConfigApplicationContext context;
	private static AccountDAO accountDAO;
	Account account;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("pl.michalskrzypek");
		context.refresh();
		accountDAO = (AccountDAO) context.getBean("accountDAO");

	}

	@Test
	public void CRUDtest() {
		
		//ADDING NEW ACCOUNT
		account = new Account();
		account.setActive(true);
		account.setEmail("example@example.com");
		account.setPassword("1234");
		assertEquals("adding new account", true, accountDAO.addAccount(account));
		
		//UPDATING EMAIL
		account.setEmail("newExample@example.com");
		assertEquals("updating account", true, accountDAO.update(account));
		
		//READING ACCOUNT BY EMAIL
		assertEquals("reading account by email", "newExample@example.com", accountDAO.get("newExample@example.com").getEmail());
		
		//DELETING ACCOUNT
		assertEquals("deleting account", true, accountDAO.delete(account));
		
	}
	
}