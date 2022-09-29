package com.ascend.components.entities;

public class OrderItems {
    private int order_item_id;
    private int quantity;
    private String upc;

    Order order;

    public OrderItems(){}

    public OrderItems(int orderitemid, int quantity, String upc) {
        this.order_item_id = orderitemid;
        this.quantity = quantity;
        this.upc = upc;
    }

    public int getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "order_item_id=" + order_item_id +
                ", quantity=" + quantity +
                ", upc='" + upc + '\'' +
                ", order=" + order +
                '}';
    }
}
