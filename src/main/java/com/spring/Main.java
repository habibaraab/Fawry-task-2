package com.spring;

import com.spring.Custom.bookFileType;
import com.spring.Entity.Book;
import com.spring.Entity.EBook;
import com.spring.Entity.demoBook;
import com.spring.Entity.paperBook;
import com.spring.Service.bookStore;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        bookStore myBookstore = new bookStore() ;

        System.out.println("\n--- Testing Adding Books ---");
        Book paperBook1 = new paperBook("PB001", "Java ", 2019, 100, 20, 50);
        Book eBook1 = new EBook("EB001", "Advanced Algorithms", 1999, 500, 5, bookFileType.PDF);
        Book demoBook1 = new demoBook("DB001", "Math", 2025, 250,20);
        Book paperBook2 = new paperBook("PB002", "Python ", 2000, 300, 2, 30);
        Book eBook2 = new EBook("EB002", "Cloud Computing ", 2023, 500, 15, bookFileType.EPUB);
        Book outdatedPaperBook = new paperBook("OPB001", "C++", 1990, 2005, 14, 5);
        Book outdatedEBook = new EBook("OEB001", " Data Structures", 2024, 600, 20, bookFileType.TXT);

        myBookstore.addBook(paperBook1);
        myBookstore.addBook(eBook1);
        myBookstore.addBook(demoBook1);
        myBookstore.addBook(paperBook2);
        myBookstore.addBook(eBook2);
        myBookstore.addBook(outdatedPaperBook);
        myBookstore.addBook(outdatedEBook);

        System.out.println("Successfully added books");


        System.out.println("\n--- Testing Buying Books ---");

        try {
            myBookstore.buyBook("PB001", 2, null, "123 shaker Street");

        } catch (IllegalArgumentException e) {
            System.out.println("Purchase failed: " + e.getMessage());
        }


        try {
             myBookstore.buyBook("EB001", 1, "bia@gmail.com", null);
        } catch (IllegalArgumentException e) {
            System.out.println("Purchase failed: " + e.getMessage());
        }

        try {
            myBookstore.buyBook("DB001", 1, "habiba@example.com", null);
        } catch (IllegalArgumentException e) {
            System.out.println("Purchase failed :" + e.getMessage());
        }

        try {
            myBookstore.buyBook("PB001", 100, null, "456 Oak Ave");
        } catch (IllegalArgumentException e) {
            System.out.println(" Purchase failed : " + e.getMessage());
        }

        try {
            myBookstore.buyBook("kkk", 1, "habiba@gmail.com", null);
        } catch (IllegalArgumentException e) {
            System.out.println(" Purchase failed : " + e.getMessage());
        }

        System.out.println("\n--- Testing Removing Outdated Books ");
        List<Book> removed = myBookstore.removeOutdatedBooks(3);
        for (Book book : removed) {
            System.out.println("Quantum book store: Removed: " + book.getTitle()  + book.getPublishYear()  );
        }


        System.out.println(" Full test completed.");
    }
}