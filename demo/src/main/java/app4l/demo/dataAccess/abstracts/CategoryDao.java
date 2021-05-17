package app4l.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import app4l.demo.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Long>{

}
