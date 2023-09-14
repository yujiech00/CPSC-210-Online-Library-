package model;

import exception.BorrowerNotExistException;
import exception.NoEnoughBookException;
import exception.WrongPlaceToReturnException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryManagerTest {
    private LibraryManager testLibraryManager;
    private LibraryManager testLibraryManager2;
    private LibraryManager testLibraryManager3;
    private Book b1;
    private Member p1;
    private BookRecord bookRecord1;
    private Book b2;
    private BookRecord bookRecord2;
    private Book b3;
    private BookRecord bookRecord3;
    private Book b4;
    private BookRecord bookRecord4;
    private ArrayList<Book> bookList1;
    private ArrayList<Book> bookList2;
    private ArrayList<String> testLoadResults;
    private ArrayList<BookRecord> bookRecordList;
    private BookBorrowRecord newAdded1;
    private BookBorrowRecord newAdded2;
    private BookRecordManager bookRecordManager;


    @BeforeEach
    void setUp() {
        testLibraryManager = new LibraryManager();
        testLibraryManager2 = new LibraryManager();
        testLibraryManager3 = new LibraryManager();
        bookRecordManager = new BookRecordManager();
//        b1 = new Book("Science", "Earth", TRUE, null);
        b1 = new Book("Science", "Earth", null);
        p1 = new Member("",1);
        bookRecord1 = new BookRecord(b1,1);
        ////////////bookRecord1 = new BookRecord(b1, p1, 1);
        b1.setBookRecord(bookRecord1);
//        b2 = new Book("Geography", "Earth", TRUE, null);
        b2 = new Book("Geography", "Earth",null);
        bookRecord2 = new BookRecord(b2,0);
        //////////bookRecord2 = new BookRecord(b2, p1, 0);
        b2.setBookRecord(bookRecord2);
//        b3 = new Book("Engineering", "Earth", TRUE, null);
        b3 = new Book("Engineering", "Earth", null);
        bookRecord3 = new BookRecord(b3, 1);
        //////////////bookRecord3 = new BookRecord(b3, p1, 1);
        b3.setBookRecord(bookRecord3);
//        b4 = new Book("Arts", "Asian Study", TRUE, null);
        b4 = new Book("Arts", "Asian Study",null);
        bookRecord4 = new BookRecord(b4,1);
        ///////////bookRecord4 = new BookRecord(b4, p1, 1);
        b4.setBookRecord(bookRecord4);
        bookList1 = new ArrayList<>();
        bookList1.add(b1);
        bookList1.add(b2);
        bookList2 = new ArrayList<>();
        bookList2.add(b1);
        bookList2.add(b2);
        bookList2.add(b3);
        bookList2.add(b4);
        bookRecordList = new ArrayList<>();
        bookRecordList.add(bookRecord1);
        bookRecordList.add(bookRecord2);
        testLibraryManager.setLibrary(bookList1);
        testLibraryManager.getBookRecordManager().setBookRecords(bookRecordList);
        testLibraryManager2.setLibrary(bookList2);
        testLoadResults = new ArrayList<>();
        testLoadResults.add("Earth");
        testLoadResults.add("Science");
        testLoadResults.add("1");
        testLoadResults.add("Earth");
        testLoadResults.add("Geography");
        testLoadResults.add("1");
        newAdded1 = new BookBorrowRecord("Earth", "Science");
        newAdded1.updateAllBorrowInfoForBorrow("Tom", 1);
        newAdded2 = new BookBorrowRecord("Make", "Arts");
        testLibraryManager.getBookBorrowRecordRoom().getBookBorrowRecords().add(newAdded1);


    }


    @Test
     void testAccessToBookRecord() {
        //BookRecord accessResult = testLibrary.accessToBookRecord(b1);
        //assertEquals(b1.getBookRecord(),accessResult);

        BookRecord accessResult2 = testLibraryManager.accessToBookRecord(b3);
        assertNull(accessResult2);
        BookRecord accessResult3 = testLibraryManager.accessToBookRecord(b1);
        assertEquals(b1.getBookRecord(),accessResult3);


    }


    @Test
    void testSave1() throws IOException {
        LibraryManager anotherLibraryManager = new LibraryManager();
        anotherLibraryManager.setLibrary(bookList1);
        anotherLibraryManager.save1("./data/testFile.txt");
         testLibraryManager.updateLibrarySystem(testLibraryManager.load1("./data/testFile.txt"));
        assertEquals(anotherLibraryManager.getLibrary().size(), testLibraryManager.getLibrary().size());
    }


    @Test
    void testLoad1() throws IOException {
        LibraryManager anotherLibraryManager = new LibraryManager();
        anotherLibraryManager.getBookRecordManager().setBookRecords(bookRecordList);
        anotherLibraryManager.getBookRecordManager().getBookRecords().add(bookRecord4);
        anotherLibraryManager.save1("./data/testFile.txt");
        testLibraryManager.updateLibrarySystem(testLibraryManager.load1("./data/testFile.txt"));
        ///assertEquals(testLibraryManager.getLibrary().size(), anotherLibraryManager.getLibrary().size());
        assertEquals(anotherLibraryManager.getBookRecordManager().getBookRecords().size(),
                testLibraryManager.getBookRecordManager().getBookRecords().size());

    }

    @Test
    void testLoad() throws IOException {
        int size1 = testLibraryManager.getBookRecordManager().getBookRecords().size();
        testLibraryManager.load("./data/testFile.txt");
        int size2 = testLibraryManager.getBookRecordManager().getBookRecords().size();
        assertEquals(size1,size2);

    }


    @Test
     void testFindBookRecord1() {
        BookRecord findResult;
        findResult = testLibraryManager.findBookRecord(b1);
        assertEquals(b1.getBookRecord(),findResult);
        findResult = testLibraryManager.findBookRecord(b3);
        assertNull(findResult);
        findResult = testLibraryManager2.findBookRecord(b2);
        assertNull(findResult);


    }


    @Test
    void testAccessToBookRecords() {
        BookRecord accessResult = testLibraryManager.accessToBookRecord(b1);
        Book r1 = accessResult.getBook();
        assertEquals(b1.getType(),r1.getType());
        assertEquals(b1.getTitle(),r1.getTitle());
        //b1.equals(accessResult);
        accessResult = testLibraryManager.accessToBookRecord(b4);
        assertNull(accessResult);
        //b4.equals(accessResult);

    }

    @Test
    void testGetBookRecords() {
        ArrayList<BookRecord> getResult = testLibraryManager.getBookRecordManager().getBookRecords();
        assertTrue(getCorrectBookRecordOrNot(testLibraryManager, getResult));


    }

    private boolean getCorrectBookRecordOrNot(LibraryManager lim, ArrayList<BookRecord> bl) {
        if (lim.getBookRecordManager().getBookRecords().size() != bl.size()) {
            return false;
        } else {
            for (int i = 0; i < bl.size(); i++) {
                if (!lim.getBookRecordManager().getBookRecords().get(i).equals(bl.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    void testChangeBookRecordSystemForReturn_ExceptionThrown() throws IOException {

        try {
            testLibraryManager.changeBookRecordSystemForReturn
                    ("Teamwork", "Sociology", 2, "Tom", "./data/testFile.txt");
            fail("Exception is not thrown");

        } catch (WrongPlaceToReturnException e) {
            //expected
        }
    }

    @Test
    void testChangeBookRecordSystemForReturn_ExceptionNotThrown() throws IOException {
        testLibraryManager.getBookBorrowRecordRoom().getBookBorrowRecord
                ("Earth","Science").updateAllBorrowInfoForBorrow("Nick",3);
        try {
            BookRecord r = testLibraryManager.findBookRecord(b1);
            testLibraryManager.changeBookRecordSystemForReturn
                    ("Earth", "Science", 2, "Nick", "./data/testFile.txt");
            assertEquals(3, r.getNumber());
            try {
                int num = testLibraryManager.getBookBorrowRecordRoom().getBookBorrowRecord
                        ("Earth","Science").getBorrowNumForCertainBorrower("Nick");
                assertEquals(1,num);
            } catch (BorrowerNotExistException e) {
                fail("Exception should not be thrown");
            }

        } catch (WrongPlaceToReturnException e) {
            fail("Exception should not be thrown!");
        }
    }


    @Test
    void testChangeBookRecordSystem2() {
        testLibraryManager.changeBookRecordSystem(bookRecord3);
        assertEquals(bookRecord3,testLibraryManager.findBookRecord(bookRecord3.getBook()));

        testLibraryManager.changeBookRecordSystem(bookRecord1);
        Book result = testLibraryManager.getBook(bookRecord1.getBook().getTitle(), bookRecord1.getBook().getType());
        assertNull(testLibraryManager3.getBook("Make","Arts"));
        assertEquals(1, result.getBookRecord().getNumber());
    }


    @Test
    void testEnoughBookToBeBorrowed() throws NoEnoughBookException {
        assertFalse(testLibraryManager.enoughBookToBeBorrowed(10, "Earth", "Science"));
        assertTrue(testLibraryManager.enoughBookToBeBorrowed(1, "Earth", "Science"));
    }


    @Test
    void testCanBookBeBorrowedOrNot() {
        assertFalse(testLibraryManager.canBookBeBorrowedOrNot("E","WW"));
        assertFalse(testLibraryManager.canBookBeBorrowedOrNot("Earth","Geography"));
        assertTrue(testLibraryManager.canBookBeBorrowedOrNot("Earth","Science"));
        assertFalse(testLibraryManager.canBookBeBorrowedOrNot("Earth","Geography"));
    }

    @Test
    void testChangeBookRecordSystemForAdd() {
        testLibraryManager.changeBookRecordSystemForAdd(bookRecord4);
        assertEquals(3,testLibraryManager.getBookRecordManager().getBookRecords().size());
        testLibraryManager.changeBookRecordSystemForAdd(bookRecord1);
        assertEquals(3,testLibraryManager.getBookRecordManager().getBookRecords().size());
    }

    @Test
    void testSetWorkplace() {
        testLibraryManager.setWorkplace("Vancouver");
        assertEquals("Vancouver",testLibraryManager.getWorkplace());
    }

    @Test
    void testSetBookRecordManager() {
        testLibraryManager.setBookRecordManager(bookRecordManager);
        assertEquals(bookRecordManager,testLibraryManager.getBookRecordManager());
    }

//    @Test
//    void testChangeBookBorrowRecordRoom() throws IOException {
//        BookBorrowRecord brr = new BookBorrowRecord("Earth","Science");
//        BookBorrowRecord brr2 = new BookBorrowRecord("Earth","Geography");
//        BookBorrowRecord brr3 = new BookBorrowRecord("Ocean","Geography");
//        testLibraryManager.changeBookBorrowRecordRoom(brr,1,"Tina","./data/testFile.txt");
//        assertEquals(1,testLibraryManager.getBookBorrowRecordRoom().getBookBorrowRecords().size());
//        testLibraryManager.changeBookBorrowRecordRoom(brr2,1,"Tim","./data/testFile.txt");
//        assertEquals(3,testLibraryManager.getBookBorrowRecordRoom().getBookBorrowRecords().size());
//        testLibraryManager.changeBookBorrowRecordRoom(brr3,1,"Tina","./data/testFile.txt");
//        assertEquals(4,testLibraryManager.getBookBorrowRecordRoom().getBookBorrowRecords().size());
//        testLibraryManager.changeBookBorrowRecordRoom(brr,1,"Tina","./data/testFile.txt");
//        assertEquals(4,testLibraryManager.getBookBorrowRecordRoom().getBookBorrowRecords().size());
//        try {
//            int r = testLibraryManager.getBookBorrowRecordRoom().getBookBorrowRecord
//                    ("Earth","Science").getBorrowNumForCertainBorrower("Tina");
//            assertEquals(2,r);
//        } catch (BorrowerNotExistException e) {
//           fail("BorrowerNotExistException should not be thrown");
//        }
//    }

    @Test
    void testAddNewBookToLibrary() {
        testLibraryManager.addNewBookToLibrary(new Book("Ecology","Earth",null));
        assertEquals(3,testLibraryManager.getLibrary().size());
        testLibraryManager.addNewBookToLibrary(new Book("Science","Earth",null));
        assertEquals(3,testLibraryManager.getLibrary().size());
        testLibraryManager.addNewBookToLibrary(new Book("Science","Ocean",null));
        assertEquals(4,testLibraryManager.getLibrary().size());
//        testLibraryManager.addNewBookToLibrary(new Book("Ecology","Earth",TRUE,null));
////        assertEquals(3,testLibraryManager.getLibrary().size());
////        testLibraryManager.addNewBookToLibrary(new Book("Science","Earth",TRUE,null));
////        assertEquals(3,testLibraryManager.getLibrary().size());
////        testLibraryManager.addNewBookToLibrary(new Book("Science","Ocean",TRUE,null));
////        assertEquals(4,testLibraryManager.getLibrary().size());
    }


    @Test
    void testGetInstance() {
        assertNotNull(LibraryManager.getInstance());
    }


}





//    @Test
//     void testLoad1() throws IOException {
//        testSave1();
//        List<String> lines = Files.readAllLines(Paths.get("./data/testFile.txt"));
//        ArrayList<String> loadResults = new ArrayList<>();
//        int i;
//        boolean loadSuccessfully = TRUE;
//        //String bookName = "";
//        //String bookType = "";
//        //String numberAvailable = "0";
//        //for (String line : lines) {
//        loadResults.addAll(lines);
//
//
//        for (i = 0; i < loadResults.size(); i++) {
//            if (!loadResults.get(i).equals(testLoadResults.get(i))) {
//                loadSuccessfully = FALSE;
//            }
//        }
//
//        assertFalse(loadSuccessfully);
//
//    }


//    @Test
//    public void testSave1() {
//        ArrayList<String> saveResults = new ArrayList<>();
//        for (int i = 0; i < testLibraryManager.getLibrary().size(); i++) {
//            Book currentBook = testLibraryManager.getLibrary().get(i);
//            saveResults.add(currentBook.getTitle());
//            saveResults.add(currentBook.getType());
//            Integer num = currentBook.getBookRecord().getNumber();
//            saveResults.add(num.toString());
//        }
//
//        StringWriter stringWriter = new StringWriter();
//        save2(stringWriter, saveResults);
//        assertEquals("Earth\nScience\n1\nEarth\nGeography\n1\n", stringWriter.toString());
//
//    }


//    @Test
//    void testChangeBookRecordSystemForReturn_ExpectNotThrown() throws IOException {
//
//        try {
//            Book bookToBeReturned = new Book("Science", "Earth", TRUE, null);
//            testLibraryManager.changeBookRecordSystemForReturn("Earth", "Science", 1, "Tim");
//            //expected
//            assertEquals(2, testLibraryManager.findBookRecord1(bookToBeReturned).getNumber());
//            assertEquals(0, testLibraryManager.findBookRecord1(bookToBeReturned).getBorrower().getAllBorrowerNames().size());
//
//        } catch (WrongPlaceToReturnException e) {
//            fail("WrongPlaceToReturnException should not be thrown ");
//            //e.printStackTrace();
//        }
//    }

//    public void save2(Writer writer, ArrayList<String> list) {
//        //testLibrary.save1();
//        PrintWriter out = new PrintWriter(writer);
//        //for (int i = 0; i < testLibrary.getLibrary().size(); i++) {
//        //Book currentBook = testLibrary.getLibrary().get(i);
//        for (Book currentBk : testLibraryManager.getLibrary()) {
//            out.println(currentBk.getTitle());
//            out.println(currentBk.getType());
//            out.println(currentBk.getBookRecord().getNumber());
//            //out.println();
//        }
//        out.close();
//    }
//
























