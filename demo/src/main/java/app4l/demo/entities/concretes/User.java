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
@Table(name="user", schema = "public")

//Lombok getters and setters
@Data
public class User {
	

//	private UUID uuid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// Which column on DB
	@Column(name="id")
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="userAddressId")
	private UserAddress userAddress;

	public User() {
		
	}
	
	public User(Long id, String username, String firstName, String lastName, String phoneNumber, Company company,
			UserAddress userAddress) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.company = company;
		this.userAddress = userAddress;
	}

	
	
}
