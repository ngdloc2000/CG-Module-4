package com.codegym.model;

public class Product {
    private String name;
    private String des;

    public Product(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
