package com.spring.Entity;

public class paperBook extends Book {
    private int stock;

    public paperBook(String ISBN, String title, int publishYear, double price, int quantity, int stock) {
        super(ISBN, title, publishYear, price, quantity);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
    public void reduceStock(int stock) {
        if(this.stock>=this.getQuantity()){
            this.stock-=stock;
        }else{
            throw new IllegalArgumentException("Stock is not avaliable");
        }
    }
    public void shippingService(String address) {
        System.out.println("send "+this.getTitle()+" to "+address);
    }
}
