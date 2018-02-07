package pl.michalskrzypek.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.michalskrzypek.dao.AccountDAO;
import pl.michalskrzypek.entity.Account;

public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private AccountDAO accountDAO;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Account account = accountDAO.getActive(email);
		GrantedAuthority ga = new SimpleGrantedAuthority(account.getUserRole());
		
		User user = new User(email, account.getPassword(), Arrays.asList(ga));
		
		
		UserDetails userDetails = (UserDetails) user;
		return userDetails;
	}

}
