package pl.michalskrzypek.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

/**
 * 
 * @author Michal Skrzypek
 *Controller manages checkout flow from the beginning to the end
 */

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
		mv.addObject("title", "Cart details");
		mv.addObject("showCartDetails", true);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountDAO.get(authentication.getName());
		List<CartLine> cartLines = cartLineDAO.listAll(account.getCart().getId());
		mv.addObject("cartLines", cartLines);

		return mv;
	}

	@RequestMapping(value = "/confirm_cart", method = RequestMethod.POST)
	public ModelAndView confirmCart() {
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("title", "Select address");
		mv.addObject("selectAddress", true);
		
		
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
		Address newAddress = new Address();
		mv.addObject("address", newAddress);

		return mv;
	}

	@RequestMapping(value = "/select_address", method = RequestMethod.POST)
	public ModelAndView showDetails(@RequestParam(name = "address", required = false) String addressId) {
		ModelAndView mv = new ModelAndView("checkout");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountDAO.get(authentication.getName());

		if (addressId != null) {
			int id = Integer.parseInt(addressId);

			CheckoutModel model = (CheckoutModel) session.getAttribute("checkoutModel");
			model.setShipping(addressDAO.getAddress(id));
			mv.addObject("title", "Confirm & Pay");
			mv.addObject("confirmAndPay", true);
			return mv;
		} else {
			mv.addObject("shippingAddresses", addressDAO.getShippingAddresses(account.getId()));
			mv.addObject("title", "Select address");
			mv.addObject("selectAddress", true);
			mv.addObject("message", "Select one address!");
			Address newAddress = new Address();
			mv.addObject("address", newAddress);

			return mv;
		}
	}

	@RequestMapping(value = "/add/address", method = RequestMethod.POST)
	public ModelAndView addNewShippingAddress(@Valid @ModelAttribute("address") Address address,
			BindingResult results) {
		ModelAndView mv = new ModelAndView("checkout");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountDAO.get(authentication.getName());
		if (!results.hasErrors()) {
			CheckoutModel model = (CheckoutModel) session.getAttribute("checkoutModel");
			address.setAccountId(model.getAccount().getId());
			address.setShipping(true);
			address.setBilling(false);
			addressDAO.addAddress(address);
			model.setShipping(address);
			mv.addObject("title", "Confirm & Pay");
			mv.addObject("confirmAndPay", true);
			return mv;
		} else {
			mv.addObject("shippingAddresses", addressDAO.getShippingAddresses(account.getId()));
			mv.addObject("title", "Select address");
			mv.addObject("selectAddress", true);
			mv.addObject("message", "Address validation failed!!");
			Address newAddress = new Address();
			mv.addObject("address", newAddress);

			return mv;
		}

	}

	@RequestMapping(value = "/receipt", method = RequestMethod.POST)
	public ModelAndView showReceipt() {
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("showReceipt", true);
		mv.addObject("title", "Receipt");

		CheckoutModel model = (CheckoutModel) session.getAttribute("checkoutModel");
		checkoutService.placeOrder(model, model.getCartLines());
		mv.addObject("items", orderDetailDAO.listAllItems(model.getOrderDetail().getId()));
		mv.addObject("shipping", addressDAO.getAddress(model.getOrderDetail().getShippingId()));

		return mv;
	}

	@RequestMapping(value = "/receipt", method = RequestMethod.GET)
	public ModelAndView showReceiptGet() {
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("showReceipt", true);
		mv.addObject("title", "Receipt");
		
		CheckoutModel model = (CheckoutModel) session.getAttribute("checkoutModel");
		checkoutService.placeOrder(model, model.getCartLines());
		mv.addObject("items", orderDetailDAO.listAllItems(model.getOrderDetail().getId()));
		mv.addObject("shipping", addressDAO.getAddress(model.getOrderDetail().getShippingId()));

		return mv;
	}

}
