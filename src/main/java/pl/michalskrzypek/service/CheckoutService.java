package pl.michalskrzypek.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.dao.AddressDAO;
import pl.michalskrzypek.dao.CartDAO;
import pl.michalskrzypek.dao.CartLineDAO;
import pl.michalskrzypek.dao.OrderDetailDAO;
import pl.michalskrzypek.dao.OrderItemDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Cart;
import pl.michalskrzypek.entity.CartLine;
import pl.michalskrzypek.entity.OrderDetail;
import pl.michalskrzypek.entity.OrderItem;
import pl.michalskrzypek.model.AccountModel;
import pl.michalskrzypek.model.CheckoutModel;

@Service
public class CheckoutService {
	
	@Autowired
	AccountDAO accountDAO;

	@Autowired
	AddressDAO addressDAO;

	@Autowired
	CartLineDAO cartLineDAO;

	@Autowired
	OrderDetailDAO orderDetailDAO;

	@Autowired
	OrderItemDAO orderItemDAO;

	@Autowired
	CartDAO cartDAO;

	@Autowired
	ProductService productService;

	public void placeOrder(CheckoutModel model, List<CartLine> itemsList) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountDAO.get(authentication.getName());
		
		OrderDetail order = new OrderDetail();
		order.setAccountId(account.getId());
		order.setBillingId(addressDAO.getBillingAddress(account).getId());
		order.setShippingId(model.getShipping().getId());
		order.setOrderDate(new Date());
		order.setOrderCount(model.getCartLines().size());
		order.setTotal(model.getCheckoutTotal());

		model.setOrderDetail(order);

		orderDetailDAO.add(order);

		for (CartLine line : itemsList) {
			OrderItem item = new OrderItem();
			item.setOrderId(order.getId());
			item.setPrice(line.getProductPrice());
			item.setProduct(line.getProduct());
			item.setProductCount(line.getProductCount());
			item.setTotalPrice(line.getTotal());
			orderItemDAO.add(item);
			cartLineDAO.delete(line.getId());

			productService.addPurchase(item.getProduct(), item.getProductCount());
		}

		Cart currentCart = model.getCart();
		currentCart.setCartLines(0);
		currentCart.setTotal(0);
		cartDAO.updateCart(currentCart);

		account.setCart(currentCart);
	}
}
