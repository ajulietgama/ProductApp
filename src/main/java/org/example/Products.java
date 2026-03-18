package org.example;

import java.io.Serial;
import java.io.Serializable;

public class Products implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; //persistance

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
