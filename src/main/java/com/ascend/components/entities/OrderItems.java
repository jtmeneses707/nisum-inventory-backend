package com.ascend.components.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderItems {
    private int order_item_id;
    private int quantity;
    private String upc;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="order_id")
    Order order;

    public OrderItems(){}

    public OrderItems(int order_item_id, int quantity, String upc) {
        this.order_item_id = order_item_id;
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
        return "{" +
                " orderitemid='" + getOrder_item_id() + "'" +
                ", orderid='" + this.getOrder().getOrder_id() + "'" +
                ", quantity='" + getQuantity() + "'" +
                ", upc='" + getUpc() + "'" +
                "}";
    }
}
