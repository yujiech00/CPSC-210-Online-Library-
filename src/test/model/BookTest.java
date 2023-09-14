package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for Book
public class BookTest {
    private Book testBook1;
    private Book testBook2;
    private Book testBook3;
    private Book testBook4;
    private Book testBook5;
    private BookRecord BookRecord1;
    private BookRecord BookRecord2;
    private BookRecord BookRecord3;
    private BookRecord BookRecord4;
    private int n1;
    private int n3;
    private int n2;
    private int n4;
    private Member p1;
    private Member p2;
    private Member p3;
    private Member p4;





    @BeforeEach
public void setUp(){

        n1 = 1;
        n2 = 2;
        n4 = 0;
        p1 = new Member("Tim",1);
        p2 = null;
        p3 = new Member("Jane",2);
        p4 = new Member("Janet",3);
//    testBook1 = new Book("Science","Earth",TRUE,null);
//    testBook2 = new Book("","Earth", TRUE,null);
//    testBook3 = new Book("Science","",FALSE,null);
//    testBook4 = new Book("Science","Earth", FALSE,null);
        testBook1 = new Book("Science","Earth",null);
        testBook2 = new Book("","Earth", null);
        testBook3 = new Book("Science","",null);
        testBook4 = new Book("Science","Earth", null);
        testBook5 = new Book();
//    BookRecord1 = new BookRecord(testBook1,p1,n1);
//    BookRecord2 = new BookRecord(testBook2,p1,n4);
//    BookRecord3 = new BookRecord(testBook3,p3,n2);
//    BookRecord4 = new BookRecord(testBook4,p4,n4);
    BookRecord1 = new BookRecord(testBook1,n1);
    BookRecord2 = new BookRecord(testBook2,n4);
    BookRecord3 = new BookRecord(testBook3,n2);
    BookRecord4 = new BookRecord(testBook4,n4);
    testBook1.setBookRecord(BookRecord1);
    testBook2.setBookRecord(BookRecord2);
    testBook3.setBookRecord(BookRecord3);
    testBook4.setBookRecord(BookRecord4);


}

@Test
    void testSetBookType(){
    testBook2.setBookType("Science");
    //String ty1 = testBook1.getType();
    String ty2 = testBook2.getType();
    assertEquals("Science",ty2);
    assertEquals("",testBook5.getType());


}
@Test
     void testSetBookTitle(){
    testBook3.setBookTitle("Earth");
    //String ti1 = testBook1.getTitle();
    String ti3 = testBook3.getTitle();
    assertEquals("Earth",ti3);
}

//@Test
//     void testSetBookStatus(){
//    testBook1.setBookStatus();
//    assertTrue(testBook1.getStatus2());
//    testBook3.setBookStatus();
//    assertTrue(testBook3.getStatus2());
//    testBook2.setBookStatus();
//    assertFalse(testBook2.getStatus2());
//    testBook4.setBookStatus();
//    assertFalse(testBook4.getStatus2());
//
//}


//@Test
//     void testGetStatus() {
//        String status;
//        status = testBook3.getStatus();
//        assertEquals("NOT AVAILABLE",status);
//        status = testBook1.getStatus();
//        assertEquals("AVAILABLE",status);
//
//}

@Test
     void testGetBookRecord() {
        BookRecord br;
        br = testBook1.getBookRecord();
        assertEquals(BookRecord1,br);
        assertEquals(testBook1,testBook1);
        assertNotEquals(testBook1,null);
        assertNotEquals(testBook1,p1);
//        assertEquals(testBook1,(new Book("Science","Earth",TRUE,null)));
        assertEquals(testBook1,(new Book("Science","Earth",null)));
        assertEquals(Objects.hash("Science","Earth"),testBook1.hashCode());
}






}



