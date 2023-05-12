package com.seb.bank.product.model;

public enum IncomeType {
    ZERO(0),// 0
    LOW(1), // 1-12000
    MEDIUM(12001), // 12001-40000
    HIGH(40001); // 40000+

    private final int value;

    IncomeType(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}

//HIGH
//        Gold Credit Card Income > 40000 & Age > 17
//        Current Account Plus Income > 40000 & Age > 17

//MEDIUM
//        Credit Card Income > 12000 & Age > 17

//LOW
//        Debit Card Income < 12001 & Age > 17
//        Current Account Income > 0 & Age > 17

//        Junior Saver Account Age < 18 // 17,16,15
//        Student Account Student = Yes & Age > 17
//        Senior Account Age >= 65
