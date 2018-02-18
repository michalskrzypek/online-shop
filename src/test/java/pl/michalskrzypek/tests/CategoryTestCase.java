package pl.michalskrzypek.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.michalskrzypek.dao.CategoryDAO;
import pl.michalskrzypek.dao.ProductDAO;
import pl.michalskrzypek.entity.Category;
import pl.michalskrzypek.entity.Product;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("pl.michalskrzypek");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	

	@Test
	public void CRUDtest() {

		category = new Category();

		category.setName("TEST");
		category.setDescription("Category of TVs");
		category.setActive(true);

		//CREATING NEW CATEGORY
		assertEquals("Adding category", true, categoryDAO.add(category));

		//UPDATING CATEGORY
		category.setDescription("Updated TEST category");
		assertEquals("Updating category", true, categoryDAO.update(category));
		
		//READING CATEGORY
		assertEquals("reading category", "Updated TEST category", categoryDAO.get(category.getId()).getDescription());

		//DELETING CATEGORY
		assertEquals("deleting category", true, categoryDAO.delete(category.getId()));
		
	}
	
	/*
	  @Test public void testUpdateProduct() { product= productDAO.get(6);
	  product.setName("UPDATED");
	  assertEquals("updating a product", true,
	  productDAO.update(product));
	  
	  }*/
	 

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Cables");
	 * 
	 * assertEquals("Succesfully added category to a table", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.finById(1);
	 * assertEquals("Succesfully fetched a single category from a table", "Laptops",
	 * category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.finById(4);
	 * category.setDescription("Updated activity of the category");
	 * category.setActive(true);
	 * assertEquals("Succesfully fetched a single category from a table", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testDeleteCategory() {
	 * assertEquals("Succesfully fetched a single category from a table", true,
	 * categoryDAO.delete(1));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListAllCategories() {
	 * assertEquals("Succesfully fetched active categories from a table", 1,
	 * categoryDAO.listAll().size());
	 * 
	 * }
	 */

}
