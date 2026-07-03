package com.rishi;

// Simple business component managing retail inventory profiles
public class InventoryItem {
    private String itemName;
    private double unitPrice;
    private int stockQuantity;

    public InventoryItem(String itemName, double unitPrice, int stockQuantity) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public String getItemName() {
    	return itemName; 
    	}
    public double getUnitPrice() { 
    	return unitPrice; 
    	}
    public int getStockQuantity() {
    	return stockQuantity; 
    	}
    
    public boolean isAvailableInStock() {
        return stockQuantity > 0;
    }
}