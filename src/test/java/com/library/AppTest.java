package com.library;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testLoanBook(){
        Book book1 = new Book("Wiedzmin", "Sapkowski", false);
        List<Book> libraryBooks = new ArrayList<Book>();
        libraryBooks.add(book1);
        Client bartek = new Client("Bartek", "Nowak");
        bartek.loanBook(libraryBooks, "Wiedzmin");
        Assert.assertEquals(1, bartek.getBooks().size());
        //adding new client and check if he can borrow the same book
        Client michal = new Client("Michal", "Madej");
        michal.loanBook(libraryBooks, "Wiedzmin");
        Assert.assertEquals(0, michal.getBooks().size());
    }
    public void testGiveBackBook(){
        Book book1 = new Book("Wiedzmin", "Sapkowski", false);
        List<Book> libraryBooks = new ArrayList<Book>();
        libraryBooks.add(book1);
        Client bartek = new Client("Bartek", "Nowak");
        Client testowy = new Client("Testowy", "Nowy");
        bartek.loanBook(libraryBooks, "Wiedzmin");

        testowy.loanBook(libraryBooks,"Wiedzmin"); // new user cant loan the same book
        Assert.assertEquals(0,testowy.getBooks().size());

        bartek.giveBackBook(libraryBooks, "Wiedzmin"); // give back
        Assert.assertEquals(0, bartek.getBooks().size());

        testowy.loanBook(libraryBooks, "Wiedzmin"); // new ser now can loan this book
        Assert.assertEquals(1, testowy.getBooks().size());
        Assert.assertEquals("Sapkowski", testowy.getBooks().get(0).getAuthor());
    }
    public void testSerializeAndDeserialize(){
        List<Book> libraryBooks = new ArrayList<Book>();
        libraryBooks.add(new Book("Wiedzmin", "Sapkowski", false));
        libraryBooks.add(new Book("Harry Potter", "J.K.Rowling", false));
        List<Client> clients = new ArrayList<Client>();
        Client testUser = new Client("Bartek", "Nowak");
        clients.add(testUser);

        testUser.loanBook(libraryBooks, "Wiedzmin");
        testUser.loanBook(libraryBooks, "Harry Potter");

        Organizer.XMLSerialize(clients);
        List<Client> deserializedClients = new ArrayList<Client>();
        deserializedClients = Organizer.XMLDeserialize();

        Assert.assertEquals(1, deserializedClients.size());
        Assert.assertEquals(2, deserializedClients.get(0).getBooks().size());
        Assert.assertEquals("Harry Potter", deserializedClients.get(0).getBooks().get(1).getTitle());
    }
}
