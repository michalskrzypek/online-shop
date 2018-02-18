package pl.michalskrzypek.entity;

import java.io.Serializable;

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
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@OneToOne
	private Product product;
	
	@Column(name = "product_count")
	private int productCount;
	
	@Column(name = "buying_price")
	private double price;

}
