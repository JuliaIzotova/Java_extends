package ru.netology.data;

public class Product {
    protected int id;
    protected String name;
    protected int price;

    //конструкторы

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // геттеры, сеттеры


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}
