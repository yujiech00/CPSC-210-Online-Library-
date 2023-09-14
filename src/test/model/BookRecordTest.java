package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


// Unit tests for BookInfo
public class BookRecordTest {

    private Book b1;
    private Book b2;
    private Book b3;
    private Member p1;
    private Member p2;
    private Member p3;
    private Member p4;
    private BookRecord testBookRecord1;
    private BookRecord testBookRecord2;
    private BookRecord testBookRecord3;
    private BookRecord testBookRecord4;
    private int n1;
    private int n2;
    private int n4;
    private static final int empty = 0;







    @BeforeEach
    void setUp() {

        n1 = 1;
        n2 = 2;
        n4 = 0;
//        p1 = new Borrower("Tim");
//        p2 = null;
//        p3 = new Borrower("Jane");
//        b1 = new Book("Science","Earth",null);
//        b2 = new Book("","Earth",null);
//        b3= new Book("Science","",null);
//        b1 = new Book("Science","Earth",TRUE,null);
//        b2 = new Book("","Earth",TRUE,null);
//        b3= new Book("Science","",FALSE,null);

//        testBookRecord1 = new BookRecord(b1,p1,n1);
//        testBookRecord2 = new BookRecord(b2,p1,n4);
//        testBookRecord3 = new BookRecord(b3,p3,n2);
//        testBookRecord4 = new BookRecord(b2,null,n2);

        testBookRecord1 = new BookRecord(b1,n1);
        testBookRecord2 = new BookRecord(b2,n4);
        testBookRecord3 = new BookRecord(b3,n2);
        testBookRecord4 = new BookRecord(b2,n2);

        //testBookRecord3.setAvailableStatus();
        //testBookRecord4.setAvailableStatus();



//        b1 = new Book("Science", "Earth", TRUE,null);
        b1 = new Book("Science", "Earth",null);
        p1 = new Member("",1);
        testBookRecord1 = new BookRecord(b1,1);
        testBookRecord1.setAvailableStatus();
        ///testBookRecord1 = new BookRecord(b1,p1,1);

//        b2 = new Book("Science", "Earth", FALSE,null);
        b2 = new Book("Science", "Earth",null);
        p2 = new Member("Tom",2);
        testBookRecord2 = new BookRecord(b2,2);
        testBookRecord2.setAvailableStatus();
        ///////testBookRecord2 = new BookRecord(b2, p2,2);

//        b3 = new Book("Arts", "Asian Study", FALSE,null);
        b3 = new Book("Arts", "Asian Study",null);
        p3 = new Member("Tony",3);
        testBookRecord3 = new BookRecord(b3,empty);
        //////testBookRecord3 = new BookRecord(b3, p3,empty);

        b1.setBookRecord(testBookRecord1);
        b2.setBookRecord(testBookRecord2);
        b3.setBookRecord(testBookRecord3);


        //System.setOut(new PrintStream(outContent));






    }


    @Test
     void testSetNumberPlus() {
        int NumberAdded = 5;
        testBookRecord1.setNumberPlus(NumberAdded);
        assertEquals(6,testBookRecord1.getNumber());
    }

    @Test
    void testSetNumberMinus() {
        int numberBorrowed = 1;
        testBookRecord1.setNumberMinus(numberBorrowed);
        assertEquals(0,testBookRecord1.getNumber());
    }



//    @Test
//    void testSetBorrower() {
//        testBookRecord1.setBorrower(p2);
//        String borrowerNameSet = testBookRecord1.getBorrower().getBorrowerName();
//        String borrowerNameInput = p2.getBorrowerName();
//        assertEquals(borrowerNameInput,borrowerNameSet);
//
//    }

    @Test
    void testSetNumber() {
        b1.getBookRecord().setNumber(2);
        int setResult = b1.getBookRecord().getNumber();
        assertEquals(2, setResult);

    }

    @Test
     void testGetBook() {
        Book get;
        get = testBookRecord1.getBook();
        assertEquals(b1,get);
    }

    @Test
    void testShowBookRecord() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testBookRecord1.showBookRecord();
        assertEquals(testBookRecord1.getBook().getTitle() + " " +
                testBookRecord1.getBook().getType() + " "
                + testBookRecord1.getAvailableStatus()
               ///+ testBookRecord4.getBook().getStatus()
                  + " " + testBookRecord1.getNumber() + "\n",outContent.toString());

        /////remove borrower field--------------------------------------

//        ByteArrayOutputStream outContent2 = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent2));
//        testBookRecord3.showBookRecord();
//        assertEquals(testBookRecord3.getBook().getTitle() + " "
//                        + testBookRecord3.getBook().getType() + " "
//                    + testBookRecord3.getBook().getStatus() + " " + "borrower: "
//                + testBookRecord3.getBorrower().getBorrowerName()
//                    + "   " + testBookRecord3.getNumber()+ "\n",outContent2.toString());

//        if (this.borrower == null) {
//            System.out.println(this.book.getTitle() + " " + this.book.getType() + " "
//                    + this.book.getStatus()
//                    + " " + this.number);
//        } else {
//            System.out.println(this.book.getTitle() + " " + this.book.getType() + " "
//                    + this.book.getStatus() + " " + "borrower: " + this.borrower.getBorrowerName()
//                    + "   " + this.number);
//        }


    }

    @Test
    void testSetBook() {
        testBookRecord1.setBook(b1);
        assertEquals(b1,testBookRecord1.getBook());
        testBookRecord1.setBook(b2);
        assertEquals(b2,testBookRecord1.getBook());
        assertEquals(testBookRecord1,b1.getBookRecord());
        testBookRecord2.equals(testBookRecord2);
        assertNotEquals(null, testBookRecord2);
        assertEquals(testBookRecord2, (new BookRecord(b2,0)));
        assertFalse(testBookRecord1.equals(b1));
        assertEquals(Objects.hash(b2),testBookRecord1.hashCode());
        assertFalse(testBookRecord1.equals(null));
    }

    @Test
    void testSetAvailableStatus() {
        testBookRecord1.setAvailableStatus();
        assertEquals("AVAILABLE",testBookRecord1.getAvailableStatus());
        testBookRecord3.setAvailableStatus();
        assertEquals("NOT AVAILABLE",testBookRecord3.getAvailableStatus());


    }



}


