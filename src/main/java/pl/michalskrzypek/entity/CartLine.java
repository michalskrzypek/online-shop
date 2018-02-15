package pl.michalskrzypek.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_line")
@Getter
@Setter
public class CartLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "cart_id")
	private int cartId;
	
	private double total;
	
/*	@Column(name = "product_id")
	private int productId;
	*/
	
	@OneToOne
	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "product_count")
	private int productCount;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@Column(name = "is_available")
	private boolean isAvailable;
	
}
