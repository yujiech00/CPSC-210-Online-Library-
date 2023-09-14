package model;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for Reservation

public class ReservationTest {
    private Book b1;
    private Book b2;
    private Book b3;
    private Book b4;

    private Member p1;
    private Member p2;
    private Member p3;

    private BookRecord bookRecord1;
    private BookRecord bookRecord2;
    private BookRecord bookRecord3;
    private BookRecord bookRecord4;

    private Reservation testReservation1;

    private static final int empty = 0;


@BeforeEach
public void setUp() {

   //////// b1 = new Book("Science", "Earth", TRUE, null);
    b1 = new Book("Science", "Earth", null);
    p1 = new Member("",1);
    bookRecord1 = new BookRecord(b1,1);
    bookRecord4 = new BookRecord(b4,2);
// //   bookRecord1 = new BookRecord(b1, p1, 1);
//  //  bookRecord4 = new BookRecord(b4, p1, 2);
//////    b3 = new Book("Arts", "Creativity", FALSE, null);
    b3 = new Book("Arts", "Creativity",null);
    p3 = new Member("Tony",2);
    bookRecord3 = new BookRecord(b3,empty);
    /////////bookRecord3 = new BookRecord(b3, p3, empty);
//////    b2 = new Book("Engineering", "Creativity", FALSE, null);
    b2 = new Book("Engineering", "Creativity",null);
    p2 = new Member("Jenny",3);
    bookRecord2 = new BookRecord(b2,3);
    ////////////////bookRecord2 = new BookRecord(b2, p2, 3);
    ///////////b4 = new Book("Science", "CHEM", FALSE, null);
    b4 = new Book("Science", "CHEM",null);


    b1.setBookRecord(bookRecord1);
    b2.setBookRecord(bookRecord2);
    b3.setBookRecord(bookRecord3);
    b4.setBookRecord(bookRecord4);

    testReservation1 = new Reservation();
    //testReservation1.getReservations().add(bookRecord1);
    //testReservation1.getReservations().add(bookRecord2);

}






//    @Test
//    public void testFindBookRecord() {
//    BookRecord searchResult1 = testReservation1.findBookRecord(b1);
//    assertEquals(bookRecord1,searchResult1);
//
//    BookRecord searchResult2 = testReservation1.findBookRecord(b3);
//    searchResult2.equals(null);
//
//    BookRecord searchResult3 = testReservation1.findBookRecord(b4);
//    searchResult3.equals(null);
//
//    BookRecord searchResult4 = testReservation1.findBookRecord(b3);
//    searchResult4.equals(null);
//
//    }

}


