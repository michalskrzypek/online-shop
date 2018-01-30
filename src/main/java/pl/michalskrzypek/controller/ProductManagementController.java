package pl.michalskrzypek.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pl.michalskrzypek.dao.CategoryDAO;
import pl.michalskrzypek.dao.ProductDAO;
import pl.michalskrzypek.entity.Product;
import pl.michalskrzypek.utility.FileUploadUtility;

@Controller
@RequestMapping("/manage")
@SessionAttributes("product")
public class ProductManagementController {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView productsManagement() {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("title", "Product management");
		mv.addObject("userClickedManageProduct", true);
		mv.addObject("categories", categoryDAO.listActive());

		Product newProduct = new Product();
		mv.addObject("product", newProduct);
		return mv;

	}

	@RequestMapping("/product/{id}")
	public ModelAndView manageProductEdit(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("title", "Product Management");
		mv.addObject("categories", categoryDAO.listActive());
		mv.addObject("userClickedManageProduct", true);

		Product modifiedProduct = productDAO.get(id);

		mv.addObject("product", modifiedProduct);
		System.out.println(modifiedProduct.getCode());
		return mv;

	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ModelAndView addProduct(@Valid @ModelAttribute("product") Product product, BindingResult results) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("categories", categoryDAO.listActive());
		mv.addObject("title", "Product management");
		mv.addObject("userClickedManageProduct", true);

		
		if (!results.hasErrors()) {
			if (product.getId() == 0) {
				product.setSupplierId(3);
				product.setActive(true);
				productDAO.add(product);
				mv.addObject("message", "Successfully <b>added</b> product with ID:" + product.getId());
			} else {
				productDAO.update(product);
				mv.addObject("message", "Successfully <b>updated</b> product with ID:" + product.getId());
			}
		}

		if (!product.getMultipartFile().getOriginalFilename().equals("") && product.getMultipartFile() != null) {
			FileUploadUtility.UploadFile(product.getMultipartFile(), product.getCode());
		}

		Product newProduct = new Product();
		mv.addObject("product", newProduct);
		return mv;
	}

	@RequestMapping(value = "/product/activity/{id}", method = RequestMethod.POST)
	public ModelAndView changeProductActivity(@PathVariable("id") int id, @RequestParam("activity") String activity) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Product management");
		mv.addObject("userClickedManageProduct", true);
		mv.addObject("categories", categoryDAO.listActive());

		boolean isActive = new Boolean(activity);
		Product product = productDAO.get(id);

		if (isActive) {
			// for true
			product.setActive(true);
			mv.addObject("message", "Product: <b>" + product.getName() + "</b> is active now!");
		} else {
			product.setActive(false);
			mv.addObject("message", "Product: <b>" + product.getName() + "</b> was deactivated.");
		}

		productDAO.update(product);

		Product newProduct = new Product();
		mv.addObject("product", newProduct);

		return mv;

	}
	
	@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Product management");
		mv.addObject("userClickedManageProduct", true);
		mv.addObject("categories", categoryDAO.listActive());

		Product product = productDAO.get(id);
		
		mv.addObject("message", "Product: <b>" + product.getName() + "</b> was deleted!");
		productDAO.delete(product.getId());

		
		Product newProduct = new Product();
		mv.addObject("product", newProduct);

		return mv;

	}

}
