package com.home.dz.enums;

public enum UnitType {
	EACH, KILOGRAM(1000.0), POUND, OUNCE,THREE(3.0),DOZEN(12.0);
    private  Double value = 0.0 ;

    private UnitType() {
    }

    private UnitType(Double value) {
        this.value = value;
    }
}
