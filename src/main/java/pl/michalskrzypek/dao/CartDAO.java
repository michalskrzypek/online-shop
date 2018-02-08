package pl.michalskrzypek.dao;

import pl.michalskrzypek.entity.Cart;

public interface CartDAO {

	//Cart management
	//I Excluded addCart method because a new cart is attached to an account everytime the account is created
/*	public boolean addCart(Cart cart);
	*/
	public boolean updateCart(Cart cart);
	
	public Cart getCart(int accountId);
	
}
