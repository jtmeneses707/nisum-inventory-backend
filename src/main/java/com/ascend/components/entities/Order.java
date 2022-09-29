package com.ascend.components.entities;

import java.util.List;

public class Order {

    int order_id;
    int user_id;
    int address_id;
    float price;
    int credit_card_id;
    String date_ordered;
    String date_shipped;
    String order_status;

    List<OrderItems> orderItems;

    public Order(){

    }

    public Order(int order_id, int user_id, int address_id, int price, int credit_card_id, String date_ordered, String date_shipped, String order_status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.address_id = address_id;
        this.price = price;
        this.credit_card_id = credit_card_id;
        this.date_ordered = date_ordered;
        this.date_shipped = date_shipped;
        this.order_status = order_status;

    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCredit_card_id() {
        return credit_card_id;
    }

    public void setCredit_card_id(int credit_card_id) {
        this.credit_card_id = credit_card_id;
    }

    public String getDate_ordered() {
        return date_ordered;
    }

    public void setDate_ordered(String date_ordered) {
        this.date_ordered = date_ordered;
    }

    public String getDate_shipped() {
        return date_shipped;
    }

    public void setDate_shipped(String date_shipped) {
        this.date_shipped = date_shipped;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
        for(OrderItems i: this.orderItems){
            i.setOrder(this);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", address_id=" + address_id +
                ", price=" + price +
                ", credit_card_id=" + credit_card_id +
                ", date_ordered='" + date_ordered + '\'' +
                ", date_shipped='" + date_shipped + '\'' +
                ", order_status='" + order_status + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
