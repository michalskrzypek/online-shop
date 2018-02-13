package pl.michalskrzypek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.michalskrzypek.dao.CartLineDAO;
import pl.michalskrzypek.dao.ProductDAO;
import pl.michalskrzypek.entity.CartLine;
import pl.michalskrzypek.entity.Product;
import pl.michalskrzypek.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CartLineDAO cartLineDAO;;

	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "product", required = false) String prodName) {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("title", "Cart");
		mv.addObject("userClickedShowCart", true);
		mv.addObject("cartlines", cartService.getCartLines());

		if (success != null) {
			if (success.equals("add")) {
				mv.addObject("message", "Product: " + prodName + " has been added to the cart.");
			} else if (success.equals("delete")) {
				mv.addObject("message", "Product: " + prodName + " has been deleted from the cart.");
			} else if (success.equals("update")) {
				mv.addObject("message", "Cart has been updated.");
			}

		}

		if (error != null) {
			if (error.equals("add")) {
				mv.addObject("message", "Product: " + prodName + " has already been added to the cart.");
			}
		}
		return mv;
	}

	@RequestMapping("/add/product/{id}")
	public String addCartLine(@PathVariable("id") int id) {
		Product product = productDAO.get(id);

		if (cartService.checkProductInCartLine(product)) {
			return "redirect:/cart/show?error=add&product=" + product.getName();
		} else {
			cartService.addCartLine(product);
			return "redirect:/cart/show?success=add&product=" + product.getName();
		}

	}

	@RequestMapping("/delete/cartline/{id}")
	public String deleteCartLine(@PathVariable("id") int id) {
		CartLine cartline = cartLineDAO.get(id);
		Product cartLineProduct = cartline.getProduct();

		cartService.deleteCartLine(cartline);

		return "redirect:/cart/show?success=delete&product=" + cartLineProduct.getName();
	}

	@RequestMapping("/update/cartline/{id}")
	public String updateCartLine(@PathVariable("id") int id,
			@RequestParam(name = "quantity", required = true) int quantity) {

		cartService.updateCartLine(id, quantity);

		return "redirect:/cart/show?success=update";
	}

}
