package pl.michalskrzypek.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.michalskrzypek.dao.ProductDAO;
import pl.michalskrzypek.entity.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			Product product = sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean findById(int id) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Product get(int id) {

		try {
			Product product = sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
			return product;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> listActiveProducts() {
		String activeProducts = "from Product where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(activeProducts);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	public List<Product> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		String activeProductsByCat = "from Product where active = :active and categoryId = :categoryId";
		Query query = sessionFactory.getCurrentSession().createQuery(activeProductsByCat);
		query.setParameter("active", true);
		query.setParameter("categoryId", categoryId);
		
		return query.getResultList();
	}

	public List<Product> getLatestActiveProducts(int count) {
		String latestActiveProd = "from Product where active = :active order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(latestActiveProd);
		query.setParameter("active", true);
		query.setFirstResult(0);
		query.setMaxResults(3);
		
		return query.getResultList();
	}

	public List<Product> listAll() {
		// TODO Auto-generated method stub
		
		String dbQuery = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(dbQuery);
		return query.getResultList();
		
		
	/*	String dbQuery = "from product";
		Query query = sessionFactory.getCurrentSession().createQuery(dbQuery);
		
		return query.getResultList();*/
	}

	public List<Product> getAllActiveSortedByViews() {

		String dbQuery = "from Product p order by p.views DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(dbQuery);
		return query.getResultList();
	}

}
