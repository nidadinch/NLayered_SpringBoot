package app4l.demo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//Selects JPA
@Entity

//Which table on DB
@Table(name="category")

//Lombok getters and setters
@Data
public class Category {

//	private UUID uuid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	public Category() {
		super();
	}
	
	public Category(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	
	
}
