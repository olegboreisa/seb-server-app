package com.seb.bank.product.model.accounts;

import com.seb.bank.product.model.ProductType;
import com.seb.bank.product.model.IProduct;

public class Account implements IProduct {

    private String name;
    private ProductType type;

    public Account(String name, ProductType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
