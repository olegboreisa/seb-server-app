package com.seb.bank.product.model;

import com.seb.bank.product.entity.Product;

public class ProductData {

    private long id;
    private String name;
    private ProductType product;
    private byte validFrom;
    private boolean student;
    private IncomeType income;

    public ProductData() { }

    public ProductData(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.product = product.getProduct();
        this.validFrom = (byte) product.getValidFrom();
        this.student = product.isStudent();
        this.income = product.getIncome();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProduct() {
        return product;
    }

    public void setProduct(ProductType product) {
        this.product = product;
    }

    public byte getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(byte validFrom) {
        this.validFrom = validFrom;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public IncomeType getIncome() {
        return income;
    }

    public void setIncome(IncomeType income) {
        this.income = income;
    }
}
