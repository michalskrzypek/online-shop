package pl.michalskrzypek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.michalskrzypek.dao.CategoryDAO;
import pl.michalskrzypek.dao.ProductDAO;
import pl.michalskrzypek.entity.Category;
import pl.michalskrzypek.entity.Product;

@Controller
public class HomeController {
	
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping({"/", "/home"})
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("categories", categoryDAO.listActive());
		mv.addObject("userClickedHome", true);
		mv.addObject("title", "Home");
		
		mv.addObject("products", productDAO.listActiveProducts());
		
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickedAbout", true);
		mv.addObject("title", "About");
		
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickedContact", true);
		mv.addObject("title", "Contact");
		
		return mv;
	}
	
	@RequestMapping("/show/product/{id}")
	public ModelAndView showProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("home");
		Product product = productDAO.get(id);
		int categoryId = product.getCategoryId();
		Category category = categoryDAO.get(categoryId);
		mv.addObject("userClickedShowProduct", true);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("category", category);
		mv.addObject("categories", categoryDAO.listActive());
		return mv;
	}
	
	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickedShowCategoryProducts", true);
		
		Category category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("category", category);
		mv.addObject("categories", categoryDAO.listActive());
		
		return mv;
	}
	
	@RequestMapping("/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("userClickedShowAll", true);
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.listActive());
		
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
