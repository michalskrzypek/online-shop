package pl.michalskrzypek.daoimpl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.michalskrzypek.dao.OrderDetailDAO;
import pl.michalskrzypek.entity.OrderDetail;
import pl.michalskrzypek.entity.OrderItem;


@Transactional
@Repository("orderDetailDAO")
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	SessionFactory sessionFactory;
	

	public boolean add(OrderDetail orderDetail) {
		try {
			sessionFactory.getCurrentSession().persist(orderDetail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			OrderDetail Detail = sessionFactory.getCurrentSession().get(OrderDetail.class, Integer.valueOf(id));
			sessionFactory.getCurrentSession().delete(Detail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(OrderDetail orderDetail) {
		try {
			sessionFactory.getCurrentSession().update(orderDetail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public OrderDetail get(int id) {
		String dbQuery = "from OrderDetail where id = :id";

		Query query = sessionFactory.getCurrentSession().createQuery(dbQuery);
		query.setParameter("id", id);
		return (OrderDetail) query.getSingleResult();
	}

	public boolean findById(int id) {
		String dbQuery = "from OrderDetail where id = :id";

		Query query = sessionFactory.getCurrentSession().createQuery(dbQuery);
		query.setParameter("id", id);
		if( (OrderDetail) query.getSingleResult() != null) {
			return true;
		}else {
			return false;
		}
	}

	public List<OrderItem> listAllItems(int orderId) {
		try {
		String dbQuery = "from OrderItem where orderId = :id";

		Query query = sessionFactory.getCurrentSession().createQuery(dbQuery);
		query.setParameter("id", orderId);
		return query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OrderDetail> listAllOrders(int accountId) {
		try {
			String dbQuery = "from OrderDetail where accountId = :id";
			Query query = sessionFactory.getCurrentSession().createQuery(dbQuery);
			query.setParameter("id", accountId);
			return query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
