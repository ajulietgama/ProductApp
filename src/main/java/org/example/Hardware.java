package org.example;

public class Hardware extends Products{
    public double weight;

    public Hardware(int id, String name, double basePrice, double weight) {
        super(id, name, basePrice);
        this.weight = weight;

    }

    @Override
    public double getPrice() {
        return basePrice*1.10;
    }

    @Override

    public String getType() {
        return "Hardware";
    }
}


