package pl.michalskrzypek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	
	@RequestMapping({"/", "home"})
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickedHome", true);
		mv.addObject("title", "Home");
		
		
		return mv;
	}
	
	@RequestMapping("about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickedAbout", true);
		mv.addObject("title", "About");
		
		
		return mv;
	}
	
	@RequestMapping("contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickedContact", true);
		mv.addObject("title", "Contact");
		
		
		return mv;
	}

/*	@RequestMapping({"/","/index"})
	public ModelAndView home(@RequestParam(value="greeting") String greeting) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
	
/*	@RequestMapping("/{greeting}")
	public ModelAndView homeParam(@PathVariable(value="greeting") String greeting) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("greeting", greeting);
		return mv;
	}
	*/
	
}
