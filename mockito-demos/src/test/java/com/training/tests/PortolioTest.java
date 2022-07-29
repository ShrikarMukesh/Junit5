package com.training.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.model.Portfolio;
import com.training.model.Stock;
import com.training.service.StockService;

// Manual way of using Mockito. Use Mockito.mock() method.

public class PortolioTest {
	
	private Portfolio portfolio;
	private StockService stockService;
	
	@BeforeEach
	public void setUp() {
		portfolio = new Portfolio();
		stockService = mock(StockService.class);
		// System.out.println(stockService.getClass().getName());
	}
	
	@Test
	public void getMarketValue_Should_Return_CorrectMarketValue() {
		
		List<Stock> stocks = new ArrayList<>();
		
		Stock nifty = new Stock(1, "Nifty", 5);
		Stock royalEnfield = new Stock(2, "Royal Enfield", 2);
		Stock reliance = new Stock(3, "Reliance", 10); 
		
		stocks.add(nifty);   stocks.add(royalEnfield);   stocks.add(reliance);
		
		portfolio.setStocks(stocks);
		portfolio.setStockService(stockService);
		
		when(stockService.getStockPrice(nifty)).thenReturn(1500.0);
		when(stockService.getStockPrice(royalEnfield)).thenReturn(1_00_000.0);
		when(stockService.getStockPrice(reliance)).thenReturn(500.0);
		
		assertEquals(2_12_500.0, portfolio.getMarketValue(), 0.02);
	}
}

















