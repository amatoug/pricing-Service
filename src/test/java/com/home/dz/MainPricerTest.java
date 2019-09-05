package com.home.dz;

import static org.junit.Assert.assertEquals;

import java.util.Map;

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

	@Test
	public void testPricerServiceSimplePrice() throws Exception {
		Product mango1 = store.get("mango1");
		Double price = pricerService.getPriceOf(mango1.getBarcode(), UnitType.EACH).getAsDouble();
		assertEquals("must be a simple price:  price per unit * 3", (Double) 7.50, (Double) price);
	}

	@Test
	public void testPricerServiceComplexPrice_UnitQuantityThree() throws Exception {
		Product mango2 = store.get("mango2");
		Double price = pricerService.getPriceOf(mango2.getBarcode(), UnitType.THREE).getAsDouble();
		assertEquals("must be a complex price : price for three mangos plus the price per unit * 2", (Double) 10.0,
				(Double) price);
	}

	@Test
	public void testPricerServiceComplexPrice_UnitQuantityThree2() throws Exception {
		Product kiwi = store.get("kiwi");
		Double price = pricerService.getPriceOf(kiwi.getBarcode(), UnitType.THREE).getAsDouble();
		assertEquals("must be a complex price : price for three kiwi * 2 plus the price per unit * 1", (Double) 5.19,
				(Double) price);
	}

	
	@Test
	public void testPricerServiceComplexPrice_UnitQuantityKilogram() throws Exception {
		Product grappe = store.get("grappe");
		Double price = pricerService.getPriceOf(grappe.getBarcode(), UnitType.KILOGRAM).getAsDouble();
		assertEquals("must be a complex price : price per unit * net weight / 1000 ", (Double) 3.15, (Double) price);
	}

}
