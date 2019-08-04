package com.home.dz.service;

import java.util.Map;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.dz.entity.Product;
import com.home.dz.enums.UnitType;
import com.home.dz.repository.PricerRepository;

@Service
public class PricerServiceImpl implements PricerService {

	@Autowired
	PricerRepository pricerDAO;

	private Map<String, Product> store = null;

	@Override
	public OptionalDouble getPriceOf(String barCode,UnitType unitType) {
		loadStore();
		switch (unitType)
	    {
		case EACH:return getSimplePrice(barCode);
		case THREE:return getComplexPriceByPackOfThree(barCode);
		case KILOGRAM:return getComplexPriceByWeight(barCode);

		default: return OptionalDouble.empty();
	    }
	}

	private OptionalDouble getComplexPriceByWeight(String barCode) {
		Product product = store.entrySet().stream()
				 .filter(s -> barCode.equals(s.getValue().getBarcode()) && UnitType.KILOGRAM.equals(s.getValue().getUnitType()))
				 .map(map -> map.getValue())
				 .findFirst().get();
		// price per unit * net weight / 1000
		Double price =product.getPricePerUnit()*product.getNetWeightInGrams().getAsDouble()/1000; 
		return OptionalDouble.of(price);
	}

	private OptionalDouble getSimplePrice(String barCode) {
		Product product = store.entrySet().stream()
				 .filter(s -> barCode.equals(s.getValue().getBarcode()) && UnitType.EACH.equals(s.getValue().getUnitType()))
				 .map(map -> map.getValue())
				 .findFirst().get();
		Double price = product.getPricePerUnit()*product.getQuantity();
		return OptionalDouble.of(price);
	}

	private OptionalDouble getComplexPriceByPackOfThree(String barCode) {
		Product productWithDiscountPrice = store.entrySet().stream()
				 .filter(s -> barCode.equals(s.getValue().getBarcode()) && UnitType.THREE.equals(s.getValue().getUnitType()))
				 .map(map -> map.getValue())
				 .findFirst().get();

		Integer quantity = productWithDiscountPrice.getQuantity();
		double price = 0.0;
		if (quantity > productWithDiscountPrice.getUnitQuantity()) {
			int discountNumber = quantity / productWithDiscountPrice.getUnitQuantity();
			int noDiscountNumber = quantity % productWithDiscountPrice.getUnitQuantity();
			Product productWithNormalPrice = store.entrySet().stream()
					 .filter(s -> barCode.equals(s.getValue().getBarcode()) && UnitType.EACH.equals(s.getValue().getUnitType()))
					 .map(map -> map.getValue())
					 .findFirst().get();

			price = price + (productWithDiscountPrice.getPricePerUnit()*discountNumber)+(productWithNormalPrice.getPricePerUnit()*noDiscountNumber);

		}
		return  OptionalDouble.of(price);
	}

	@Override
	public Map<String, Product> getCatalogPrices() {
		return pricerDAO.getCataloguePrice();
	}

	public synchronized Map<String, Product> loadStore() {
		if (store == null) {
			store = getCatalogPrices();
		}
		return store;
	}
}
