package com.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZiOm4444 on 2017-05-18.
 */
public class Client {
    String name;
    String surname;
    List<Book> books;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.books = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}