package pl.michalskrzypek.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Address;
import pl.michalskrzypek.entity.Cart;

@Repository("accountDAO")
@Transactional
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	@Qualifier(value="passwordEncoder")
	private BCryptPasswordEncoder passwordEncoder;
	
	public boolean addAccount(Account account) {
		try {
			account.setPassword(passwordEncoder.encode(account.getPassword()));
			sessionFactory.getCurrentSession().persist(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Account account) {
		try {
			sessionFactory.getCurrentSession().update(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Account get(String email) {
		// TODO Auto-generated method stub
		String selectQuery = "FROM Account WHERE email = :email";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Account.class)
					.setParameter("email", email).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Account get(int id) {
		String selectQuery = "FROM Account WHERE id = :id";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Account.class).setParameter("id", id)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Account getActive(int id) {
		String selectQuery = "FROM Account WHERE id = :id and active = :active";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Account.class).setParameter("id", id).setParameter("active",true)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Account getActive(String email) {
		String selectQuery = "FROM Account WHERE email = :email and active = :active";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Account.class)
					.setParameter("email", email).setParameter("active",true).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	public boolean delete(Account account) {
		try {
			sessionFactory.getCurrentSession().delete(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Addresses management

	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Address getBillingAddress(int accountId) {
		String dbQuery = "FROM Address WHERE accountId = :accountId and isBilling = :isBilling";
		return sessionFactory.getCurrentSession().createQuery(dbQuery, Address.class).setParameter("accountId", accountId)
				.setParameter("isBilling", true).getSingleResult();
	}

	public boolean updateBillingAddress(Address address) {

		try {
			if (address.isBilling()) {
				sessionFactory.getCurrentSession().update(address);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean deleteAddress(Address address) {
		try {
		sessionFactory.getCurrentSession().delete(address);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public List<Address> getShippingAddresses(int accountId) {
		String dbQuery = "FROM Address WHERE accountId = :accountId and isShipping = :isShipping";
		return sessionFactory.getCurrentSession().createQuery(dbQuery, Address.class).setParameter("accountId", accountId)
				.setParameter("isShipping", true).getResultList();
	}

	
	//Cart management

/*	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}*/





	/*
	 * public boolean updateShippingAddress(Address address) {
	 * 
	 * try { if (address.isShipping()) {
	 * sessionFactory.getCurrentSession().update(address); return true; } else {
	 * return false; } } catch (Exception e) { e.printStackTrace(); return false; }
	 * 
	 * }
	 */

}
