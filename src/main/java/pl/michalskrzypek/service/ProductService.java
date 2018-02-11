package pl.michalskrzypek.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.michalskrzypek.dao.ProductDAO;
import pl.michalskrzypek.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;
	
	public void addView(Product product) {
		product.setViews(product.getViews()+1);
		productDAO.update(product);
	}
}
