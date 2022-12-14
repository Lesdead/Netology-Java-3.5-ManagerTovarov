package ru.netology.domain;

import ru.netology.domain.Product;

public class Smartphone extends Product {
    private String company;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String company) {
        super(id, name, price);
        this.company = company;
    }

    public Smartphone(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
