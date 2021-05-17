package app4l.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import app4l.demo.entities.concretes.Company;

public interface CompanyDao extends JpaRepository<Company, Long>{

}
