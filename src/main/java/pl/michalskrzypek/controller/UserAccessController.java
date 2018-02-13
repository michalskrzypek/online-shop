package pl.michalskrzypek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.entity.Account;
/**
 * 
 * @author Michal Skrzypek
 *Controller responsible for registering new user
 */
@Controller
public class UserAccessController {

	@Autowired
	AccountDAO accountDAO;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView goSignUp(@RequestParam(name = "error", required = false) String param) {
		ModelAndView mv = new ModelAndView("access");
		if(param !=null) {
			mv.addObject("message", "Account with this email already exists.");
		}
		mv.addObject("title", "Sign Up");
		mv.addObject("action", "signup");
		Account account = new Account();
		mv.addObject("account", account);

		return mv;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(@Valid @ModelAttribute("account") Account account, BindingResult results, Model model) {

		if (!results.hasErrors()) {
			if(accountDAO.findByEmail(account.getEmail())) {
				model.addAttribute("account",account);
				return "redirect:/signup?error=account_taken";
			}else {
				accountDAO.addAccount(account);
				return "redirect:/home?success=register";
			
			}
		}else {
			model.addAttribute("title", "Sign Up");
			model.addAttribute("action", "signup");
			model.addAttribute("account",account);
			return "access";
	}}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		ModelAndView mv = new ModelAndView("access");
		mv.addObject("title", "Login");
		mv.addObject("action", "login");
/*		Account account = new Account();
		mv.addObject("account", account);*/

		return mv;
	}

}
