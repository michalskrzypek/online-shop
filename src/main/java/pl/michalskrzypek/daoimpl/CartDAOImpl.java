package pl.michalskrzypek.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.michalskrzypek.dao.CartDAO;
import pl.michalskrzypek.entity.Cart;


@Transactional
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Cart getCart(int accountId) {
		String dbQuery = "FROM Cart where account_id = :accountId";
		Query query = sessionFactory.getCurrentSession().createQuery(dbQuery, Cart.class);
		query.setParameter("accountId", accountId);
		return (Cart) query.getSingleResult();
	}


}
