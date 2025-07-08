package com.spring.Entity;

import com.spring.Custom.bookFileType;

public class EBook extends Book{

    private bookFileType fileType;

    public EBook(String ISBN, String title, int publishYear, double price, int quantity, bookFileType fileType) {
        super(ISBN, title, publishYear, price, quantity);
        this.fileType = fileType;
    }
    public void sendToMailServing(String emailAddress) {
        System.out.println("Send "+this.getTitle()+" to "+emailAddress);
    }

}
