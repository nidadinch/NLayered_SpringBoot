package app4l.demo.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import app4l.demo.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Long>{
	
	
}
