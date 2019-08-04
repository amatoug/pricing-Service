package com.home.dz.service;

import java.util.Map;

import com.home.dz.entity.Product;

public interface PricerService {
	public Double getPriceOf(Product item);

	public Map<String, Product> getCatalogPrices();

}
