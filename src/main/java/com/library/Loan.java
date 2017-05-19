package com.library;

/**
 * Created by ZiOm4444 on 2017-05-19.
 */
public class Loan {
    private Client client;
    private Book book;

    public Loan(Client client, Book book) {

        this.client = client;
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }



}
