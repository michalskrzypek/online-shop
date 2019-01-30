package pl.michalskrzypek.daoimpl;

import java.util.List;

/*import javax.persistence.Query;*/

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
	@Qualifier(value = "passwordEncoder")
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

	public boolean findByEmail(String email) {
		if (this.get(email) == null) {
			return false;
		} else {
			return true;
		}
	}

	public Account get(String email) {
		String selectQuery = "FROM Account WHERE email = :email";
		try {
			System.out.println("EMAIL TO : " + email);
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
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Account.class).setParameter("id", id)
					.setParameter("active", true).getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Account getActive(String email) {
		String selectQuery = "FROM Account WHERE email = :email and active = :active";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Account.class)
					.setParameter("email", email).setParameter("active", true).getSingleResult();

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

}
