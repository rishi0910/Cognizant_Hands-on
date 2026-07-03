package com.rishi;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inventory Validation Subsystem Active.");
        InventoryItem retailProduct = new InventoryItem("Peanuts", 25.0, 15);
        System.out.println("Product Availability State: " + retailProduct.isAvailableInStock());
    }
}