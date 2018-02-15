package pl.michalskrzypek.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pl.michalskrzypek.entity.Account;
import pl.michalskrzypek.entity.Address;
import pl.michalskrzypek.entity.Cart;
import pl.michalskrzypek.entity.CartLine;
import pl.michalskrzypek.entity.OrderDetail;

@Getter
@Setter
public class CheckoutModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Account account;
	private Address shipping;
	private Cart cart;
	private List<CartLine> cartLines;
	private OrderDetail orderDetail;
	private double checkoutTotal;
	
}