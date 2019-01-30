package pl.michalskrzypek.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.michalskrzypek.dao.AddressDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Address;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO{

	@Autowired
	SessionFactory sessionFactory;

	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Address getBillingAddress(Account account) {
		try {
			String dbQuery = "FROM Address WHERE account_id = :account and is_billing = :isBilling";
			return sessionFactory.getCurrentSession().createQuery(dbQuery, Address.class)
					.setParameter("account", account).setParameter("isBilling", true).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateAddress(Address address) {

		try {
			sessionFactory.getCurrentSession().update(address);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().delete(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Address> getShippingAddresses(int accountId) {
		try {
			String dbQuery = "FROM Address WHERE account_id = :account and is_shipping = :isShipping";
			return sessionFactory.getCurrentSession().createQuery(dbQuery, Address.class)
					.setParameter("account", accountId).setParameter("isShipping", true).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Address getAddress(int addressId) {
		try {
			String dbQuery = "FROM Address WHERE Id = :Id";
			return sessionFactory.getCurrentSession().createQuery(dbQuery, Address.class)
					.setParameter("Id", addressId).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}
}
