package pl.michalskrzypek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {

	/**
	 * @Id Id is to indicate the primary key of the entity
	 * @GeneratedValue with strategy of IDENTITY is to indicate that this key is
	 *                 auto incremented (in mysql db)
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter a category name!")
	private String name;
	
	@NotBlank(message = "Please enter a category description!")
	private String description;
	
	@Column(name = "image_url")
	private String imageURL;
	private boolean active;

}
