package com.home.dz.enums;

/**
 * @author amatoug
 * Enum qui stocke les valeurs des unités de vente
 *
 */
public enum UnitType {
	EACH, KILOGRAM(1000.0), POUND, OUNCE, THREE(3.0), DOZEN(12.0);
	private Double value = 0.0;

	private UnitType() {
	}

	private UnitType(Double value) {
		this.value = value;
	}
}
