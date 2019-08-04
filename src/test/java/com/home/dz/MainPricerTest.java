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


@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ServiceConfigTest.class)
public class MainPricerTest {

	@Autowired
	PricerServiceImpl pricerService;
	

	
	@Before
	public void setUp() throws Exception {
		Product mango1 = new Product("1", 5.0, 3, 3, UnitType.THREE, OptionalDouble.empty());
		Product mango2 = new Product("2", 5.0, 3, 5, UnitType.THREE, OptionalDouble.empty());
		Product grappe = new Product("3", 2.10, 1, 1, UnitType.KILOGRAM, OptionalDouble.of(1500.0));
		Map<String, Product> store = new HashMap<String, Product>();
		store.put("mango1", mango1);
		store.put("mango2", mango2);
		store.put("grappe", grappe);

	}

	@Test
	public void testSimplePricer() throws Exception {
		//fail("Not yet implemented");
	}

}
