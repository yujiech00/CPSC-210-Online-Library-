package model;

import exception.EmptyBookShelfException;

import java.util.ArrayList;

public abstract class BookShelf {
    protected ArrayList<Book> bookList;

    public BookShelf() {
        this.bookList = new ArrayList<>();

    }

    public ArrayList<Book> getBookList() {
        return this.bookList;
    }

    //EFFECTS: return targeted book if it is found on the shelf, otherwise return null
    public Book tryToFindBookOnShelf(String bkn,String bkt) throws EmptyBookShelfException {
        if (bookList.size() == 0) {
            throw new EmptyBookShelfException();
        } else {
            for (Book bk : bookList) {
                //if (bk.equals(new Book(bkt,bkn,Boolean.TRUE,null)))
                if (bk.getTitle().equals(bkn) && bk.getType().equals(bkt)) {
                    return bk;
                }
            }
            return null;
        }
    }

    //EFFECTS: show bookShelf name
    public abstract void showBookShelfName();





//    public void getSpecificPositionOnShelf(Book targetBook) {
//        int position;
//        for (Book bk: bookList) {
//            position = 0;
//            if (position >= bookList.size()) {
//                System.out.println("Book is not found");
//            } else {
//                if (bk.getTitle().equals(targetBook.getTitle())) {
//                    System.out.println("Position: " + position + "on the" + targetBook.getType() + "shelf");
//                } else {
//                    position++;
//                }
//            }
//        }
//
//
//    }


}
