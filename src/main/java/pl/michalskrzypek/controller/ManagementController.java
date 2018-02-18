package pl.michalskrzypek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.michalskrzypek.dao.CategoryDAO;
import pl.michalskrzypek.dao.ProductDAO;
import pl.michalskrzypek.entity.Category;
import pl.michalskrzypek.entity.Product;
import pl.michalskrzypek.utility.FileUploadUtility;

/**
 * 
 * @author Michal Skrzypek ManagementController is responsible for managing
 *         products and categories (adding, updating, deleting)
 */
@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView productsManagement(@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "name", required = false) String name) {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("title", "Product management");
		mv.addObject("userClickedManageProduct", true);

		if (success != null) {
			if (success.equals("addProduct")) {
				mv.addObject("message", "Product <b>" + name + "</b> added successfully!");
			} else if (success.equals("addCategory")) {
				mv.addObject("message", "Category added successfully!");
			} else if (success.equalsIgnoreCase("deleteProduct")) {
				mv.addObject("message", "Product <b>" + name + "</b> has been deleted successfully!");
			} else if (success.equalsIgnoreCase("updateProduct")) {
				mv.addObject("message", "Product <b>" + name + "</b> has been updated successfully!");
			}
		}

		Product newProduct = new Product();
		mv.addObject("product", newProduct);
		return mv;

	}

	@RequestMapping("/product/{id}")
	public ModelAndView manageProductEdit(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("title", "Product Management");
		mv.addObject("userClickedManageProduct", true);

		Product modifiedProduct = productDAO.get(id);

		mv.addObject("product", modifiedProduct);
		return mv;

	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult results, Model model) {

		String returnStatement = "";

		if (!results.hasErrors()) {
			if (product.getId() == 0) {
				product.setSupplierId(3);
				product.setActive(true);
				productDAO.add(product);

				if (!product.getMultipartFile().getOriginalFilename().equals("")
						&& product.getMultipartFile() != null) {
					FileUploadUtility.UploadFile(product.getMultipartFile(), product.getCode());
				}

				returnStatement = "redirect:/manage/products?success=addProduct&name=" + product.getName();
			} else {
				productDAO.update(product);

				if (!product.getMultipartFile().getOriginalFilename().equals("")
						&& product.getMultipartFile() != null) {
					FileUploadUtility.UploadFile(product.getMultipartFile(), product.getCode());
				}

				returnStatement = "redirect:/manage/products?success=updateProduct&name=" + product.getName();
			}
		} else {
			model.addAttribute("title", "Products management");
			model.addAttribute("message", "Validation fails for adding the product!");
			model.addAttribute("userClickedManageProduct", true);
			return "home";

		}

		return returnStatement;
	}

	@RequestMapping(value = "/product/activity/{id}", method = RequestMethod.POST)
	public ModelAndView changeProductActivity(@PathVariable("id") int id, @RequestParam("activity") String activity) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Product management");
		mv.addObject("userClickedManageProduct", true);

		boolean isActive = new Boolean(activity);
		Product product = productDAO.get(id);
		product.setActive(isActive);

		if (isActive) {
			// for true
			mv.addObject("message", "Product: <b>" + product.getName() + "</b> is active now!");
		} else {
			mv.addObject("message", "Product: <b>" + product.getName() + "</b> was deactivated.");
		}

		productDAO.update(product);

		Product newProduct = new Product();
		mv.addObject("product", newProduct);

		return mv;

	}

	@RequestMapping(value = "/product/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {

		Product product = productDAO.get(id);
		String name = product.getName();
		productDAO.delete(product.getId());

		return "redirect:/manage/products?success=deleteProduct&name=" + name;

	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addNewCategory(@Valid @ModelAttribute("category") Category category, BindingResult results,
			Model model) {

		if (!results.hasErrors()) {
			categoryDAO.add(category);
			String name = category.getName();
			return "redirect:/manage/products?success=addCategory&name=" + name;
		} else {
			model.addAttribute("userClickedManageProduct", true);
			model.addAttribute("message", "Category validation failed");
			model.addAttribute("title", "Products Management");
			return "home";
		}

	}

	@ModelAttribute("category")
	public Category getCategory() {
		Category newCategory = new Category();
		newCategory.setActive(true);
		return newCategory;
	}

}
