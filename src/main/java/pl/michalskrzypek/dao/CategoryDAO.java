package pl.michalskrzypek.dao;

import java.util.List;

import pl.michalskrzypek.entity.Category;

public interface CategoryDAO {

	public boolean add(Category category);

	public boolean delete(int id);

	public boolean update(Category category);

	public List<Category> listActive();

	public Category get(int id);

}
