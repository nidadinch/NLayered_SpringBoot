package app4l.demo.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app4l.demo.business.abstracts.ProductService;
import app4l.demo.dataAccess.abstracts.ProductDao;
import app4l.demo.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {
	
	private ProductDao productDao;
	
	@Autowired 
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAll() {
		List<Product> product = productDao.findAll();
		return product;
	}

	@Override
	public Optional<Product> find(Long id) {
		Optional<Product> product = productDao.findById(id);
        return product;
	}

	@Override
	public Product create(Product product) {
		
		return productDao.save(product);
	}

	@Override
	public Product update(Product product) {
		
		Optional<Product> updatedProduct = productDao.findById(product.getId());
		
		if(updatedProduct == null) {
			// Can not update product which is not exists
			return null;
		}
		
		return productDao.save(product);
		
	}

	@Override
	public void delete(Long id) {

		Optional<Product> productToBeDeleted = productDao.findById(id);
		
		
		// Can not delete product which is not exists
		if(productToBeDeleted == null) {
			return ;
		}
		
/*
 * 		Example check for user access
 * 
  		Optional<User> user = userDao.findById(userId);
 
		Long companyId = user.get().getCompany().getId();
		
		Optional<Product> product = productDao.findById(id);
		
		if (product.get().getCompany().getId() != companyId) {
		//	"403 This user doesn't have any access to do this operation";
		}
		
*/
		productDao.deleteById(id);
	}

	
}