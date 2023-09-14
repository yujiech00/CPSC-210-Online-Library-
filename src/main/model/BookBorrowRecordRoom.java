package model;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class BookBorrowRecordRoom implements Loadable,Savable {

    private String bookName;
    private String bookType;
    private String name;
    private String num;
    private ArrayList<String> recordLines;
    private ArrayList<BookBorrowRecord> bookBorrowRecords;

    public BookBorrowRecordRoom() {

        bookBorrowRecords = new ArrayList<>();
    }

    public ArrayList<BookBorrowRecord> getBookBorrowRecords() {

        return bookBorrowRecords;
    }

    @Override
    // EFFECTS: always return null
    public ArrayList<BookRecord> load1(String fileName) throws IOException {
        return null;
    }


    // MODIFIES: this
    // EFFECTS: load the record in the file about bookBorrowRecord into bookRecordRoom
    @Override
    public void load(String fileNameForB) throws IOException {
        // add everything before ------ into an arraylist
        List<String> lines = Files.readAllLines(Paths.get(fileNameForB));
        totallyRenew();
        for (String line : lines) {
            if (line.equals("__________________________")) {
                totallyRenew();
            } else if (line.equals("------------------------")) {
                addBorrowRecordToRoom(recordLines);
                renewRecordLines();
            } else {
                recordLines.add(line);

            }
//                if (bookName.equals("")) {
//                    bookName = line;
//                    //recordLines.add(bookName);
//                } else if (bookType.equals("")) {
//                    bookType = line;
//                    //recordLines.add(bookType);
//                } else if (name.equals("")) {
//                    name = line;
//                    //recordLines.add(name);
//                } else if (num.equals("0")) {
//                    num = line;
//                    //recordLines.add(name);
//                }

        }
    }


//    private void lineInfo(String line) {
//        if (bookName.equals("")) {
//            bookName = line;
//            recordLines.add(bookName);
//        } else if (bookType.equals("")) {
//            bookType = line;
//            recordLines.add(bookType);
//            //BookBorrowRecord newToAdd = new BookBorrowRecord(bookName,bookType);
//            //updateBookBorrowRecords(newToAdd);
//        } else if (name.equals("")) {
//            name = line;
//            recordLines.add(name);
//        } else if (num.equals("0")) {
//            num = line;
//            recordLines.add(num);
//
//            ///BookBorrowRecord newToAdd = new BookBorrowRecord(bookName,bookType);
//            ///updateBookBorrowRecords(newToAdd);
//            ///bookBorrowRecords.add(newToAdd);//////
//            ///getBookBorrowRecord(bookName,bookType).updateAllBorrowInfo(name,Integer.parseInt(num));
//            reNew2();
//        }
//    }


    // MODIFIES: this
    // EFFECTS: add bookBorrowRecord to bookRecordRoom
    private void addBorrowRecordToRoom(ArrayList<String> recordLines) {
        if (recordLines.size() >= 2) {
            ///BookBorrowRecord toAdd = new BookBorrowRecord(recordLines.get(0), recordLines.get(1));
            BookBorrowRecord toAdd = findOrCreateBookBorrowRecordWhenBorrow(recordLines.get(0), recordLines.get(1));
            recordLines.remove(0);
            recordLines.remove(0);
            reNewNameAndNum();
            for (String r : recordLines) {
                if (name.equals("")) {
                    name = r;
                    //index++;
                } else {
                    num = r;
                    int number = Integer.parseInt(num);
                    toAdd.updateAllBorrowInfoForBorrow(name, number);
                    //index++;
                    reNewNameAndNum();
                }
            }
        }


    }


    // when borrowing books, get or create and get
    // MODIFIES: this
    // EFFECTS: when borrowing, return thr bookBorrowRecord if it is found,
    //          otherwise create a new one and return it
    public BookBorrowRecord findOrCreateBookBorrowRecordWhenBorrow(String bookName,String bookType) {

        for (BookBorrowRecord brr : bookBorrowRecords) {
            if (brr.getBookName().equals(bookName) && brr.getBookType().equals(bookType)) {
                return brr;
            }
        }

        BookBorrowRecord newToAdd = new BookBorrowRecord(bookName, bookType);
        bookBorrowRecords.add(newToAdd);
        return newToAdd;///////////
    }

    private void reNewNameAndNum() {
        name = "";
        num = "0";
    }

    // MODIFIES: this
    // EFFECTS: reset fields for load to initial value
    private void totallyRenew() {
        bookName = "";
        bookType = "";
        name = "";
        num = "0";
        recordLines = new ArrayList<>();
    }

    private void renewRecordLines() {
        recordLines = new ArrayList<>();
    }


    // EFFECTS: save existing bookBorrowRecord to the file
    @Override
    public void save1(String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");

        for (BookBorrowRecord bookBorrowRecord : bookBorrowRecords) {
            //writer.println("____________________________");
            ////writer.println(bookBorrowRecord.getBookName());
            //System.out.println(bk.getTitle());
            ////writer.println(bookBorrowRecord.getBookType());
            //System.out.println(bk.getType());

            /////ArrayList<NamePlusBorrowNumber> namePlusBorrowNumbers = bookBorrowRecord.getAllBorrowInfo();
            Collection<NamePlusBorrowNumber> namePlusBorrowNumbers = bookBorrowRecord.getAllBorrowInfoMap().values();

            //String currentBN = bookBorrowRecord.getBookName();////
            //String currentBT = bookBorrowRecord.getBookType();////
            for (NamePlusBorrowNumber n : namePlusBorrowNumbers) {
                writer.println(bookBorrowRecord.getBookName());/////
                writer.println(bookBorrowRecord.getBookType());/////
                writer.println(n.getName());
                int x = n.getBorrowNum();
                String xc = Integer.toString(x);
                writer.println(xc);
                writer.println("------------------------");
            }
            writer.println("__________________________");
        }

        writer.close();

    }


    //EFFECTS: return targeted bookBorrowRecord if it is found ; otherwise return null
    public BookBorrowRecord getBookBorrowRecord(String bookName,String bookType) {
        for (BookBorrowRecord bookBorrowRecord : bookBorrowRecords) {
            if (bookBorrowRecord.equals(new BookBorrowRecord(bookName,bookType))) {
                return  bookBorrowRecord;
            }
        }
        return  null;
    }




}
