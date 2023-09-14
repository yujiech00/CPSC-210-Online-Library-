package model;

import exception.BorrowerNotExistException;
import exception.WrongPlaceToReturnException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class BookBorrowRecordTest {
    private BookBorrowRecord testBookBorrowRecord;
    private BookBorrowRecord testBookBorrowRecord2;
    private BookBorrowRecord testBookBorrowRecord3;
    private BookBorrowRecord testBookBorrowRecord4;
    private ArrayList<NamePlusBorrowNumber> namePlusBorrowNumberArrayList;
    private NamePlusBorrowNumber nb1;
    private NamePlusBorrowNumber nb2;



    @BeforeEach
    void setUp() {
        nb1 = new NamePlusBorrowNumber("Tina",2);
        nb2 = new NamePlusBorrowNumber("Tom",1);
        namePlusBorrowNumberArrayList = new ArrayList<>();
        namePlusBorrowNumberArrayList.add(nb1);
        namePlusBorrowNumberArrayList.add(nb2);
        testBookBorrowRecord = new BookBorrowRecord("Earth", "Science");
        testBookBorrowRecord.setAllBorrowInfoMap(namePlusBorrowNumberArrayList);
        ///testBookBorrowRecord.setAllBorrowInfo(namePlusBorrowNumberArrayList);
        testBookBorrowRecord2 = new BookBorrowRecord("Earth","Geography");
        testBookBorrowRecord3 = new BookBorrowRecord("Mars","Science");
        testBookBorrowRecord4 = new BookBorrowRecord("Earth", "Science");


    }

    @Test
    void testGetBorrowNumForCertainBorrowerExceptionNotThrown() {
        try {
            testBookBorrowRecord.getBorrowNumForCertainBorrower("Tina");
            int num = testBookBorrowRecord.getBorrowNumForCertainBorrower("Tina");
            assertEquals(2,num);
        } catch (BorrowerNotExistException e) {
           fail("BorrowerNotExistException should not be thrown");
        }
    }


    @Test
    void testGetBorrowNumForCertainBorrowerExceptionThrown() {
        try {
            testBookBorrowRecord.getBorrowNumForCertainBorrower("Tim");
            fail("BorrowerNotExistException should be thrown");
        } catch (BorrowerNotExistException e) {
            System.out.println("Borrower not found");
        }
    }


    @Test
    void testUpdateAllBorrowInfo() throws BorrowerNotExistException {
        testBookBorrowRecord.updateAllBorrowInfoForBorrow("Tina",1);
        int num = testBookBorrowRecord.getBorrowNumForCertainBorrower("Tina");
        assertEquals(3,num);

        testBookBorrowRecord.updateAllBorrowInfoForBorrow("Tony",2);
        int num2 = testBookBorrowRecord.getBorrowNumForCertainBorrower("Tony");
        assertEquals(2,num2);

    }

    @Test
    void testUpdateAllBorrowInfoForReturnExceptionThrown() throws BorrowerNotExistException {
        try {
            testBookBorrowRecord.updateAllBorrowInfoForReturn("Tina",1);
            assertEquals(1,testBookBorrowRecord.getBorrowNumForCertainBorrower("Tina"));
        } catch (WrongPlaceToReturnException e) {
           fail("WrongPlaceToReturnException should not be thrown");
        }

    }

    @Test
    void testUpdateAllBorrowInfoForReturnExceptionNotThrown() {
        try {
            testBookBorrowRecord.updateAllBorrowInfoForReturn("Tony",3);
            fail("WrongPlaceToReturnException should be thrown");
        } catch (WrongPlaceToReturnException e) {
            System.out.println("return book to the wrong place");
        }

    }

    @Test
    void testUpdateAllBorrowInfoForReturnExceptionNotThrownAndBorrowerRemoved() {
        try {
            testBookBorrowRecord.updateAllBorrowInfoForReturn("Tina",2);
            try {
                testBookBorrowRecord.getBorrowNumForCertainBorrower("Tina");
                fail("BorrowerNotExistException should be thrown");
            } catch (BorrowerNotExistException e) {
                System.out.println("Borrower not found");
            }
        } catch (WrongPlaceToReturnException e) {
            fail("WrongPlaceToReturnException should not be thrown");
        }
    }

    @Test
    void testGetBookName() {
        assertEquals("Earth",testBookBorrowRecord.getBookName());
    }

    @Test
    void testGetBookType() {
        assertEquals("Science",testBookBorrowRecord.getBookType());
    }

    @Test
    void testGetAllBorrowInfoMap() {
        Map<String,NamePlusBorrowNumber> map = testBookBorrowRecord.getAllBorrowInfoMap();
        assertEquals(2,map.size());

    }


    @Test
    void testEquals() {
        assertTrue(testBookBorrowRecord.equals(testBookBorrowRecord));
        assertFalse(testBookBorrowRecord.equals(nb1));
        assertFalse(testBookBorrowRecord.equals(testBookBorrowRecord2));
        assertFalse(testBookBorrowRecord.equals(testBookBorrowRecord3));
        assertTrue(testBookBorrowRecord.equals(testBookBorrowRecord4));

    }

    @Test
    void testHashCode() {
        assertEquals(Objects.hash(testBookBorrowRecord.getBookName(),
                testBookBorrowRecord.getBookType()),testBookBorrowRecord.hashCode());
    }






}
