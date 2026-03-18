package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Application {
    static HashMap<Integer, Products> inventory = new HashMap<>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        int option;
        do {
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Modify Products");
            System.out.println("4. Total value of products");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            option = sc.nextInt();
            sc.nextLine(); //

            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    modifyProduct();
                    break;
                case 4:
                    totalValue();
                    break;


            }
        } while (option != 5);

    }

    private static void addProduct() {
        System.out.print("Unique Id: ");

        int id = sc.nextInt();

        // Check if ID already exists to avoid overwriting accidentally
        if (inventory.containsKey(id)) {
            System.out.println("Error: The id already exists!");
            return;
        }

        System.out.print("Type (1. Hardware / 2. Software): ");
        int type = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Base price: ");
        double basePrice = sc.nextDouble();

        if (type == 1) {
            System.out.print("Weight (kg): ");
            double weight = sc.nextDouble();
            inventory.put(id, new Hardware(id, name, basePrice, weight));


        } else {
            System.out.print("Software license in months: ");
            int licenseMonths = sc.nextInt();
            inventory.put(id, new Software(id, name, basePrice, licenseMonths));
        }
    }

    private static void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }
        System.out.println("\nID\t| Type\t\t| Name\t| Final price");
        System.out.println("---------------------------------------------------------");
        // Iterating over the values of the Map
        for (Products p : inventory.values()) {
            System.out.printf("%s\t| %s\t| %s\t| $%.2f\n",
                    p.id, p.getType(), p.name, p.getPrice());
        }
    }

    private static void modifyProduct() {
        System.out.print("Type the Id of the product: ");
        int searchedId = sc.nextInt();
        sc.nextLine();

        // Direct access using the Map - no loops needed!
        if (inventory.containsKey(searchedId)) {
            Products p = inventory.get(searchedId);
            System.out.print("Current name: " + p.name );
            System.out.print("New name: ");
            p.name = sc.nextLine();
            System.out.print("Base price: ");
            p.basePrice = sc.nextDouble();
        } else {
            System.out.println("Product does not exist.");
        }
    }

    private static void totalValue() {
        double total = 0;
        for (Products p : inventory.values()) {
            total += p.getPrice();
        }
        System.out.printf("Total value: %.2f\n", total);
        }

}

