package com.example.pizzaexpressapp.classes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {


    private Map<AItems, Integer> items = new HashMap<>();

    private double totalPrice;

    private String userName;

    private String userEmail;

    private int userPhone;

    private Date orderDate;

    private double deliveryFee;

    public Order() {
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public void addItem(AItems item, int quantity) {
        items.put(item, quantity);
    }

    public void removeItem(AItems item) {
        items.remove(item);
    }

    public Map<AItems, Integer> getItems() {
        return items;
    }

    public int getQuantity(AItems item) {
        return items.get(item);
    }
}
