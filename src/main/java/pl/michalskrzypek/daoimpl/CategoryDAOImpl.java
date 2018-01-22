package pl.michalskrzypek.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.michalskrzypek.dao.CategoryDAO;
import pl.michalskrzypek.entity.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	private static List<Category> categories = new ArrayList<Category>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Laptops");
		categories.add(category);
		category = new Category();
		category.setId(2);
		category.setName("Smartphones");
		categories.add(category);
		category = new Category();
		category.setId(3);
		category.setName("TVs");
		categories.add(category);
	}
	
	public List<Category> listAll() {
		// TODO Auto-generated method stub
		return categories;
	}

	public Category finById(int id) {
		// TODO Auto-generated method stub
		Category category = null;
		
		for (Category cat : categories) {
			if(cat.getId() == id) {
				category = cat;
			}
		}
		return category;
	}

}
