package pl.michalskrzypek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.michalskrzypek.dao.ProductDAO;
import pl.michalskrzypek.entity.Product;

@Controller
@RequestMapping("/json/data")
public class JSONDataController {

	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> listAllProducts(){
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> listProductsByCategory(@PathVariable("id") int id){
		return productDAO.listActiveProductsByCategory(id);
	}
	
}
