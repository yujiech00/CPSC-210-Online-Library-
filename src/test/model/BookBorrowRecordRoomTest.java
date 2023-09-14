package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BookBorrowRecordRoomTest {
    private BookBorrowRecordRoom testBookBorrowRecordRoom;
    private BookBorrowRecord bbr1;
    private BookBorrowRecord bbr2;
    private BookBorrowRecord bbr3;


    @BeforeEach
    void setUp() {
        testBookBorrowRecordRoom = new BookBorrowRecordRoom();
        bbr1 = new BookBorrowRecord("Earth","Science");
        bbr2 = new BookBorrowRecord("Make","Arts");
        bbr3 = new BookBorrowRecord("Ocean","Geography");
        testBookBorrowRecordRoom.getBookBorrowRecords().add(bbr1);
        testBookBorrowRecordRoom.getBookBorrowRecords().add(bbr2);
    }

    @Test
    void testFindOrCreateBookBorrowRecordWhenBorrow() {
        BookBorrowRecord r  = testBookBorrowRecordRoom.findOrCreateBookBorrowRecordWhenBorrow
                ("Earth","Science");
        assertEquals(2,testBookBorrowRecordRoom.getBookBorrowRecords().size());

        BookBorrowRecord r2 = testBookBorrowRecordRoom.findOrCreateBookBorrowRecordWhenBorrow
                ("Mars","Science");
        assertEquals("Mars",r2.getBookName());
        assertEquals("Science",r2.getBookType());


        //assertEquals(3,testBookBorrowRecordRoom.getBookBorrowRecords().size());
    }

    @Test
    void testGetBookBorrowRecord() {
        BookBorrowRecord b1 = testBookBorrowRecordRoom.getBookBorrowRecord("Earth","Science");
        assertEquals("Earth",b1.getBookName());
        assertEquals("Science",b1.getBookType());
        BookBorrowRecord b2 = testBookBorrowRecordRoom.getBookBorrowRecord("E","Science");
        assertNull(b2);

    }

    @Test
    void testLoad() throws IOException {
        BookBorrowRecordRoom another = new BookBorrowRecordRoom();
        another.getBookBorrowRecords().add(bbr3);
        another.getBookBorrowRecord("Ocean","Geography").updateAllBorrowInfoForBorrow("Tina",2);
        //another.save1("./data/testBorrowersListFile.txt");
        another.save1("./data/testBorrowersListFile.txt");
        testBookBorrowRecordRoom.load("./data/testBorrowersListFile.txt");
        int size1 = another.getBookBorrowRecord("Ocean", "Geography").getAllBorrowInfoMap().size();
        int size2 = testBookBorrowRecordRoom.getBookBorrowRecord
                ("Ocean", "Geography").getAllBorrowInfoMap().size();
        assertEquals(size1,size2);
        //int size3 = another.getBookBorrowRecords().size();
        //int size4 = testBookBorrowRecordRoom.getBookBorrowRecords().size();

    }

    @Test
    void testSave1() throws IOException {
        BookBorrowRecordRoom another = new BookBorrowRecordRoom();
        testBookBorrowRecordRoom.getBookBorrowRecords().add(bbr3);
        testBookBorrowRecordRoom.getBookBorrowRecord("Ocean","Geography").updateAllBorrowInfoForBorrow
                ("Tina",2);
        testBookBorrowRecordRoom.getBookBorrowRecord("Earth","Science").updateAllBorrowInfoForBorrow
                ("Tim",2);
        testBookBorrowRecordRoom.getBookBorrowRecord("Make","Arts").updateAllBorrowInfoForBorrow
                ("Tony",1);
        testBookBorrowRecordRoom.getBookBorrowRecord("Make","Arts").updateAllBorrowInfoForBorrow
                ("Sam",3);
        testBookBorrowRecordRoom.save1("./data/testBorrowersListFile.txt");
        another.load("./data/testBorrowersListFile.txt");
        //another.load1("./data/testBorrowersListFile.txt");
        int size1 = another.getBookBorrowRecord("Ocean", "Geography").getAllBorrowInfoMap().size();
        int size2 = testBookBorrowRecordRoom.getBookBorrowRecord
                ("Ocean", "Geography").getAllBorrowInfoMap().size();
        assertEquals(size2, size1);
        int size3 = another.getBookBorrowRecords().size();
        int size4 = testBookBorrowRecordRoom.getBookBorrowRecords().size();
        assertEquals(size4,size3);


    }

    @Test
    void testLoad1() throws IOException {
        assertNull(testBookBorrowRecordRoom.load1("./data/testBorrowersListFile.txt"));
    }




}
