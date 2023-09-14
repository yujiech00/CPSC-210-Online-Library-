package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Book {
    private String type;
    private String title;
    private BookRecord bookRecord;


    public Book() {
        type = "";
        title = "";

    }


    public Book(String type, String title,BookRecord bookRecord) {
        this.type = type;
        this.title = title;
        this.bookRecord = bookRecord;

    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return this.title;
    }

    public BookRecord getBookRecord() {
        return this.bookRecord;
    }


    public void setBookType(String bt) {
        this.type = bt;
    }


    public void setBookTitle(String bti) {
        this.title = bti;
    }

    public void setBookRecord(BookRecord bi) {
        if (this.bookRecord != bi) {
            this.bookRecord = bi;
            bookRecord.setBook(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return type.equals(book.type) && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title);
    }




    ////delete status field------------------------------

//    // EFFECTS: return "AVAILABLE" if book status is true, otherwise return false
//    public String getStatus() {
//        if (this.status) {
//            return "AVAILABLE";
//        } else {
//            return "NOT AVAILABLE";
//        }
//    }

    //public boolean getStatus2() {
        //return this.status;
    //}



//    // set/reset the status of book
//    // MODIFIES: this
//    // EFFECTS: set the status of book to be false if number of book in bookRecord is zero,
//    //          otherwise set book status to be true
//    public void setBookStatus() {
//        if (this.bookRecord.getNumber() == 0) {
//            this.status = Boolean.FALSE;
//        } else {
//            this.status = Boolean.TRUE;
//        }
//    }



    //    public void removeBorrowerNameForReturn(String brn,int returnNum) {
//        int i = 0;
//        for (String name : allBorrowerNames) {
//            if (name.equals(brn)) {
//                if (i < returnNum) {
//                    allBorrowerNames.remove(name);
//                    i++;
//                }
//
//            }
//        }
//    }


//    @Override
//    public void load1() throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("./data/borrowersListFile.txt"));
//        // for (String line: lines) {
//        //     System.out.println(line);
//        //  }
//        //String bookName = "";
//        //String bookType = "";
//        //String numberAvailable = "0";
//        //int bookNum;
//        for (String line : lines) {
//            if (line.equals("")) {
//                Book bk = new Book("", "", FALSE, null);
//            }
//
//            if (bookName.equals("")) {
//                bookName = line;
//                //bk.setBookTitle(line);
//            } else if (bookType.equals("")) {
//                bookType = line;
//
//            } else if (line.equals("__________________________________")) {
//                reNew();
//
//            } else {
//                allBorrowerNames.add(line);
//            }
//
//
//        }
//    }
//
//
//    private void reNew() {
//        bookName = "";
//        bookType = "";
//
//    }
//
//
//
//
//
//
//
//
//
//
//    @Override
//    public void save1() throws IOException {
//        PrintWriter writer = new PrintWriter("./data/borrowersListFile.txt", "UTF-8");
//        writer.println(this.getTitle());
//        //System.out.println(bk.getTitle());
//        writer.println(this.getType());
//        //System.out.println(bk.getType());
//        for (String brn : allBorrowerNames) {
//            writer.println(brn);
//
//        }
//        writer.println("__________________________________");
//        writer.close();
//
//    }
}


