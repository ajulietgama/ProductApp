package org.example;

public class Products {
    int id;
    String name;
    double basePrice;
    int type;

    public Products(int id, String name, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;

    }

    public double getPrice() {
        return basePrice;
    }

    public String getType() {
        return null;
    }

}
