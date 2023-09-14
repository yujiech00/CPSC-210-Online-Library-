package model;


import java.io.IOException;
import java.util.Objects;

public class BookRecord {
    private Book book;
    //private Borrower borrower;
    private int number;
    private String availableStatus;

    // REQUIRES: book number n>=0
    // EFFECTS: Constructs a BookRecord with associated book, borrower
    //          and the number of book available now in library
    //public BookRecord() {

    //}

    public BookRecord(Book b,int n) {
        this.book = b;
        //this.borrower = p;
        this.number = n;
        availableStatus = "";

    }

    public Book getBook() {
        return this.book;
    }

    public int getNumber() {
        return this.number;
    }

    // set/reset the number of BookRecord

    // MODIFIES: this
    // EFFECTS: reset number of book in related BookRecord given a number change of integer n
    public void setNumberPlus(int n) {
        this.number = this.number + n;

    }

    public void setNumberMinus(int num) {
        this.number = this.number - num;

    }

    public void setNumber(int num) {

        this.number = num;
    }

    public String getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus() {
        if (this.number != 0) {
            this.availableStatus = "AVAILABLE";
        } else {
            this.availableStatus = "NOT AVAILABLE";
        }
    }


    /////added

//    // EFFECTS: return "AVAILABLE" if book number is not 0, otherwise return false
//    public String availableOrNot() {
//        return availableStatus;
//    }


    ////////////////////
    public void setBook(Book book) {
        if (this.book != book) {
            this.book = book;
            book.setBookRecord(this);
        }

    }



    //public Borrower getBorrower() {
        //return this.borrower;
    //}


/////////delete borrower

//    // set/reset the borrower in a bookRecord
//    // MODIFIES: this
//    // EFFECTS: reset the borrower in related bookRecord using the given borrower
//    public void setBorrower(Borrower p) {
//        this.borrower = p;
//    }
//


    // EFFECTS: set availableStatus to NOT AVAILABLE if book num is 0, otherwise AVAILABLE
    //          print out bookRecord about targeted book
    public void showBookRecord() {
        setAvailableStatus();
        System.out.println(this.book.getTitle() + " " + this.book.getType() + " "
                + availableStatus + " " + this.number);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookRecord that = (BookRecord) o;
        return book.equals(that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }
}











