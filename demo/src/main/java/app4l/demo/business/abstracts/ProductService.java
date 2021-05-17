package app4l.demo.business.abstracts;

import java.util.List;
import java.util.Optional;

import app4l.demo.business.exceptions.ProductNotFoundException;
import app4l.demo.entities.concretes.Product;

public interface ProductService {
	
	
	/* Get all products
	 * 
	 * @return list of all products
	 */
	public List<Product> getAll();
	
	/* Find product by id 
	 * 
	 * @param id of product
	 * @return if any product found the product object returns, else return null
	 */
	 public Optional<Product> find(Long id);
	 
	/* Create a new product
	 * 
	 * @param the product to be created
	 */
	public Product create(Product product);
	
	/* Update an existing product
	 * 
	 * @param the product to be updated
	 * @return the updated product object
	 */
	public Product update(Product product) throws ProductNotFoundException;
	
	
	/* Delete an existing product
	 * 
	 * @param id of product to be deleted
	 */
	public void delete(Long id);

	
}
