package pl.michalskrzypek.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.model.AccountModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	HttpSession session;
	
	Account account;
	
	@Autowired
	AccountDAO accountDAO;
	
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
}
