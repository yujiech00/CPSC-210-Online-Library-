package model;

import ui.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


// represents a list of bookRecord (book+borrower+number of book available)
public class Reservation {

    private ArrayList<BookRecord> bookRecords;
    ///private String bookName;


    // EFFECTS: constructs an array-list for storing bookRecord in the library
    public Reservation() {
        bookRecords = new ArrayList<>();


    }


    // search the bookRecord wanted in reservations given bookName
    // EFFECTS: return the bookRecord wanted if book name input is found in reservations
    // and return null otherwise

//    public BookRecord findBookRecord(Book bk) {
//        ArrayList<BookRecord> bookRecordsLibraryList = new Library().getBookRecords();
//        for (BookRecord bi : bookRecordsLibraryList) {
//            if (bk.getTitle().equals(bi.getBook().getTitle())
//                    && bk.getType().equals(bi.getBook().getType())) {
//                return bi;
//            }
//        }
//        return null;
//    }



}






    // MODIFIES: this, biAdded in Reservation (if it already exists)
    // EFFECTS: BookInfo biAdded is added to the Reservation and its number is exactly biAdd.number
    //          if biAdded is not in Reservation before;
    //          bi's number is increased by biAdded.number otherwise
//    public void addBookRecord(BookRecord biAdded) {
//
//        //BookRecord newBookRecord = new BookRecord()
//
//        if (reservations.size() == 0) {
//            reservations.add(biAdded);
//        } else {
//            if (findBookRecord(biAdded.getBook()) == null) {
//                reservations.add(biAdded);
//            } else {
//                findBookRecord(biAdded.getBook()).setNumber(biAdded.getNumber());
//            }
//        }
//    }













    // create a library bookRecord list
    // MODIFIES: this
    // EFFECTS: arrange all BookRecord had to Reservation





//    public void bookRecordNew(Book bookNew, Borrower p, int bnAdded) {
//        BookRecord newBookRecord = new BookRecord(bookNew, p, bnAdded);
//        reservations.add(newBookRecord);
//    }
//
//    public void bookRecordUpdate(Book bookUpdate, Borrower p, int bnAdded) {
//        BookRecord newBookRecord = new BookRecord(bookUpdate, p, bnAdded);
//        reservations.add(newBookRecord);
//    }
//}
//


















