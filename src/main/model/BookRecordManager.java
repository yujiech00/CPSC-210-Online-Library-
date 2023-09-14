package model;

import exception.NoEnoughBookException;
import exception.WrongPlaceToReturnException;

import java.io.IOException;
import java.util.ArrayList;

public class BookRecordManager {
    private ArrayList<BookRecord> bookRecords;
    private LibraryManager libraryManager;
    private String workplace;

    private static final int empty = 0;
    private Book b1 = new Book("Science", "Earth", null);
    private Book b2 = new Book("Science", "Mars", null);
    private Book b3 = new Book("Science", "Moon", null);

    private Book b4 = new Book("Arts", "Asian Study", null);
    private Book b5 = new Book("Arts", "Western Study", null);
    private Book b6 = new Book("Engineering", "BIOL", null);

    private Book b7 = new Book("Engineering", "CHEM", null);


    //private Borrower p1 = null;
    private int n1 = 1;
    private BookRecord bi1 = new BookRecord(b1, n1);
    /////////private BookRecord bi1 = new BookRecord(b1, p1, n1);

    private int n2 = 2;
    private BookRecord bi2 = new BookRecord(b2, n2);
    /////////private BookRecord bi2 = new BookRecord(b2, p2, n2);

    //private Borrower p3 = new Borrower("Jane");
    private BookRecord bi3 = new BookRecord(b3, empty);
    ///////////private BookRecord bi3 = new BookRecord(b3, p3, empty);


    //private Borrower p4 = null;
    private int n4 = 3;
    private BookRecord bi4 = new BookRecord(b4, n4);
    /////////private BookRecord bi4 = new BookRecord(b4, p4, n4);

    //private Borrower p5 = new Borrower("Selena");
    private BookRecord bi5 = new BookRecord(b5, empty);
    /////////////private BookRecord bi5 = new BookRecord(b5, p5, empty);

    //private Borrower p6 = null;
    private int n6 = 5;
    private BookRecord bi6 = new BookRecord(b6, n6);
    ////////////private BookRecord bi6 = new BookRecord(b6, p6, n6);

    //private Borrower p7 = new Borrower("Sherry");
    private BookRecord bi7 = new BookRecord(b7, empty);
    ///////////private BookRecord bi7 = new BookRecord(b7, p7, empty);



    public BookRecordManager() {
        bookRecords = new ArrayList<>();
        initializeBookList();
        //libraryManager = new LibraryManager();
        //bookRecords = libraryManager.getBookRecords();
    }


    //EFFECTS: initialize bookList
    private void initializeBookList() {
//        b1.setBookRecord(bi1);
//        b2.setBookRecord(bi2);
//        b3.setBookRecord(bi3);
//        b4.setBookRecord(bi4);
//        b5.setBookRecord(bi5);
//        b6.setBookRecord(bi6);
//        b7.setBookRecord(bi7);
        bi1.setAvailableStatus();
        bi2.setAvailableStatus();
        bi3.setAvailableStatus();
        bi4.setAvailableStatus();
        bi5.setAvailableStatus();
        bi6.setAvailableStatus();
        bi7.setAvailableStatus();
        makeBookRecordsList();
    }

    // EFFECTS: initialize bookRecordList
    private void makeBookRecordsList() {
        bookRecords.add(bi1);
        bookRecords.add(bi2);
//        bookRecords.add(bi3);
//        bookRecords.add(bi4);
//        bookRecords.add(bi5);
//        bookRecords.add(bi6);
//        bookRecords.add(bi7);
    }


    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }



    public ArrayList<BookRecord> getBookRecords() {
        return this.bookRecords;
    }

    //EFFECTS: throw new WrongPlaceToReturnException if targeted bookRecord is not found;
    //         otherwise return books to the library and change book record
    public void changeBookRecordSystemForReturn(
            String bkn, String bkt, int numReturn, String returnerName, String fileNameForB) throws
            IOException, WrongPlaceToReturnException {
        /////////bookBorrowRecordRoom.load1(fileNameForB);
        ///////////////Book bookToBeReturned = new Book(bkt, bkn, TRUE, null);
        Book bookToBeReturned = new Book(bkt, bkn, null);
        BookRecord current = findBookRecord(bookToBeReturned);
        if (current == null) {
            System.out.println("Borrow Record not found! Wrong place to return!");
            throw new WrongPlaceToReturnException();

        } else {
            current.setNumberPlus(numReturn);
            BookBorrowRecord currentRecord = libraryManager.getBookBorrowRecordRoom().getBookBorrowRecord(bkn, bkt);
            currentRecord.updateAllBorrowInfoForReturn(returnerName, numReturn);

        }

        //save1(fileNameForB);
    }

    // EFFECTS: return true if there are enough targeted book to be borrowed; otherwise return false
    public boolean enoughBookToBeBorrowed(int numberToBeBorrowed, String bkn, String bkt) {
        Book targetBook = new Book(bkt, bkn, null);
        BookRecord target = findBookRecord(targetBook);
        if (target == null) {
            return false;
        } else {
            int maxNumberAvailable = target.getNumber();
            if (numberToBeBorrowed <= maxNumberAvailable) {
                return true;
            } else {
                System.out.println("Sorry, we do not have enough book left");
                return false;
            }
        }
    }


    // EFFECTS: return true if the target books is found and enough to be borrowed; otherwise return false
    public boolean canBookBeBorrowedOrNot(String bookName, String bookType) {
//////////        Book targetedBook = new Book(bookType, bookName, FALSE, null);
        Book targetedBook = new Book(bookType, bookName, null);
        BookRecord result = findBookRecord(targetedBook);
//        if (bookRecords.size() != 0) {
//            for (BookRecord bi : bookRecords) {
//                if (bi.getBook().getType() == bookType && bi.getBook().getTitle() == bookName) {
        if (result == null) {
            System.out.println("Book Not Available in this library");
            return false;
        }
        if (result.getNumber() == 0) {
            System.out.println("Please wait for others to return");
            return false;
        } else {
            System.out.println("Available Number: " + result.getNumber());
            return true;
        }
    }

    //EFFECTS: when adding books to library,
    //         add new bookRecord to library if it is not found, otherwise change bookRecord
    public void changeBookRecordSystemForAdd(BookRecord biAdded) {
        BookRecord searchResult = findBookRecord(biAdded.getBook());
        if (searchResult == null) {
            bookRecords.add(biAdded);
        } else {
            searchResult.setNumberPlus(biAdded.getNumber());
        }
    }

    // EFFECTS: return targeted bookRecord if it is found, otherwise return null
    public BookRecord findBookRecord(Book bk) {

        for (BookRecord bi : bookRecords) {
            if (bi.getBook().equals(bk)) {
//            if (bk.getTitle().equals(bi.getBook().getTitle())
//                    && bk.getType().equals(bi.getBook().getType())) {
                return bi;
            }
        }
        return null;
    }

    // MODIFIES: this
    // EFFECTS: change bookRecord in the system for targeted bookRecord
    public void changeBookRecordSystem(BookRecord biAdded) {
        BookRecord searchResult = findBookRecord(biAdded.getBook());
        if (searchResult == null) {
            bookRecords.add(biAdded);
        } else {
            //searchResult.setNumber(biAdded.getNumber());
            searchResult.setNumber(biAdded.getNumber());////// something wrong here

        }
    }


    public void setLibraryManager(LibraryManager lm) {
        if (this.libraryManager != lm) {
            this.libraryManager = lm;
            // bookRecords = libraryManager.getBookRecords();
            lm.setBookRecordManager(this);
        }
    }

    // EFFECTS: return associated bookRecord if targetedBook is found in library,
    //          otherwise, return null
    public BookRecord accessToBookRecord(Book targetedBook) {
        for (Book bk : libraryManager.getLibrary()) {
            if (targetedBook.equals(bk)) {
                return bk.getBookRecord();
            }
        }
        return null;
    }


    public void setBookRecords(ArrayList<BookRecord> bookRecords) {
        this.bookRecords = bookRecords;
    }
}
