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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.dao.AddressDAO;
import pl.michalskrzypek.dao.CartLineDAO;
import pl.michalskrzypek.dao.OrderDetailDAO;
import pl.michalskrzypek.dao.OrderItemDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Address;
import pl.michalskrzypek.entity.CartLine;
import pl.michalskrzypek.model.AccountModel;
import pl.michalskrzypek.model.CheckoutModel;
import pl.michalskrzypek.service.CheckoutService;

/**
 * 
 * @author Michal Skrzypek Controller manages checkout flow from the beginning
 *         to the end
 */

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

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
	
	@Autowired
	HttpSession session;


	@RequestMapping(value = "/cart_details", method = RequestMethod.GET)
	public ModelAndView showCartDetails() {
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("title", "Cart details");
		mv.addObject("showCartDetails", true);

		AccountModel model = (AccountModel) session.getAttribute("accountModel");
		
		List<CartLine> cartLines = cartLineDAO.listAll(model.getCart().getId());
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

		//creating new CheckoutModel which will be needed in the next steps of checkout process
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

		CheckoutModel model = (CheckoutModel) session.getAttribute("checkoutModel");

		if (addressId != null) {
			int id = Integer.parseInt(addressId);
			model.setShipping(addressDAO.getAddress(id));
			mv.addObject("title", "Confirm & Pay");
			mv.addObject("confirmAndPay", true);
			return mv;
		} else {
			mv.addObject("shippingAddresses", addressDAO.getShippingAddresses(model.getAccount().getId()));
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
		CheckoutModel model = (CheckoutModel) session.getAttribute("checkoutModel");
		
		if (!results.hasErrors()) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Account account = accountDAO.get(authentication.getName());
			address.setAccount(account);
			address.setShipping(true);
			address.setBilling(false);
			addressDAO.addAddress(address);
			model.setShipping(address);
			mv.addObject("title", "Confirm & Pay");
			mv.addObject("confirmAndPay", true);
			return mv;
		} else {
			mv.addObject("shippingAddresses", addressDAO.getShippingAddresses(model.getAccount().getId()));
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

}
