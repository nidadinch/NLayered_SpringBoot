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
@Table(name="company_address")

//Lombok getters and setters
@Data
public class CompanyAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="address")
	private String address;

	public CompanyAddress() {
		
	}
	
	public CompanyAddress(Long id, String city, String country, String postalCode, String address) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.address = address;
	}
	
}
