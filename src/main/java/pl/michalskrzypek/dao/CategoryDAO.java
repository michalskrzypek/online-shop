package pl.michalskrzypek.dao;

import java.util.List;

import pl.michalskrzypek.entity.Category;

public interface CategoryDAO {

	public boolean add(Category category);

	public boolean delete(int id);

	public boolean update(Category category);

	public boolean read(int id);

	public List<Category> listAll();

	public Category finById(int id);

}
