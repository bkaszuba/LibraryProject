package com.library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Clients
        Client client1 = new Client("Bartek", "Kaszuba");
        Client client2 = new Client("Andrzej", "Nowak");
        //Books
        Book book1 = new Book("Narnia", "Niewiem", false);
        Book book2 = new Book("Dziala", "Sapkowski", false);
        Book book3 = new Book("Psy", "Jakis", false);
        Book book4 = new Book("Koty", "Nieznany", false);
        Book book5 = new Book("Gry", "Nowosc", false);
        Book book6 = new Book("Fajowe", "Co to", false);
        Book book7 = new Book("Dziwne", "Brak", false);
        Book book8 = new Book("Pustka", "Sienkiewicz", false);
        Book book9 = new Book("Kosak", "Mickiewicz", false);
        //Add clients to list
        List<Client> clientList = new ArrayList<Client>();
        clientList.add(client1);clientList.add(client2);
        //Add books to library list
        List<Book> libraryBooks = new ArrayList<Book>();
        libraryBooks.add(book1);libraryBooks.add(book2);libraryBooks.add(book3);libraryBooks.add(book4);libraryBooks.add(book5);
        libraryBooks.add(book6);libraryBooks.add(book7);libraryBooks.add(book8);libraryBooks.add(book9);
        //Loan books
        client1.loanBook(libraryBooks, "Narnia");client1.loanBook(libraryBooks, "Dziala");client1.loanBook(libraryBooks, "Psy");
        client1.loanBook(libraryBooks, "Koty");

        client2.loanBook(libraryBooks, "Gry");client2.loanBook(libraryBooks, "Fajowe");client2.loanBook(libraryBooks, "Dziwne");
        client2.loanBook(libraryBooks, "Pustka");client2.loanBook(libraryBooks, "Kosak");

        client2.giveBackBook(libraryBooks,"Fajowe");

        client1.loanBook(libraryBooks,"Fajowe");

        try {
            Organizer.writeAllDataToFile(clientList, "allData.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
