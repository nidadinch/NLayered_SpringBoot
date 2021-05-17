package app4l.demo.entities.concretes;


import javax.persistence.*;


import lombok.Data;

//Selects JPA
@Entity

//Which table on DB
@Table(name="product")

//Lombok getters and setters
@Data
public class Product {
	
	
//	private UUID uuid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="stock_id")
	private Long stockId;
	
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;
	
	@Column(name="price")
	private double price;
		
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;

	public Product() {
		
	}
	
	public Product(Long id, String name, Long stockId, Company company, double price, boolean isDeleted,
			String description, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.stockId = stockId;
		this.company = company;
		this.price = price;
		this.isDeleted = isDeleted;
		this.description = description;
		this.category = category;
	}
}
