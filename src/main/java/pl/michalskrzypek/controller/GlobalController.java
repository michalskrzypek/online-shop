package pl.michalskrzypek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.dao.AddressDAO;
import pl.michalskrzypek.dao.CartLineDAO;
import pl.michalskrzypek.dao.CategoryDAO;
import pl.michalskrzypek.dao.ProductDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.CartLine;
import pl.michalskrzypek.entity.Category;
import pl.michalskrzypek.entity.Product;
import pl.michalskrzypek.model.AccountModel;
import pl.michalskrzypek.model.CheckoutModel;
import pl.michalskrzypek.service.ProductService;

@ControllerAdvice
public class GlobalController {
	
	Account account;
	
	@Autowired
	AccountDAO accountDAO;
	
	@Autowired
	AddressDAO addressDAO;

	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartLineDAO cartLineDAO;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	HttpSession session;
	
	@ModelAttribute("accountModel")
	public AccountModel getAccountModel() {
		 
		if(session.getAttribute("accountModel") == null) {
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			account = accountDAO.get(authentication.getName());
			
			if(account != null) {
				AccountModel model = new AccountModel();
				model.setId(account.getId());
				model.setFirstName(account.getFirstName());
				model.setLastName(account.getLastName());
				model.setUserRole(account.getUserRole());
				
				session.setAttribute("accountModel", model);
				
				if(model.getUserRole().equals("CUSTOMER")) {
					model.setCart(account.getCart());
				}
				
				return model;
			}
			
			
		}
		
		return (AccountModel) session.getAttribute("accountModel");
		
	}
	
	@ModelAttribute("checkoutModel")
	public CheckoutModel getCheckoutModel() {
		 
		if(session.getAttribute("checkoutModel") == null) {
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			account = accountDAO.get(authentication.getName());
			
			if(account != null) {
				CheckoutModel model = new CheckoutModel();
				model.setAccount(account);
				model.setCart(account.getCart());
				List<CartLine> cartLines = cartLineDAO.listAll(account.getCart().getId());
				if(cartLines != null) {
				model.setCartLines(cartLines);
				}
				model.setCheckoutTotal(account.getCart().getTotal());

				session.setAttribute("checkoutModel", model);

				return model;
			}
			
			
		}
		
		return (CheckoutModel) session.getAttribute("checkoutModel");
		
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.listActive();
	}
	
	@ModelAttribute("products")
	public List<Product> getProducts() {
		return productDAO.listActiveProducts();
	}
	
	@ModelAttribute("productsSortedByViews")
	public List<Product> getSortedProducts(){
		return productDAO.getAllActiveSortedByViews();
	}
}
