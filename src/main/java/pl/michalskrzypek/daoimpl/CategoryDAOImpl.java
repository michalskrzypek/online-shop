package pl.michalskrzypek.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.michalskrzypek.dao.CategoryDAO;
import pl.michalskrzypek.entity.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	public List<Category> listActive() {
		
		String selectActiveCategory = "from Category where active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		
		return query.getResultList();
	}

	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try {
			// add the category to our db table
			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			// add the category to our db table
			Category category = sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
			sessionFactory.getCurrentSession().delete(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			// add the category to our db table
			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


/*	public boolean changeActivity(String name) {
		// TODO Auto-generated method stub

		try {
			Category category = sessionFactory.getCurrentSession().get(Category.class, name);
			category.setActive(!category.isActive());

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}*/

}
