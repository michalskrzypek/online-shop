package pl.michalskrzypek.dao;

import java.util.List;

import pl.michalskrzypek.entity.Category;

public interface CategoryDAO {

	public List<Category> listAll();
	
	public Category finById(int id);
	
}

