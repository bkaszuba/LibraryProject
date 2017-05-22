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
    public void testApp()
    {
        assertTrue( true );
    }

    public void testLoanBook(){
        Book book1 = new Book("Wiedzmin", "Sapkowski", false);
        List<Book> libraryBooks = new ArrayList<Book>();
        libraryBooks.add(book1);
        Client bartek = new Client("Bartek", "Kaszuba");
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
        Client bartek = new Client("Bartek", "Kaszuba");
        Client testowy = new Client("Testowy", "Nowy");
        bartek.loanBook(libraryBooks, "Wiedzmin");

        Assert.assertEquals(1, bartek.getBooks().size());
        testowy.loanBook(libraryBooks,"Wiedzmin");
        Assert.assertEquals(0,testowy.getBooks().size());

        bartek.giveBackBook(libraryBooks, "Wiedzmin");
        Assert.assertEquals(0, bartek.getBooks().size());

        testowy.loanBook(libraryBooks, "Wiedzmin");
        Assert.assertEquals(1, testowy.getBooks().size());
        Assert.assertEquals("Sapkowski", testowy.getBooks().get(0).getAuthor());

    }
}
