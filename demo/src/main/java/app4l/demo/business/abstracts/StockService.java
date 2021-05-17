package app4l.demo.business.abstracts;

import java.util.List;
import java.util.Optional;

import app4l.demo.entities.concretes.Stock;

public interface StockService {

	/* Get all stocks
	 * 
	 * @return list of all stocks
	 */
	public List<Stock> getAll();
	
	/* Find stock by id 
	 * 
	 * @param id of stock
	 * @return if any stock found the stock object returns, else return null
	 */
	 public Optional<Stock> find(Long id);
	 

}
