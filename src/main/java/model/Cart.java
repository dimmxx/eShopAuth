package model;

import java.util.*;

public class Cart {

    private Map<Product, Integer> productMap = new HashMap<>();

    private int mapProductQuantity;
    private int mapTotalAmount;

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public int getMapProductQuantity() {
        int quantity = 0;
        for (int item : productMap.values()) {
            quantity += item;
        }
        return quantity;
    }

    public int getMapTotalAmount() {
        int amount = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            amount += entry.getValue() * entry.getKey().getPrice();
        }
        return amount;
    }




}

