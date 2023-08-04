package com.example.springboot.model;

public class Meal {
    private String name;
    private String description;
    private double price;

    public Meal(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        if(price <= 0) {
            throw new IllegalArgumentException("Il prezzo del pasto non può essere minore o uguale a 0!");
        }
        this.price = price;
    }
}
