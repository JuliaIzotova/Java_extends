package ru.netology.data;

public class Smartphone extends Product {
    protected String manufacturer;

    //конструкторы

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}
