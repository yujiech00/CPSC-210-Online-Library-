package model;

import exception.NoEnoughBookException;
import exception.WrongPlaceToReturnException;
import ui.Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class LibraryManager implements Loadable,Savable {
    private ArrayList<Book> library;
    private ArrayList<BookRecord> bookRecordsLoaded;
    private static LibraryManager instance;


   /////////////// private ArrayList<BookRecord> bookRecords;
    private BookBorrowRecordRoom bookBorrowRecordRoom;
    private BookRecordManager bookRecordManager;
    private String workplace;


    private static final int empty = 0;
    private Book b1 = new Book("Science", "Earth", null);
    private Book b2 = new Book("Science", "Mars", null);
    private Book b3 = new Book("Science", "Moon", null);

    private Book b4 = new Book("Arts", "Asian Study", null);
    private Book b5 = new Book("Arts", "Western Study", null);
    private Book b6 = new Book("Engineering", "BIOL", null);

    private Book b7 = new Book("Engineering", "CHEM", null);
//    private Book b1 = new Book("Science", "Earth", TRUE, null);
//    private Book b2 = new Book("Science", "Mars", TRUE, null);
//    private Book b3 = new Book("Science", "Moon", FALSE, null);
//
//    private Book b4 = new Book("Arts", "Asian Study", TRUE, null);
//    private Book b5 = new Book("Arts", "Western Study", FALSE, null);
//    private Book b6 = new Book("Engineering", "BIOL", TRUE, null);
//
//    private Book b7 = new Book("Engineering", "CHEM", FALSE, null);


    //private Borrower p1 = null;
    private int n1 = 1;
    private BookRecord bi1 = new BookRecord(b1, n1);
    /////////private BookRecord bi1 = new BookRecord(b1, p1, n1);


    //private Borrower p2 = null;
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

    private String bookName = "";
    private String bookType = "";
    private String numberAvailable = "0";


    // EFFECTS: construct a library with a list of Book
    //          and Reservation (list of bookRecord)
    public LibraryManager() {
        library = new ArrayList<>();
        //reservation = new Reservation();

        /////////////bookRecords = new ArrayList<>();

        //bookBorrowRecords = new ArrayList<>();
        bookBorrowRecordRoom = new BookBorrowRecordRoom();
        initializeLibrary();
        bookRecordManager = new BookRecordManager();
        bookRecordManager.setLibraryManager(this);
        bookRecordManager.setWorkplace(workplace);
        bookRecordsLoaded = new ArrayList<>();

    }





    public ArrayList<Book> getLibrary() {
        return this.library;
    }


    public static LibraryManager getInstance() {
        if (instance == null) {
            instance = new LibraryManager();
        }
        return instance;
    }



    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getWorkplace() {
        return workplace;
    }





    // EFFECTS: return associated bookRecord if targetedBook is found in library,
    //          otherwise, return null
    public BookRecord accessToBookRecord(Book targetedBook) {
        return bookRecordManager.accessToBookRecord(targetedBook);

    }



//////// for brm

    // EFFECTS: changeBookRecordSystem For Return
    public void changeBookRecordSystemForReturn(
            String bkn, String bkt, int numReturn, String returnerName, String fileNameForB) throws
            IOException, WrongPlaceToReturnException {
        /////////bookBorrowRecordRoom.load1(fileNameForB);
        ///////////////Book bookToBeReturned = new Book(bkt, bkn, TRUE, null);

        bookRecordManager.changeBookRecordSystemForReturn(bkn,bkt,numReturn, returnerName,fileNameForB);

////------------------------------------------------------------
//
//        Book bookToBeReturned = new Book(bkt, bkn, null);
//        BookRecord current = findBookRecord(bookToBeReturned);
//        if (current == null) {
//            System.out.println("Borrow Record not found! Wrong place to return!");
//            throw new WrongPlaceToReturnException();
//
//        } else {
//            current.setNumberPlus(numReturn);
//            BookBorrowRecord currentRecord = bookBorrowRecordRoom.getBookBorrowRecord(bkn, bkt);
//            currentRecord.updateAllBorrowInfoForReturn(returnerName, numReturn);

///------------------------------
            //current.getBorrower().removeAllReturnerNamesForReturnSystem(numReturn,returnerName);
            //if (current.getBorrower() != null) {
            //current.getBorrower().removeAllReturnerNamesForReturnSystem(numReturn, returnerName);
            //}
    }

        //save1(fileNameForB);
   // }

    // EFFECTS: check if there are enough books to be borrowed
    public boolean enoughBookToBeBorrowed(int numberToBeBorrowed, String bkn, String bkt) throws NoEnoughBookException {
        return bookRecordManager.enoughBookToBeBorrowed(numberToBeBorrowed, bkn, bkt);
    }


//        Book targetBook = new Book(bkt, bkn, null);
//        BookRecord target = findBookRecord(targetBook);
//        int maxNumberAvailable = target.getNumber();
//        if (numberToBeBorrowed <= maxNumberAvailable) {
//            return true;
//        } else {
//            System.out.println("Sorry, we do not have enough book left");
//            return false;
//        }
//    }


    // MODIFIES: this
    // EFFECTS: add new book to book list in library if it is not found
    //          otherwise do nothing
    public void addNewBookToLibrary(Book bk) {
        Book searchResult = getBook(bk.getTitle(), bk.getType());
        if (searchResult == null) {
            library.add(bk);
            //} else if (!searchResult.getType().equals(bk.getType())) {
            // library.add(bk);
        }
    }

    // MODIFIES: this
    // EFFECTS: set BookRecord for Book and make book list for library
    private void initializeLibrary() {
        b1.setBookRecord(bi1);
        b2.setBookRecord(bi2);
        b3.setBookRecord(bi3);
        b4.setBookRecord(bi4);
        b5.setBookRecord(bi5);
        b6.setBookRecord(bi6);
        b7.setBookRecord(bi7);
        bi1.setAvailableStatus();
        bi2.setAvailableStatus();
        bi3.setAvailableStatus();
        bi4.setAvailableStatus();
        bi5.setAvailableStatus();
        bi6.setAvailableStatus();
        bi7.setAvailableStatus();
        makeLibraryBookList();
       // makeBookRecordsList();

    }


    //EFFECTS: initialize library bookList
    private void makeLibraryBookList() {
        library.add(b1);
        library.add(b2);
        library.add(b3);
        library.add(b4);
        library.add(b5);
        library.add(b6);
        library.add(b7);

    }

//    private void makeBookRecordsList() {
//        bookRecords.add(bi1);
//        bookRecords.add(bi2);
//        bookRecords.add(bi3);
//        bookRecords.add(bi4);
//        bookRecords.add(bi5);
//        bookRecords.add(bi6);
//        bookRecords.add(bi7);
//    }


    // EFFECTS: return targeted book if it is found in library;
    //          otherwise, return null
    public Book getBook(String bookName, String bookType) {
        //if (library.size() != 0) {
        for (Book bk : library) {
            if (bookName.equals(bk.getTitle()) && bookType.equals(bk.getType())) {
                return bk;
            }

        }
        return null;
    }

    //EFFECTS: check if targeted book can be borrowed or not
    public boolean canBookBeBorrowedOrNot(String bookName, String bookType) {
        return bookRecordManager.canBookBeBorrowedOrNot(bookName,bookType);
    }

    //EFFECTS: change bookRecordSystem when adding books
    public void changeBookRecordSystemForAdd(BookRecord biAdded) {
        bookRecordManager.changeBookRecordSystemForAdd(biAdded);
    }



//    public boolean canBookBeBorrowedOrNot(String bookName, String bookType) {
////////////        Book targetedBook = new Book(bookType, bookName, FALSE, null);
//        Book targetedBook = new Book(bookType, bookName, null);
//        BookRecord result = findBookRecord(targetedBook);
////        if (bookRecords.size() != 0) {
////            for (BookRecord bi : bookRecords) {
////                if (bi.getBook().getType() == bookType && bi.getBook().getTitle() == bookName) {
//        if (result == null) {
//            System.out.println("Book Not Available in this library");
//            return false;
//        }
//        if (result.getNumber() == 0) {
//            System.out.println("Please wait for others to return");
//            return false;
//        } else {
//            System.out.println("Available Number: " + result.getNumber());
//            return true;
//        }
//    }





//    public void changeBookRecordSystemForAdd(BookRecord biAdded) {
//
//        // if (bookRecords.size() == 0) {
//        //bookRecords.add(biAdded);
//        //} else {
//        BookRecord searchResult = findBookRecord(biAdded.getBook());
//        if (searchResult == null) {
//            bookRecords.add(biAdded);
//        } else {
//            searchResult.setNumberPlus(biAdded.getNumber());
//        }
//    }






    @Override
    public void save1(String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        for (BookRecord br: getBookRecordManager().getBookRecords()) {
            writer.println(br.getBook().getTitle());
            //System.out.println(bk.getTitle());
            writer.println(br.getBook().getType());
            //System.out.println(bk.getType());
            writer.println(br.getNumber());
            // System.out.println(bk.getBookRecord().getNumber());


//        for (Book bk : library) {
//            writer.println(bk.getTitle());
//            //System.out.println(bk.getTitle());
//            writer.println(bk.getType());
//            //System.out.println(bk.getType());
//            writer.println(bk.getBookRecord().getNumber());
//            // System.out.println(bk.getBookRecord().getNumber());

        }
        writer.close();

    }

    // EFFECTS: return targeted  bookRecord if found, otherwise return false
    public BookRecord findBookRecord(Book bk) {
        return bookRecordManager.findBookRecord(bk);
    }

//    public BookRecord findBookRecord(Book bk) {
//        //ArrayList<BookRecord> bookRecordsLibraryList = getBookRecords();
//        //if (bookRecords.size() != 0) {
//        for (BookRecord bi : bookRecords) {
//            if (bi.getBook().equals(bk)) {
////            if (bk.getTitle().equals(bi.getBook().getTitle())
////                    && bk.getType().equals(bi.getBook().getType())) {
//                return bi;
//            }
//        }
//        return null;
//    }


    //} else {
    //return null;
    //}

///////change the return type to ArrayList

    // EFFECTS: return bookRecord list in file
    @Override
    public ArrayList<BookRecord> load1(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
//            if (line.equals("")) {
//                Book bk = new Book(bookType, bookName, FALSE, null);
//                //library.add(book);
//                //bookName = "";
//                //bookType = "";
//                //numberAvailable = "";
//            }

            if (bookName.equals("")) {
                bookName = line;
                //bk.setBookTitle(line);
            } else if (bookType.equals("")) {
                bookType = line;
                //bk.setBookType(line);
            } else if (numberAvailable.equals("0")) {
                ///////////Book bk = new Book(bookType, bookName, TRUE, null);
                Book bk = new Book(bookType, bookName, null);
                BookRecord bi = new BookRecord(bk, Integer.parseInt(line));
                //////////////////BookRecord bi = new BookRecord(bk, null, Integer.parseInt(line));
                bk.setBookRecord(bi);

                /////// new helper added below
                bookRecordsLoaded.add(bi);

                //library.add(book);
                //bookRecords.add(bi);
                addNewBookToLibrary(bk);

               ///////// changeBookRecordSystem(bi);////////////fix the number--done
                reNew();

            }
        }
        return bookRecordsLoaded;


    }

    // EFFECTS: update information in the library
    public void updateLibrarySystem(ArrayList<BookRecord> bookRecordsLoaded) {
        for (BookRecord br : bookRecordsLoaded) {
            changeBookRecordSystem(br);
        }
    }

    @Override
    public void load(String fileName) throws IOException {
    }


    private void reNew() {
        bookName = "";
        bookType = "";
        numberAvailable = "0";
    }

    public void changeBookRecordSystem(BookRecord biAdded) {

        bookRecordManager.changeBookRecordSystem(biAdded);
    }




    public void setLibrary(ArrayList<Book> library1) {
        this.library = library1;
    }


    public BookBorrowRecordRoom getBookBorrowRecordRoom() {
        return bookBorrowRecordRoom;
    }

    public void setBookRecordManager(BookRecordManager brm) {
        if (this.bookRecordManager != brm) {
            this.bookRecordManager = brm;
            brm.setLibraryManager(this);
        }
    }

    public BookRecordManager getBookRecordManager() {
        return bookRecordManager;
    }

}



//    public void changeBookRecordSystem(BookRecord biAdded) {
//
//        // if (bookRecords.size() == 0) {
//        //bookRecords.add(biAdded);
//        //} else {
//        BookRecord searchResult = findBookRecord(biAdded.getBook());
//        if (searchResult == null) {
//            bookRecords.add(biAdded);
//        } else {
//            //searchResult.setNumber(biAdded.getNumber());
//            searchResult.setNumberPlus(biAdded.getNumber());
//
//        }
//    }


//
//    public void setBookRecords(ArrayList<BookRecord> bookRecords1) {
//        this.bookRecords = bookRecords1;
//    }






//    public void borrowBookSystem() throws IOException {
//        Scanner myObj3 = new Scanner(System.in);
//        System.out.println("Enter the name of book you want to borrow");
//        String bookName = myObj3.nextLine();
//        System.out.println("Enter its bookType");
//        String bookType = myObj3.nextLine();
//        borrowBookSystemHelper(bookName,bookType);


//        if (canBookBeBorrowedOrNot(bookName, bookType)) {
//            System.out.println("Please enter your name");
//            String borrowerName = myObj3.nextLine();
//            System.out.println("Enter the number that you want to borrow" + "\n" + "Available number is shown above"
//                    + " ( " + " totally no more than 5 books per person" + " ) ");
//            int numberToBeBorrowed = myObj3.nextInt();
//
//
//            if (enoughBookToBeBorrowed(numberToBeBorrowed, bookName, bookType)) {
//                //if (numberToBeBorrowed > maxNumberOnce) {
//                //System.out.println("Excess maximum");
//                //}
//                Book bookToBeBorrowed = new Book(bookType, bookName, FALSE, null);
//                changeBookRecordSystemForBorrow(bookToBeBorrowed, numberToBeBorrowed, borrowerName);
//                System.out.println("All done! Remember to return your book within 30 days");
//            } else {
//                System.out.println("Enter the number that you want to borrow" + "Available number is shown above"
//                        + "(" + "5 books limited" + ")");
//                numberToBeBorrowed = myObj3.nextInt();
//            }
//        } else {
//            System.out.println("THIS BOOK IS NOT AVAILABLE");
//        }

    //save1();
//    }

//    public void borrowBookSystemHelper(String bookName, String bookType) {
//        Scanner myObj3 = new Scanner(System.in);
//        if (canBookBeBorrowedOrNot(bookName, bookType)) {
//            System.out.println("Please enter your name");
//            String borrowerName = myObj3.nextLine();
//            System.out.println("Enter the number that you want to borrow" + "\n" + "Available number is shown above"
//                    + " ( " + " totally no more than 5 books per person" + " ) ");
//            int numberToBeBorrowed = myObj3.nextInt();
//
//
//            if (enoughBookToBeBorrowed(numberToBeBorrowed, bookName, bookType)) {
//                Book bookToBeBorrowed = new Book(bookType, bookName, FALSE, null);
//                //changeBookRecordSystemForBorrow(bookToBeBorrowed, numberToBeBorrowed, borrowerName);
//                System.out.println("All done! Remember to return your book within 30 days");
//            } else {
//                System.out.println("Enter the number that you want to borrow" + "Available number is shown above"
//                        + "(" + "5 books limited" + ")");
//                //numberToBeBorrowed = myObj3.nextInt();
//            }
//        } else {
//            System.out.println("THIS BOOK IS NOT AVAILABLE");
//        }
//    }





//    public void changeBookRecordSystemForBorrow(Book bk, int num, String brn,String fileName) throws IOException {
//        BookRecord currentBookRecord = findBookRecord1(bk);
//        if (currentBookRecord != null) {
//            ArrayList<String> borrowerNameToBeRecorded = new ArrayList<>();
//            for (int i = num; i > 0; i = i - 1) {
//                borrowerNameToBeRecorded.add(brn);
//                //bk.getAllBorrowerNames().add(brn);
//
//            }
//
//            currentBookRecord.setNumber(-1 * num);
//            if (currentBookRecord.getBorrower() != null) {
//                //currentBookRecord.getBorrower().setAllBorrowerNamesForBorrowSystem(borrowerNameToBeRecorded);
//
//            }
//        }
//
//        save1(fileName);
//
//    }

//    public void changeBookBorrowRecordRoom(BookBorrowRecord newBorrowRecord, int num, String name, String fileName)
//            throws IOException {
//        String newBookName = newBorrowRecord.getBookName();
//        String newBookType = newBorrowRecord.getBookType();
//        ArrayList<BookBorrowRecord> recordList = bookBorrowRecordRoom.getBookBorrowRecords();
//
//        for (BookBorrowRecord bbr : recordList) {
//            if (newBookName.equals(bbr.getBookName()) && newBookType.equals(bbr.getBookType())) {
//                bbr.updateAllBorrowInfo(name, num);
//            }
//        }
//        try {
//            newBorrowRecord.getBorrowNumForCertainBorrower(name);
//        } catch (BorrowerNotExistException e) {
//            newBorrowRecord.updateAllBorrowInfo(name, num);
//            bookBorrowRecordRoom.getBookBorrowRecords().add(newBorrowRecord);
//        }

        //bookBorrowRecordRoom.save1("./data/borrowersListFile.txt");

   // }


    // EFFECTS: add new book to library, changing book title, type and bookRecord of it
//    public void addBookSystem() throws IOException {
//        Scanner myObj2 = new Scanner(System.in);
//        System.out.println("Enter bookName");
//        String bookName = myObj2.nextLine();
//
//        Book newBookAdded = new Book();
//        newBookAdded.setBookTitle(bookName);
//
//        //Scanner myObj3 = new Scanner(System.in);
//        System.out.println("Enter bookType");
//        String bookType = myObj2.nextLine();
//
//        newBookAdded.setBookType(bookType);
//
//        System.out.println("Enter Number Added");
//        int numberAdded = myObj2.nextInt();
//
//        BookRecord newBookRecord = new BookRecord(newBookAdded, null, numberAdded);
//        newBookAdded.setBookRecord(newBookRecord);
//        newBookAdded.setBookStatus();
//        addNewBookToLibrary(newBookAdded);
//
//        //changeBookSystem(newBookAdded);
//        //newBookAdded.setBookStatus(newBookRecord);
//        //newBookAdded.setBookStatus();
//
//        changeBookRecordSystemForAdd(newBookRecord);
//
//        System.out.println("Added successfully!");
//
//        save1();
//    }


//        if (getBook(bookName) == null) {
//            //newBookAdded = new Book(bookName, bookType, Boolean.TRUE);
//            addBook(newBookAdded);
//            System.out.println("Book is added successfully");
//            new Reservation().addBookRecord(bookName,newBookRecord);
//
//        } else {
//            new Reservation().addBookRecord(bookName,newBookRecord);
//
//        }
//    }


    // MODIFIES: reservations, bookRecord in reservations
    // EFFECTS: change bookRecord in Reservation in library
    // private void changeBookRecordSystem(BookRecord bi) {


    //}
    //}

    //this.reservation.addBookRecord(bi);
    //} else {
    // new Reservation().addBookRecord(bi);
    //}





    // EFFECTS: print out the book record if book wanted by user is found successfully
    //          otherwise, print out ""Sorry,NOT AVAILABLE"
//    public void searchSystem() throws IOException {
//        //makeLibraryBookList();
//        //load1();
//        Scanner myObj1 = new Scanner(System.in);
//        System.out.println("Enter bookName");
//        String bookName = myObj1.nextLine();
//        System.out.println("Enter bookType");
//        String bookType = myObj1.nextLine();
//
//        Book targetBook = getBook(bookName,bookType);
//
//        if (targetBook == null || !targetBook.getType().equals(bookType)) {
//            System.out.println("Sorry,NOT AVAILABLE");
//
//
//        } else {
//            BookRecord targetedBookRecord = targetBook.getBookRecord();
//            targetedBookRecord.showBookRecord();
//        }
//    }



    // EFFECTS: make a Reservation with 7 bookRecords
   /* private void makeReservationList() {
        reservation.addBookRecord(bi1);
        reservation.addBookRecord(bi2);
        reservation.addBookRecord(bi3);
        reservation.addBookRecord(bi4);
        reservation.addBookRecord(bi5);
        reservation.addBookRecord(bi6);
        reservation.addBookRecord(bi7);
    }

    */






//    @Override
//    public void save() throws IOException {
//        List<String> bookNameList = Files.readAllLines(Paths.get("inputFile.txt"));
//        ;
//        PrintWriter writer = new PrintWriter("outputFile.txt", "UTF-8");
//        bookNameList.add("Book to be Added");
//        for (Book book : library) {
//            System.out.print("Name: " + book.getTitle());
//            System.out.println("Type: " + book.getType());
//
//            writer.println(book.getTitle());
//            writer.println(book.getType());
//            writer.println(book.getBookRecord().getNumber());
//
//
//        }
//        writer.close();


    //}




//    public void sortBook(Book bookToBeSorted) throws NotAvailableBookTypeException {
////        if (bookToBeSorted.getType() != "Arts"
////                | bookToBeSorted.getType() != "Engineering"
////                | bookToBeSorted.getType() != "Geography"
////                | bookToBeSorted.getType() != "Science") {
////            throw new NotAvailableBookTypeException("");
////        }
//        if (bookToBeSorted.getType() == ("Arts")) {
//            ArtsBookShelf a1 = new ArtsBookShelf();
//            //a1.bookList.add(bookToBeSorted);
//        }
//
//        if (bookToBeSorted.getType() == ("Engineering")) {
//            //new EngineeringBookShelf().bookList.add(bookToBeSorted);
//        }
//
//        if (bookToBeSorted.getType() == "Geography") {
//            //new GeographyBookShelf().bookList.add(bookToBeSorted);
//        }
//
//        if (bookToBeSorted.getType() == ("Science")) {
//            //new ScienceBookShelf().bookList.add(bookToBeSorted);
//        }
//    }


//    // user interface to for book searching, adding and system quitting
//    public void run() throws IOException {
//        load1();
//        Scanner myObj = new Scanner(System.in);
//        System.out.println("SearchBook (input s) or AddBook (input a)
//        or BorrowBook(input b) or ReturnBook(input r) or "
//                + "Quit (input q)" + "\n" + "Announcement: search first if you want to borrow books");
//        String answer = myObj.nextLine();
//        //read();
//        while (!answer.equals("q")) {
//            switch (answer) {
//                case "s":
//                    searchSystem();
//                    break;
//
//                case "a":
//                    addBookSystem();
//                    break;
//
//                case "b":
//                    borrowBookSystem();
//                    break;
//
//                case "r":
//                    returnSystem();
//                    break;
//
//                default:
//                    System.out.println("Command is not supported.Please input s, a, b or q");
//            }
//            System.out.println("Search book(input s) or Add book(input a) or Borrow book(input b) or "
//                    + "Return book(input r) or Quit (input q)");
//            answer = myObj.nextLine();
//            //write();
//        }
//    }


//    public void returnSystem() throws IOException {
//        Scanner myObj4 = new Scanner(System.in);
//        System.out.println("Enter the name of book you want to return (enter only one name each time)");
//        String bookNameReturn = myObj4.nextLine();
//        System.out.println("Enter the type of the book");
//        String bookTypeReturn = myObj4.nextLine();
//        System.out.println("Enter the return number");
//        int numReturn;
//        while (true) {
//            try {
//                numReturn = Integer.parseInt(myObj4.nextLine());
//                break;
//            } catch (Exception e) {
//                System.out.println("Could not parse input, please try again");
//            }
//        }
//        //numReturn = myObj4.nextInt();
//        System.out.println("Enter your/the original borrower name");
//        String returnerName = myObj4.nextLine();
//        //System.out.println("How many did the person of this name return?");
//        //int num1 = myObj4.nextInt();
//        //System.out.println("Have more Borrower names to input?");
//        //BookRecord current = getBook(bookNameReturn,bookTypeReturn).getBookRecord();
////        try {
//        try {
//            changeBookRecordSystemForReturn(bookNameReturn, bookTypeReturn, numReturn, returnerName);
//        } catch (WrongPlaceToReturnException e) {
//            System.out.println("return books to the wrong library");
//        } finally {
//            System.out.println("Thanks for using our library system!");
//            //run();
//
//        }
//    }


//        } catch (WrongPlaceToReturnException e) {
//            //e.printStackTrace();
//        }



