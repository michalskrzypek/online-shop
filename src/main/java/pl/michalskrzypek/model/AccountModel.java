package pl.michalskrzypek.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import pl.michalskrzypek.entity.Cart;

public class AccountModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;

	private String firstName;

	private String lastName;
	
	private String fullName;
	
	public String getFullName() {
		return firstName+" "+lastName;
	}


	private String userRole;
	
	private Cart cart;

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserRole() {
		return userRole;
	}

	public Cart getCart() {
		return cart;
	}
	
	
	
	
}
