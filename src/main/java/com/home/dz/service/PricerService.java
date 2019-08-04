package com.home.dz.service;

import java.util.Map;
import java.util.OptionalDouble;

import com.home.dz.entity.Product;
import com.home.dz.enums.UnitType;

public interface PricerService {
	public OptionalDouble getPriceOf(String barCode,UnitType unitType);

	public Map<String, Product> getCatalogPrices();

}
