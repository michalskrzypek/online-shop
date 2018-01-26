package pl.michalskrzypek.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.michalskrzypek.dao.CategoryDAO;
import pl.michalskrzypek.entity.Category;

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
	public void testCRUDOperation() {

		category = new Category();

		category.setName("Hoodies");
		category.setDescription("Category of hoodies");
		category.setActive(true);

		// inserting new category
		assertEquals("Adding category", true, categoryDAO.add(category));

		// updating this category
		category.setDescription("Updated category");
		assertEquals("Updating category", true, categoryDAO.update(category));

		category = new Category();
		category.setName("T-shirts");
		category.setActive(true);
		category.setDescription("tshirts desc");
		// inserting new category
		assertEquals("Adding category", true, categoryDAO.add(category));
		
		//deleting category
		assertEquals("Deleting category", true, categoryDAO.delete(4));
		
		//reading active categories
		assertEquals("Listing active categories", 1, categoryDAO.listAll().size());

	}

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
