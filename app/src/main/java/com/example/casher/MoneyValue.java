package com.example.casher;

public class MoneyValue {
    private String section;
    private int value;
    private String currency;

    MoneyValue (String section, String currency, int value){
        this.section = section;
        this.currency = currency;
        this.value = value;
    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

