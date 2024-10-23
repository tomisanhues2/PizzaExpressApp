package com.example.pizzaexpressapp.classes;

public abstract class AItems implements IItems {

    private int id;

    private String name;

    private int image;

    private double price;

    public AItems(int id, String name, int image, double price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
