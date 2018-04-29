package edu.unifeso.engsoft.labmock;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import org.easymock.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(EasyMockRunner.class)
public class PortfolioTest {
	   private Portfolio portfolio;
	   
	   @Mock
	   private StockService mockedStockService;
	   
	   @Before
	   public void setUp(){
	      //Create a portfolio object which is to be tested		
	      portfolio = new Portfolio();		
	  
	      //Create the mock object of stock service
	      mockedStockService = mock(StockService.class);		
	  
	      //set the stockService to the portfolio
	      portfolio.setStockService(mockedStockService);
	   }
	   
	@Test
	   public void testMarketValue(){
	    	   
	      //Creates a list of stocks to be added to the portfolio
	      List<Stock> stocks = new ArrayList<Stock>();
	      Stock googleStock = new Stock("1","Google", 10);
	      Stock microsoftStock = new Stock("2","Microsoft",100);	
	 
	      stocks.add(googleStock);
	      stocks.add(microsoftStock);

	      //add stocks to the portfolio
	      portfolio.setStocks(stocks);

	      //mock the behavior of stock service to return the value of various stocks
	      expect(mockedStockService.getPrice(googleStock)).andReturn(50.00);
	      expect(mockedStockService.getPrice(microsoftStock)).andReturn(1000.00);		

	      replay(mockedStockService);
	      double marketValue = portfolio.getMarketValue();
	      
	      assertEquals(100500.0, marketValue, 0.0);
	   }
}
