package com.home.dz;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.home.dz.config.ServiceConfigTest;
import com.home.dz.entity.Product;
import com.home.dz.enums.UnitType;
import com.home.dz.service.PricerServiceImpl;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfigTest.class)
public class MainPricerTest {

	@Autowired
	PricerServiceImpl pricerService;

	private Map<String, Product> store;

	@Before
	public void setUp() throws Exception {
		store = pricerService.getCatalogPrices();

	}

	public void testPricerServiceSimplePrice() throws Exception {
		Double price = pricerService.getPriceOf(store.get("mango1"));
		assertEquals("must be a simple price:  price per unit * 3", (Double) 7.50, (Double) price);
	}

	@Test
	public void testPricerServiceComplexPrice_UnitQuantityThree() throws Exception {
		Double price = pricerService.getPriceOf(store.get("mango2"));
		assertEquals(
				"must be a complex price : price for three mangos plus the price per unit * 2",
				(Double) 3.15, (Double) price);
	}

	@Test
	public void testPricerServiceComplexPrice_UnitQuantityKilogram() throws Exception {
		Double price = pricerService.getPriceOf(store.get("grappe"));
		assertEquals(
				"must be a complex price : price per unit * net weight / 1000 ",
				(Double) 10.0, (Double) price);
	}

}
