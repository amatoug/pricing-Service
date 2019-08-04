package com.home.dz.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

import com.home.dz.enums.UnitType;

public  class Product {
	String barcode;
	Double pricePerUnit;
	Integer unitQuantity;
	Integer quantity;
	UnitType unitType;
	Double netWeightInGrams;
	Map<String, Object> propMap;

	public void add2propMap(String key, Object value) {
		propMap.put(key, value);
	}

	public Product(String barcode, Double pricePerUnit, Integer unitQuantity, Integer quantity, UnitType unitType,
			OptionalDouble netWeightInGrams) {
		super();
		this.barcode = barcode;
		this.pricePerUnit = pricePerUnit;
		this.unitQuantity = unitQuantity;
		this.quantity = quantity;
		this.unitType = unitType;
		this.netWeightInGrams = netWeightInGrams.getAsDouble();
		propMap = new HashMap<>();
	}

	@Override
	public String toString() {
		return "Product [barcode=" + barcode + ", pricePerUnit=" + pricePerUnit + ", unitQuantity=" + unitQuantity
				+ ", quantity=" + quantity + ", unitType=" + unitType + ", netWeightInGrams=" + netWeightInGrams
				+ ", propMap=" + propMap + "]";
	}

}
