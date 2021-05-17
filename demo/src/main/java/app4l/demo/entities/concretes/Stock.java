package app4l.demo.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

//Selects JPA
@Entity

//Which table on DB
@Table(name="stock")

//Lombok getters and setters
@Data
public class Stock {
	
//	private UUID uuid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="companyId")
	private Company company;
	
	@OneToOne
	@JoinColumn(name="productId")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	@Column(name="units_in_stock")
	private int unitsInStock;

	public Stock() {
	}
	
	public Stock(Long id, Company company, Product product, Category category, int unitsInStock) {
		super();
		this.id = id;
		this.company = company;
		this.product = product;
		this.category = category;
		this.unitsInStock = unitsInStock;
	}
	
}
