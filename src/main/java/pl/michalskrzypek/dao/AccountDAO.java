package pl.michalskrzypek.dao;



import java.util.List;

import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Address;
import pl.michalskrzypek.entity.Cart;

public interface AccountDAO {

	public boolean addAccount(Account account);
	
	public Account get(int id);
	
	public Account get(String email);
	
	public Account getActive(int id);
	
	public Account getActive(String email);
	
	public boolean findByEmail(String email);
	
	public boolean delete(Account account);
	
	public boolean update(Account account);
	
	

	
	

	

	


}
