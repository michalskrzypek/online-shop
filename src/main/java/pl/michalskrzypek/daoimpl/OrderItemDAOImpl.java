package pl.michalskrzypek.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.michalskrzypek.dao.OrderItemDAO;
import pl.michalskrzypek.entity.Category;
import pl.michalskrzypek.entity.OrderItem;

@Repository("orderItemDAO")
@Transactional
public class OrderItemDAOImpl implements OrderItemDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean add(OrderItem orderItem) {
		try {
			sessionFactory.getCurrentSession().persist(orderItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			OrderItem item = sessionFactory.getCurrentSession().get(OrderItem.class, Integer.valueOf(id));
			sessionFactory.getCurrentSession().delete(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(OrderItem orderItem) {
		try {
			sessionFactory.getCurrentSession().update(orderItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<OrderItem> list(int orderDetailId) {
		String dbQuery = "from OrderItem where orderDetailId = :id";

		Query query = sessionFactory.getCurrentSession().createQuery(dbQuery);
		query.setParameter("id", orderDetailId);
		return query.getResultList();
	}

	public OrderItem get(int id) {
		String dbQuery = "from OrderItem where id = :id";

		Query query = sessionFactory.getCurrentSession().createQuery(dbQuery);
		query.setParameter("id", id);
		return (OrderItem) query.getSingleResult();
	}

}
