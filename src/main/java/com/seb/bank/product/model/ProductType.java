package com.seb.bank.product.model;

public enum ProductType {
    ACCOUNT("ACCOUNT"),
    CARD("CARD");

    private final String value;

    ProductType(final String newValue) {
        value = newValue;
    }

    public String getValue() { return value; }
}
