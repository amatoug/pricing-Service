package com.home.dz.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

import com.home.dz.enums.UnitType;

public class Product {
	String barcode;
	Double pricePerUnit;
	Integer unitQuantity;
	Integer quantity;
	UnitType unitType;
	OptionalDouble netWeightInGrams;
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
		this.netWeightInGrams = netWeightInGrams;
		propMap = new HashMap<>();
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Integer getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(Integer unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	public OptionalDouble getNetWeightInGrams() {
		return netWeightInGrams;
	}

	public void setNetWeightInGrams(OptionalDouble netWeightInGrams) {
		this.netWeightInGrams = netWeightInGrams;
	}

	@Override
	public String toString() {
		return "Product [barcode=" + barcode + ", pricePerUnit=" + pricePerUnit + ", unitQuantity=" + unitQuantity
				+ ", quantity=" + quantity + ", unitType=" + unitType + ", netWeightInGrams=" + netWeightInGrams
				+ ", propMap=" + propMap + "]";
	}

}
