package pl.michalskrzypek.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.dao.AddressDAO;
import pl.michalskrzypek.dao.CartLineDAO;
import pl.michalskrzypek.dao.OrderDetailDAO;
import pl.michalskrzypek.dao.OrderItemDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Address;
import pl.michalskrzypek.entity.CartLine;
import pl.michalskrzypek.entity.OrderDetail;
import pl.michalskrzypek.entity.OrderItem;
import pl.michalskrzypek.model.AccountModel;
import pl.michalskrzypek.model.CheckoutModel;
import pl.michalskrzypek.service.CheckoutService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	HttpSession session;

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
	CheckoutService checkoutService;
	
	@RequestMapping(value = "/cart_details", method = RequestMethod.GET)
	public ModelAndView showCartDetails() {
		ModelAndView mv = new ModelAndView("checkout");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountDAO.get(authentication.getName());
		List<CartLine> cartLines = cartLineDAO.listAll(account.getCart().getId());
		mv.addObject("cartLines", cartLines);

		mv.addObject("title", "Cart details");
		mv.addObject("showCartDetails", true);

		return mv;
	}

	@RequestMapping(value = "/confirm_cart", method = RequestMethod.POST)
	public ModelAndView confirmCart() {
		ModelAndView mv = new ModelAndView("checkout");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountDAO.get(authentication.getName());

		CheckoutModel model = new CheckoutModel();
		model.setAccount(account);
		model.setCart(account.getCart());
		List<CartLine> cartLines = cartLineDAO.listAll(account.getCart().getId());
		model.setCartLines(cartLines);
		model.setCheckoutTotal(account.getCart().getTotal());
		session.setAttribute("checkoutModel", model);

		mv.addObject("shippingAddresses", addressDAO.getShippingAddresses(account.getId()));
		mv.addObject("title", "Select address");
		mv.addObject("selectAddress", true);

		Address newAddress = new Address();
		mv.addObject("address", newAddress);

		return mv;
	}

	@RequestMapping(value = "/select_address", method = RequestMethod.POST)
	public ModelAndView showDetails(@RequestParam("address") String addressId) {
		ModelAndView mv = new ModelAndView("checkout");
		int id = Integer.parseInt(addressId);
		
		CheckoutModel model = (CheckoutModel) session.getAttribute("checkoutModel");
		model.setShipping(addressDAO.getAddress(id));
		mv.addObject("title", "Confirm & Pay");
		mv.addObject("confirmAndPay", true);
		return mv;
	}
	
	@RequestMapping(value = "/receipt", method = RequestMethod.POST)
	public ModelAndView showReceipt() {
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("showReceipt", true);
		
		CheckoutModel model = (CheckoutModel) session.getAttribute("checkoutModel");
		
		System.out.println(model.getShipping().getId());
		
		checkoutService.placeOrder(model, model.getCartLines());
		mv.addObject("items", orderDetailDAO.listAllItems(model.getOrderDetail().getId()));
		mv.addObject("title", "Receipt");
		mv.addObject("shipping", addressDAO.getAddress(model.getOrderDetail().getShippingId()));
		
		return mv;
	}

}
