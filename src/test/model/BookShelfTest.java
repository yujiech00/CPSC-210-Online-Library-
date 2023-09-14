package model;

import exception.EmptyBookShelfException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookShelfTest {

    private Book b1;
    private Book b2;
    private Book b3;
    private Member p1;
    private Member p2;
    private Member p3;
    private Member p4;
    private BookRecord bookRecord1;
    private BookRecord bookRecord2;
    private BookRecord bookRecord3;
    private BookRecord bookRecord4;
    private int n1;
    private int n2;
    private int n4;
    private BookShelf testBookShelf1;
    private BookShelf testBookShelf2;

    private static final int empty = 0;

    @BeforeEach
    void setUp() {

        n1 = 1;
        n2 = 2;
        n4 = 0;
        p1 = new Member("Tim",1);
        p2 = null;
        p3 = new Member("Jane",2);
        b1 = new Book("Science", "Earth", null);
        b2 = new Book("Arts", "Earth",null);
        b3 = new Book("", "",null);
//        b1 = new Book("Science", "Earth", TRUE, null);
//        b2 = new Book("Arts", "Earth", TRUE, null);
//        b3 = new Book("", "", FALSE, null);

//        bookRecord1 = new BookRecord(b1, p1, n1);
//        bookRecord2 = new BookRecord(b2, p1, n4);
//        bookRecord3 = new BookRecord(b3, p3, n2);
//        bookRecord4 = new BookRecord(b2, null, n2);
        bookRecord1 = new BookRecord(b1,n1);
        bookRecord2 = new BookRecord(b2,n4);
        bookRecord3 = new BookRecord(b3,n2);
        bookRecord4 = new BookRecord(b2,n2);

        testBookShelf1 = new BookBefore2000Shelf();
        testBookShelf1.getBookList().add(b1);
        testBookShelf2 = new BookBefore2000Shelf();

    }


    @Test
    void testTryToFindBookOnShelfBookMatch() {
        Book result1;
        try {
            testBookShelf1.tryToFindBookOnShelf("Earth", "Science");
            result1 = testBookShelf1.tryToFindBookOnShelf("Earth", "Science");
            b1.equals(result1);
        } catch (EmptyBookShelfException e) {
            fail("EmptyBookShelfException should not be thrown!");
        }
    }


@Test
    void testTryToFindBookOnShelfBookNotMatch() {
        Book result2;
        try {
            testBookShelf1.tryToFindBookOnShelf("Ocean", "Science");
            result2 = testBookShelf1.tryToFindBookOnShelf("Ocean", "Geography");
            assertNull(result2);
        } catch (EmptyBookShelfException e) {
            fail("EmptyBookShelfException should not be thrown!");
        }
    }

@Test
    void testTryToFindBookOnShelfEmptyShelf() {
        try {
            testBookShelf2.tryToFindBookOnShelf("Ocean", "Arts");
            fail("EmptyBookShelfException is not thrown!");

        } catch (EmptyBookShelfException e) {

        }
    }

//    @Test
//    void testGetBook() {
//        Book r = testBookShelf1.getBookFromShelf(b1);
//        assertEquals(b1,r);
//        Book r2 =testBookShelf1.getBookFromShelf(b3);
//        assertNull(r2);
//    }
}







