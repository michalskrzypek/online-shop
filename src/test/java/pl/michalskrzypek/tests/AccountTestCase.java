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
	Address address;
	Cart cart;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("pl.michalskrzypek");
		context.refresh();
		accountDAO = (AccountDAO) context.getBean("accountDAO");

	}
	
/*	@Test
	public void testAddAddress() {
			
		address = new Address();
		
		address.setAccountId(10);
		address.setCity("LA");
		address.setCountry("USA");
		address.setPostalCode("12346");
		address.setBilling(true);
		address.setStreet("Highway 120");

		
		assertEquals("Adding an address", true, accountDAO.addAddress(address));
		
		
	}*/
/*	
	@Test
	public void testUpdateAddress() {
			
		address = accountDAO.getBillingAddress(10);

		address.setCity("Los Angeles");

		
		assertEquals("Updating an address", true, accountDAO.updateBillingAddress(address));
		
		
	}*/
/*
	@Test
	public void testDeleteAddress() {
			
		address = accountDAO.getBillingAddress(10);

		
		assertEquals("Deleting an address", true, accountDAO.deleteAddress(address));
		
		
	}
	*/

	/*
	 * @Test public void testAddAccount() {
	 * 
	 * account = new Account(); 
	 * account.setFirstName("Michal");
	 * account.setLastName("Skrzypek"); account.setActive(true);
	 * account.setEmail("mskrzypek97@gmail.com"); account.setPassword("123");
	 * account.setPhoneNumber("668229833"); account.setUserRole("USER");
	 * assertEquals("Adding account to DB", true, accountDAO.addAccount(account));
	 * 
	 * }
	 */
/*
	@Test
	public void testAddCart() {

		
		cart = new Cart();
	cart.setAccountId(10);
	cart.setGrandTotal(1500);
	assertEquals("Adding cart",true, accountDAO.addCart(cart));

	}*/
	
/*
	@Test
	public void testUpdateCart() {


		cart = accountDAO.getCart(10);
		
		cart.setGrandTotal(250);
		
		assertEquals("Adding cart", true,accountDAO.updateCart(cart));

	}
*/
	
/*	  @Test public void testDeleteAccount() {
	  
	  account = accountDAO.get(9);
	  
	  
	  
	  assertEquals("Deleting account", true, accountDAO.delete(account));
	  
	  }*/
	 

	/*
	 * 
	 * 
	 * public void testAddAddress() { account = new Account();
	 * account.setFirstName("Michal"); account.setLastName("Skrzypek");
	 * account.setActive(true); account.setEmail("mskrzypek97@gmail.com");
	 * account.setPassword("123"); account.setPhoneNumber("668229833");
	 * account.setUserRole("USER");
	 * 
	 * cart = new Cart();
	 * 
	 * cart.setAccount(account); account.setCart(cart);
	 * 
	 * assertEquals("Adding account to DB", true, accountDAO.addAccount(account));
	 * 
	 * address = new Address(); address.setAccountId(account.getId());
	 * address.setBilling(true); address.setCity("Poznan");
	 * 
	 * assertEquals("Adding address to DB", true, accountDAO.addAddress(address));
	 * 
	 * cart = new Cart(); cart.setAccount(account); assertEquals("lolol", true,
	 * accountDAO.addCart(cart)); }
	 */

}
