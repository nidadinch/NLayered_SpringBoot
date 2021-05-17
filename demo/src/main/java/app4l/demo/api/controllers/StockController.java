package app4l.demo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app4l.demo.business.abstracts.StockService;
import app4l.demo.entities.concretes.Stock;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
	
	@Autowired
	private StockService stockService;

	public StockController(StockService stockService) {
		this.stockService = stockService;
	}
	
	// List of the stocks list
	@ApiOperation(value = "View a list of stocks", response = List.class)
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Stock>> getAll(){
			
		List<Stock> stocks = stockService.getAll();
			
		return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
	}
		
	@ApiOperation(value = "Get stock by stock's ID")
	@RequestMapping(value="/{stockId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Stock>> getStockById(@PathVariable("stockId") Long stockId) {
			
		Optional<Stock> stock = stockService.find(stockId);
			
		if (stock == null) {
			return new ResponseEntity<Optional<Stock>>(HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<Optional<Stock>>(stock, HttpStatus.OK);
	}
		
}
