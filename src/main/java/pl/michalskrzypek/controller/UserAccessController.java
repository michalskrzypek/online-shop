package pl.michalskrzypek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.validation.AccountValidation;

@Controller
public class UserAccessController {
	
	@Autowired
	AccountDAO accountDAO;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView goSignUp() {
		ModelAndView mv = new ModelAndView("access");
		mv.addObject("title", "Sign Up");
mv.addObject("action", "signup");
		Account account = new Account();
		mv.addObject("account", account);

		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@Valid @ModelAttribute("account") Account account, BindingResult results, Model model) {

		AccountValidation accountValidation = new AccountValidation();
		accountValidation.validate(accountValidation, results);
		model.addAttribute("action", "signup");
		
		if(!results.hasErrors()) {
			accountDAO.addAccount(account);
			return "redirect:/home?success=register";
		}



		return "access";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		ModelAndView mv = new ModelAndView("access");
		mv.addObject("title", "Login");
		mv.addObject("action", "login");
		Account account = new Account();
		mv.addObject("account", account);

		return mv;
	}




	
}
