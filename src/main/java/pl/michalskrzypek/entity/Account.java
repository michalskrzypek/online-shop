package pl.michalskrzypek.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name="role")
	private String userRole;
	
	private boolean active;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[A-Za-z]{2,6}$", message = "Enter proper email.")
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Column(name = "contact_number")
	private String phoneNumber;

	@OneToOne(mappedBy="account", cascade = CascadeType.ALL)
	Cart cart;
	
	@Transient
	private MultipartFile file;
	
	public Account() {
		Cart cart = new Cart();
		cart.setAccount(this);
		this.setCart(cart);
		
		this.active = true;
	}
	
}
