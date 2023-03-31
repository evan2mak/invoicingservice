package edu.iu.c322.invoicingservice.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

public class Item {
    private int itemId;
    @NotEmpty(message = "Item name cannot be empty.")
    private String item;
    private double price;
    private String status;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item1)) return false;
        return getItemId() == item1.getItemId() && Double.compare(item1.getPrice(), getPrice()) == 0 && Objects.equals(getItem(), item1.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getItem(), getPrice());
    }
}
