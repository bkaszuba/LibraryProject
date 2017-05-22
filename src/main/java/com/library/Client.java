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
    public Client(){};

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

    public void loanBook(List<Book> libraryBooks, String bookTitle){
        for(int i=0;i<libraryBooks.size();i++){
            if(bookTitle.equals(libraryBooks.get(i).getTitle()) && libraryBooks.get(i).getTaken() == false){
                libraryBooks.get(i).setTaken(true);
                books.add(libraryBooks.get(i));
                break;
            }
        }
    }
    public void giveBackBook(List<Book> libraryBooks, String bookTitle){
        for(int i=0; i<books.size();i++){
            if(books.get(i).getTitle().equals(bookTitle)){
                books.remove(i);
                for(int j=0;j<libraryBooks.size();j++){
                    if(libraryBooks.get(j).getTitle().equals(bookTitle)){
                        libraryBooks.get(j).setTaken(false);
                        break;
                    }
                }
                break;
            }
        }
    }
}
