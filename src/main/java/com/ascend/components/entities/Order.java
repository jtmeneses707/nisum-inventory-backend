package com.ascend.components.entities;

public class Order {
    private String UPC;
    private int quantity;
    private String Status;

    public Order(){}

    public Order(String UPC, int quantity, String status) {
        this.UPC = UPC;
        this.quantity = quantity;
        Status = status;
    }

    public String getUPC() {
        return UPC;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "UPC='" + UPC + '\'' +
                ", quantity=" + quantity +
                ", Status='" + Status + '\'' +
                '}';
    }
}
