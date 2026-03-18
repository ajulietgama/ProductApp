package org.example;

public class Software extends Products{


    public int licenseMonths;

    public Software(int id, String name, double basePrice, int licenseMonths){
        super(id, name, basePrice);
        this.licenseMonths = licenseMonths;
    }

    public double getPrice(){
        if (licenseMonths > 12) {
            return basePrice * 0.95; // 5% discount
        }
        return basePrice;
    }

    public String getType() {
        return "Software";
    }

    }
