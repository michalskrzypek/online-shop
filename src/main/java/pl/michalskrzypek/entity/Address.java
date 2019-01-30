package pl.michalskrzypek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Account account;

	@Column(name = "first_name")
	@NotBlank
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	private String lastName;

	@NotBlank
	private String street;

	@NotBlank
	private String city;

	@NotBlank
	private String country;

	@NotBlank
	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "is_billing")
	private boolean billing;

	@Column(name = "is_shipping")
	private boolean shipping;

}
