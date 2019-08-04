package com.home.dz.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.dz.entity.Product;
import com.home.dz.repository.PricerRepository;

@Service
public class PricerServiceImpl implements PricerService {

	@Autowired
	PricerRepository pricerDAO;
	
	@Override
	public Double getPriceOf(Product item) {
		return null;
	}

	@Override
	public Map<String, Product> getCatalogPrices() {
		return pricerDAO.getCataloguePrice();
	}

}
