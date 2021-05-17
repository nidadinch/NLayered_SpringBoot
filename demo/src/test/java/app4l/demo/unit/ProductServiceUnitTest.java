package app4l.demo.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import app4l.demo.business.concretes.ProductManager;
import app4l.demo.dataAccess.abstracts.ProductDao;
import app4l.demo.entities.concretes.Category;
import app4l.demo.entities.concretes.Company;
import app4l.demo.entities.concretes.CompanyAddress;
import app4l.demo.entities.concretes.Product;

@SpringBootTest
public class ProductServiceUnitTest {
	
	Company company = null;
	CompanyAddress companyAddress = null;
	Category category = null;
	Product product1 = null; 
	Product product2 = null; 

	@Mock
	private ProductDao productDao;
	
	@InjectMocks
	private ProductManager productManager;
	
	@BeforeEach
	public void setup() {
		
		companyAddress = new CompanyAddress(1L, "Antalya", "Turkey", "07090", "Lorem Ipsum");
		company = new Company(1L, "acme", "902421234567", null, "john doe", "www.acme.com", companyAddress);
		category = new Category(1L, "Food", null);
		product1 = new Product(1L, "Yoghurt", 1L, company, 5.0, false, "Sutas Yoghurt", category); 
		product2 = new Product(2L, "Milk", 2L, company, 5.90, false, "Sutas Milk", category); 

	}
	
	@Test
	public void getAllProductsTest() {
		
		List <Product> products = new ArrayList<Product>();
				
		products.add(product1);
		products.add(product2);
		
		when(productManager.getAll()).thenReturn(products);
		
		//test
		List<Product> productList = productManager.getAll();
		
		assertEquals(2, productList.size());
		verify(productDao, times(1)).findAll();

	}
	
	@Test 
	public void getProductByIdTest(){
		
		when(productManager.find(1L)).thenReturn(Optional.of(product1));
				
		assertEquals(productManager.find(1L).get(), product1);
		
	}
	
	@Test 
	public void createProductTest() {
		
		when(productDao.save(product1)).thenReturn(product1);
		
		Product returnedProduct = productManager.create(product1);
		
		assertEquals(product1, returnedProduct);
		
	
	}
	
	@Test
	public void updateExistingProductTest() {
		
		when(productDao.save(product1)).thenReturn(product1);
		
		Product returnedProduct = productManager.update(product1);
		
		assertEquals(product1, returnedProduct);
		
	}
	
	@Test
	public void deleteExistingProductTest() {
				
		productManager.delete(product1.getId());
		
		verify(productDao, times(1)).deleteById(product1.getId());
		
	}

}
