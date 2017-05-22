package com.library;

/**
 * Created by ZiOm4444 on 2017-05-18.
 */
public class Book {
    String title;
    String author;
    Boolean isTaken;

    public Book(String title, String author, Boolean isTaken) {
        this.title = title;
        this.author = author;
        this.isTaken = isTaken;
    }
    public Book() {};

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }
}
