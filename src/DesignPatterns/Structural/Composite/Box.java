package DesignPatterns.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Box implements Item {
    private List<Item> items = new ArrayList<>();
    private double packagingCost;

    public Box(double packagingCost) {
        this.packagingCost = packagingCost;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = packagingCost;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Box with items: " + items;
    }
}

