package app4l.demo.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app4l.demo.business.abstracts.StockService;
import app4l.demo.dataAccess.abstracts.StockDao;
import app4l.demo.entities.concretes.Stock;

@Service
public class StockManager implements StockService{

	private StockDao stockDao;
	
	@Autowired
	public StockManager(StockDao stockDao) {
		this.stockDao = stockDao;
	}
	@Override
	public List<Stock> getAll() {
		List<Stock> stocks = stockDao.findAll();
		return stocks;
	}

	@Override
	public Optional<Stock> find(Long id) {
		Optional<Stock> stock = stockDao.findById(id);
		return stock;
	}
	
}
