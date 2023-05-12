package com.seb.bank.product.model;

public class IncomeForm {

    private byte age;
    private boolean student;
    private IncomeType income;

    public IncomeForm() {
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
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
