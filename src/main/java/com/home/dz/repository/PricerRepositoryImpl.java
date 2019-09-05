package com.home.dz.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

import org.springframework.stereotype.Repository;

import com.home.dz.entity.Product;
import com.home.dz.enums.UnitType;

/**
 * @author amatoug
 * la classe Dao
 */
@Repository
public class PricerRepositoryImpl implements PricerRepository {

	@Override
	public Map<String, Product> getCataloguePrice() {
		Product mango1 = new Product("1", 2.50, 1, 3, UnitType.EACH, OptionalDouble.of(215.0));
		Product mango2 = new Product("1", 5.0, 3, 5, UnitType.THREE, OptionalDouble.of(645.0));
		Product grappe = new Product("2", 2.10, 1, 1, UnitType.KILOGRAM, OptionalDouble.of(1500.0));
		Map<String, Product> store = new HashMap<String, Product>();
		store.put("mango1", mango1);
		store.put("mango2", mango2);
		store.put("grappe", grappe);
		return store;
	}
}