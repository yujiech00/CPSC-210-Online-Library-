package model;

import exception.BorrowerNotExistException;
import exception.WrongPlaceToReturnException;

import javax.naming.Name;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Boolean.FALSE;

public class BookBorrowRecord {
    private String bookName;
    private String bookType;
    //// private ArrayList<NamePlusBorrowNumber> allBorrowInfo;
    private Map<String, NamePlusBorrowNumber> allBorrowInfoMap;


    public BookBorrowRecord(String bookName, String bookType) {
        this.bookName = bookName;
        this.bookType = bookType;
        ////this.allBorrowInfo = new ArrayList<>();
        this.allBorrowInfoMap = new HashMap<>();
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getBookType() {
        return this.bookType;
    }


    public void setAllBorrowInfoMap(ArrayList<NamePlusBorrowNumber> namePlusBorrowNumbersList) {
        for (NamePlusBorrowNumber nb : namePlusBorrowNumbersList) {
            allBorrowInfoMap.put(nb.getName(), nb);
        }
    }


    public Map<String, NamePlusBorrowNumber> getAllBorrowInfoMap() {
        return allBorrowInfoMap;
    }


    // EFFECTS: return the number of books that a borrower borrowed if he is found in the allBorrowInfoMap
    //          otherwise throw BorrowerNotExistException
    public int getBorrowNumForCertainBorrower(String name) throws BorrowerNotExistException {
        if (allBorrowInfoMap.get(name) != null) {
            return allBorrowInfoMap.get(name).getBorrowNum();
        } else {
            throw new BorrowerNotExistException();
        }
    }


    // EFFECTS: if the same borrow info is found, add this time's borrow number to that record
    //          otherwise add a new borrow info
    public void updateAllBorrowInfoForBorrow(String name, int num) {
        if (allBorrowInfoMap.get(name) != null) {
            allBorrowInfoMap.get(name).setBorrowNum(num);
        } else {
            NamePlusBorrowNumber newAdded = new NamePlusBorrowNumber(name, num);
            allBorrowInfoMap.put(name, newAdded);
        }
    }


    // MODIFIES: this
    // EFFECTS: if the borrow info with the given name anf num is found, then edit the number in the record
    //          by subtracting the return number from it and the number becomes 0, remove this info ;
    //          otherwise, throw WrongPlaceToReturnException
    public void updateAllBorrowInfoForReturn(String name, int num) throws WrongPlaceToReturnException {
        NamePlusBorrowNumber result = allBorrowInfoMap.get(name);
        if (result != null) {
            result.setBorrowNum((-1 * num));
            if (result.getBorrowNum() == 0) {
                allBorrowInfoMap.remove(name, result);
            }
        } else {
            throw new WrongPlaceToReturnException();
        }
    }

//        for (NamePlusBorrowNumber n : allBorrowInfo) {
//            if (n.getName().equals(name)) {
//                n.setBorrowNum((-1) * num);
//                if (n.getBorrowNum() == 0) {
//                    allBorrowInfo.remove(n);
//                }
//                return;
//            }
//        }
//        throw new WrongPlaceToReturnException();


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BookBorrowRecord)) {
            return false;
        }
        BookBorrowRecord that = (BookBorrowRecord) o;
        return bookName.equals(that.bookName)
                && bookType.equals(that.bookType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, bookType);
    }
}






