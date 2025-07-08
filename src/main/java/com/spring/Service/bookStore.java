package com.spring.Service;

import com.spring.Entity.Book;
import com.spring.Entity.EBook;
import com.spring.Entity.demoBook;
import com.spring.Entity.paperBook;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bookStore {
    List<Book>books;
    public bookStore() {
        books = new ArrayList<Book>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public List<Book> removeOutdatedBooks(int maxYearsOld) {
        List<Book> removedBooks = new ArrayList<>();
        int currentYear = Year.now().getValue();
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (currentYear - book.getPublishYear() > maxYearsOld) {
                removedBooks.add(book);
                iterator.remove();
            }
        }
        return removedBooks;
    }

    public double buyBook(String ISBN, int quantity, String email, String address) {
        if (books.isEmpty()) {
            throw new IllegalArgumentException(" The Inventory is Empty!");
        }
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (book instanceof paperBook) {
                    paperBook paperBook = (paperBook) book;
                    if (paperBook.getStock() >= quantity) {
                        paperBook.reduceStock(quantity);
                        paperBook.shippingService(address);
                        double paidAmount = paperBook.getPrice() * quantity;
                        System.out.println("Successfully purchased " + quantity + " of Paper Book: '" + paperBook.getTitle() + "'. Total cost: $" +paidAmount);
                        return paidAmount;
                    } else {
                        throw new IllegalArgumentException(" stock is not available  for Paper Book ");
                    }
                } else if (book instanceof EBook) {
                    EBook eBook = (EBook) book;
                    eBook.sendToMailServing(email);
                    double paidAmount = eBook.getPrice() * quantity;
                    System.out.println("Successfully purchased " + quantity + "  of EBook: '" + eBook.getTitle() + "'. Total cost: $" +paidAmount);
                    return paidAmount;
                } else if (book instanceof demoBook) {
                    throw new IllegalArgumentException("The" + book.getTitle() + "is not for sale.");
                }
            }
        }
        throw new IllegalArgumentException("Book with ISBN '" + ISBN + "' not found in inventory.");
    }
}
