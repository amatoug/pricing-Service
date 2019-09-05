package com.home.dz.repository;

import java.util.Map;

import com.home.dz.entity.Product;

public interface PricerRepository {
	public Map<String, Product> getCataloguePrice();
}