package pl.michalskrzypek.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name = "order_total")
	private double total;
	
	@Column(name = "order_count")
	private int orderCount;
	
	@Column(name = "shipping_id")
	private int shippingId;
	
	@Column(name = "billing_id")
	private int billingId;
	
	@Column(name = "order_date")
	private Date orderDate;
	
}
