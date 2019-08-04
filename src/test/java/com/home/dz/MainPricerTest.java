package com.home.dz;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;	

import org.junit.Test;

import com.home.dz.entity.Product;
import com.home.dz.enums.UnitType;

import junit.framework.TestCase;

public class MainPricerTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		Product mango1 = new Product("1", 5.0, 3, 3, UnitType.THREE, OptionalDouble.empty());
		Product mango2 = new Product("2", 5.0, 3, 5, UnitType.THREE, OptionalDouble.empty());
		Product grappe = new Product("3", 2.10, 1, 1, UnitType.KILOGRAM, OptionalDouble.of(1500.0));
		Map<String, Product> store = new HashMap<String, Product>();
		store.put("mango1", mango1);
		store.put("mango2", mango2);
		store.put("grappe", grappe);

	}

	@Test
	public void testSimplePricer() {
		fail("Not yet implemented");
	}

}
