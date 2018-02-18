package pl.michalskrzypek.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	
	@NotBlank(message = "Please enter a product name!")
	private String name;
	
	@NotBlank(message = "Please enter a product brand!")
	private String brand;
	
	@NotBlank(message = "Please enter description!")
	@JsonIgnore
	private String description;
	
	@Min(value = 1, message="Price must be greater than 1$")
	@Column(name = "unit_price")
	private double unitPrice;
	
	private int quantity;
	private boolean active;
	
	
	@JsonIgnore
	@Column(name = "category_id")
	private int categoryId;
	
	
/*	@ManyToOne
	private Category category;
	*/
	
	
	@JsonIgnore
	@Column(name = "supplier_id")
	private int supplierId;
	
	private int purchases;
	private int views;

	@Transient
	private MultipartFile multipartFile;
	
	public Product() {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString().substring(0,5).toUpperCase();
		this.code = "PROD_"+id;
	}

}
