package app4l.demo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import app4l.demo.business.abstracts.ProductService;
import app4l.demo.business.exceptions.ProductNotFoundException;
import app4l.demo.entities.concretes.Product;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// List of the products list
	@ApiOperation(value = "View a list of products", response = List.class)
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Product>> getAll(){
		
		List<Product> products = productService.getAll();
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get product by product's ID")
	@RequestMapping(value="/{productId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable("productId") Long productId) {
		
		Optional<Product> product = productService.find(productId);
		
		if (product == null) {
			return new ResponseEntity<Optional<Product>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add a product")
	@RequestMapping(path="/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
		Product productToBeAdded =	productService.create(product);
		
		if(productToBeAdded == null) {
			return new ResponseEntity<Product>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update a product")
	@RequestMapping(path="/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		
		Product productToBeUpdated;
		try {
			productToBeUpdated = productService.update(product);
			if(productToBeUpdated == null) {
				return new ResponseEntity<Product>(HttpStatus.FORBIDDEN);
			}
			return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<Product>(HttpStatus.FORBIDDEN);
			
		}
	}
	
	
	@ApiOperation(value = "Delete product by product's ID")
	@RequestMapping(path="/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Product> deleteItem(@PathVariable("productId") Long id) {
		
		 productService.delete(id);
		 return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}

}
