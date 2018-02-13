package pl.michalskrzypek.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.michalskrzypek.dao.CartLineDAO;
import pl.michalskrzypek.entity.CartLine;
import pl.michalskrzypek.entity.Product;

@Transactional
@Repository("cartLineDAO")
public class CartLineDAOImpl implements CartLineDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CartLine get(int id) {
		try {
			CartLine cartLine = sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
			return cartLine;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean add(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(int id) {
		try {
			CartLine cartLine = sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<CartLine> listAll(int cartId) {
		try {
			String cartLines = "from CartLine where cartId = :cartId";
			Query query = sessionFactory.getCurrentSession().createQuery(cartLines);
			query.setParameter("cartId", cartId);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<CartLine> listAvailable(int cartId) {
		try{String cartLines = "from CartLine where cartId = :cartId and isAvailable = :isAvailable";
		Query query = sessionFactory.getCurrentSession().createQuery(cartLines);
		query.setParameter("cartId", cartId);
		query.setParameter("isAvailable", true);

		return query.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}

	public CartLine get(int cartId, Product product) {
		
		try{String cartLines = "from CartLine where cartId = :cartId and product= :product";
		Query query = sessionFactory.getCurrentSession().createQuery(cartLines);
		query.setParameter("cartId", cartId);
		query.setParameter("product", product);

		return (CartLine) query.getSingleResult();
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}

}
