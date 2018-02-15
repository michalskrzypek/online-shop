package pl.michalskrzypek.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import pl.michalskrzypek.entity.Cart;

@Getter
@Setter
public class AccountModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;

	private String firstName;

	private String lastName;

	private String userRole;
	
	private Cart cart;

	public String getFullName() {
		return this.firstName+" "+this.lastName;
	}
	

}
