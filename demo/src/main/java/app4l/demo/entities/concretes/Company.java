package app4l.demo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

//Selects JPA
@Entity

//Which table on DB
@Table(name="company")

//Lombok getters and setters
@Data
public class Company {

//	private UUID uuid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="fax_number")
	private String faxNumber;
	
	@Column(name="contact_name")
	private String contactName;
		
	@Column(name="web_address")
	private String webAdress;
	
	@ManyToOne
	@JoinColumn(name="companyAddressId")
	private CompanyAddress companyAddress;
	
/*	@OneToMany(mappedBy="company")
	private List<Stock> stocks;
		
	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setCompany(this);
	
		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setCompany(null);

		return stock;
	}
*/	
	public Company() {
		
	}
	
	public Company(Long id, String companyName, String phoneNumber, String faxNumber, String contactName,
			String webAdress, CompanyAddress companyAddress) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.contactName = contactName;
		this.webAdress = webAdress;
		this.companyAddress = companyAddress;
	}

	
}
