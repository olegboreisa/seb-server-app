package com.seb.bank.product.entity;

import com.seb.bank.product.model.IncomeType;
import com.seb.bank.product.model.ProductForm;
import com.seb.bank.product.model.ProductType;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType product;

    @Column(nullable = false)
    private byte validFrom;

    @Column(nullable = false)
    private boolean student;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private IncomeType income;

    public Product() { }

    public Product(ProductForm form) {
        this.name = form.getName();
        this.product = form.getProduct();
        this.validFrom = form.getValidFrom();
        this.student = form.isStudent();
        this.income = form.getIncome();
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
