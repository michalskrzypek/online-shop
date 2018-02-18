package pl.michalskrzypek.tests;

import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import pl.michalskrzypek.dao.CartLineDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Address;
import pl.michalskrzypek.entity.Cart;
import pl.michalskrzypek.entity.CartLine;
import pl.michalskrzypek.entity.OrderDetail;
import pl.michalskrzypek.entity.Product;
import pl.michalskrzypek.model.CheckoutModel;
import pl.michalskrzypek.service.CheckoutService;

public class CheckoutTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CheckoutService checkoutService;

	private static CheckoutModel checkoutModel;

	private static CartLineDAO cartLineDAO;
	
	HttpSession httpSession;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("pl.michalskrzypek");
		context.refresh();

		checkoutService = (CheckoutService) context.getBean("checkoutService");
		
		checkoutModel = new CheckoutModel();
		
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
	}
	
/*	@Test
	public void placeOrderTestCase() {

		Account account = new Account();
		Cart cart = account.getCart();
		cart.setAccount(account);
		cart.setCartLines(2);
		cart.setTotal(1000);
		
		CartLine line1 = new CartLine();
		line1.setCartId(cart.getId());
		line1.setAvailable(true);
		line1.setProduct(new Product());
		line1.setProductCount(1);
		line1.setProductPrice(1000);
		line1.setTotal(1000);
		
		checkoutModel.setAccount(account);
		checkoutModel.setCart(account.getCart());
		checkoutModel.setCartLines(cartLineDAO.listAll(cart.getId()));
		checkoutModel.setCheckoutTotal(cart.getTotal());
		checkoutModel.setOrderDetail(new OrderDetail());
		checkoutModel.setShipping(new Address());
		
		checkoutService.placeOrder(checkoutModel, cartLineDAO.listAll(cart.getId()));
		
	}*/

}
