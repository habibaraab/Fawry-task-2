package com.spring.Entity;

import java.time.LocalDate;

public abstract class Book {

    private String ISBN;
    private String title;
    private int publishYear;
    private double price;
    private int quantity;

    public Book(){}
    public Book(String ISBN, String title, int publishYear, double price, int quantity) {

        if(publishYear<0) throw new IllegalArgumentException("Publish Year must be greater than 0");
        if(quantity<0) throw new IllegalArgumentException("Quantity must be greater than 0");
        if(price<0) throw new IllegalArgumentException("Price must be greater than 0");
        this.ISBN = ISBN;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;
        this.quantity = quantity;

    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
