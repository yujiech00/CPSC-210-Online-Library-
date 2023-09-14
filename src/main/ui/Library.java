package ui;

import exception.MembershipNotFoundException;
import exception.NoAccessRightException;
import exception.NoEnoughBookException;
import exception.WrongPlaceToReturnException;
import model.*;

import java.io.IOException;
import java.util.*;

//public class Library implements Loadable, Savable {
public class Library extends Subject {

    private LibraryManager libraryManager;
    private MemberManager memberManager;
    private String name;
    private Member current;

    public Library(String name) {
        Lottery lottery = new Lottery("New Member Lottery");
        this.name = name;
        libraryManager = LibraryManager.getInstance();
        memberManager = new MemberManager(lottery);
        memberManager.setLibrary(this);
        //libraryManager = new LibraryManager();
        libraryManager.setWorkplace(name);

    }

    //MODIFIES: this
    //EFFECTS: add observers and members
    public void addMember(Member m) {
        addObserver(m);
        memberManager.addNewMember(m);
    }

    // EFFECTS: initialize member list
    private void initializeMemberList() {
        addMember(new Member("Sunny", 1234));
        addMember(new Member("Shiny", 2536));
    }

    public void setMemberManager(MemberManager memberManager) {
        if (this.memberManager != memberManager) {
            this.memberManager = memberManager;
            memberManager.setLibrary(this);
            for (Member m: memberManager.getMembers()) {
                addObserver(m);
            }
        }
    }

    //private BookBorrowRecordRoom bookBorrowRecordRoom;


//    private ArrayList<Book> library;
//    private Reservation reservation;
//    private ArrayList<BookRecord> bookRecords;
//    private final int maxNumberOnce = 5;
//
//
//    private static final int empty = 0;
//    private Book b1 = new Book("Science", "Earth", TRUE, null);
//    private Book b2 = new Book("Science", "Mars", TRUE, null);
//    private Book b3 = new Book("Science", "Moon", FALSE, null);
//
//    private Book b4 = new Book("Arts", "Asian Study", TRUE, null);
//    private Book b5 = new Book("Arts", "Western Study", FALSE, null);
//    private Book b6 = new Book("Engineering", "BIOL", TRUE, null);
//
//    private Book b7 = new Book("Engineering", "CHEM", FALSE, null);
//
//
//    private Borrower p1 = null;
//    private int n1 = 1;
//    private BookRecord bi1 = new BookRecord(b1, p1, n1);
//
//
//    private Borrower p2 = null;
//    private int n2 = 2;
//    private BookRecord bi2 = new BookRecord(b2, p2, n2);
//
//    private Borrower p3 = new Borrower("Jane");
//    private BookRecord bi3 = new BookRecord(b3, p3, empty);
//
//
//    private Borrower p4 = null;
//    private int n4 = 3;
//    private BookRecord bi4 = new BookRecord(b4, p4, n4);
//
//    private Borrower p5 = new Borrower("Selena");
//    private BookRecord bi5 = new BookRecord(b5, p5, empty);
//
//    private Borrower p6 = null;
//    private int n6 = 5;
//    private BookRecord bi6 = new BookRecord(b6, p6, n6);
//
//    private Borrower p7 = new Borrower("Sherry");
//    private BookRecord bi7 = new BookRecord(b7, p7, empty);
//
//    String bookName = "";
//    String bookType = "";
//    String numberAvailable = "0";
//
//
//    // EFFECTS: construct a library with a list of Book
//    //          and Reservation (list of bookRecord)
//    public Library() {
//        library = new ArrayList<>();
//        reservation = new Reservation();
//        bookRecords = new ArrayList<>();
//        initializeLibrary();
//    }
//
//
//    public ArrayList<BookRecord> getBookRecords() {
//        return this.bookRecords;
//    }
//
//    public ArrayList<Book> getLibrary() {
//        return this.library;
//    }
//
//
//    // EFFECTS: return associated bookRecord if targetedBook is found in library,
//    //          otherwise, return null
//    public BookRecord accessToBookRecord(Book targetedBook) {
//        for (Book bk : library) {
//            if (targetedBook.equals(bk)) {
//                //Reservation r = new Reservation();
//                return bk.getBookRecord();
//            }
//        }
//        return null;
//    }


    // user interface to for book searching, adding and system quitting

    // EFFECTS: run library system
    public void run(String fileName, String fileNameForBorrow,String fileForMember) throws IOException {
        ///libraryManager = new LibraryManager();
        ////libraryManager.setWorkplace(name);
        initializeMemberList();
        System.out.println("------------ " + libraryManager.getWorkplace() + " Library -------------");

        libraryManager.updateLibrarySystem(libraryManager.load1(fileName));

        //libraryManager.load1(fileName);

        BookBorrowRecordRoom bookBorrowRecordRoom = libraryManager.getBookBorrowRecordRoom();
        bookBorrowRecordRoom.load(fileNameForBorrow);

        memberManager.load(fileForMember);

        Scanner myObj = new Scanner(System.in);
        System.out.println("SearchBook (input s) or AddBook (input a) or BorrowBook(input b) or ReturnBook(input r) or "
                + "Quit (input q)" + "\n" + "Announcement: search first if you want to borrow books");
        String answer = myObj.nextLine();
        //read();
        runHelper(answer, fileName, fileNameForBorrow,fileForMember);
    }

    //while (!answer.equals("q")) {


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
    //System.out.println("Search book (s) or Add book(a) or Borrow book(b) or " + "Return book(r) or Quit (q)");
    //answer = myObj.nextLine();
    //write();

    //EFFECTS: run library system
    private void runHelper(String answer, String fileName, String fileNameForBorrow,String fileForMember) throws
            IOException {
        while (!answer.equals("q")) {
            switchSystem(answer, fileName, fileNameForBorrow,fileForMember);
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
            System.out.println("Search book (s) or Add book(a) or Borrow book(b) or" + " Return book(r) or Quit (q)");
            Scanner myObj = new Scanner(System.in);
            answer = new Scanner(System.in).nextLine();
        }
    }

    //EFFECTS: choose specific library system
    private void switchSystem(String answer, String fileName, String fileNameForBorrow, String fileForMember) throws
            IOException {
        switch (answer) {
            case "s":
                searchSystem(fileName);
                break;

            case "a":
                addBookSystem(fileName);
                break;

            case "b":
                borrowBookSystem(fileName, fileNameForBorrow, fileForMember);
                break;

            case "r":
                returnSystem(fileName, fileNameForBorrow);
                break;

            default:
                System.out.println("Command is not supported.Please input s, a, b or q");
        }

    }


    // EFFECTS: run return system
    private void returnSystem(String fileN, String fileB) throws IOException {

        Scanner myObj4 = new Scanner(System.in);
        System.out.println("Enter the name of book you want to return (enter only one name each time)");
        String bookNameReturn = myObj4.nextLine();
        System.out.println("Enter the type of the book");
        String bookTypeReturn = myObj4.nextLine();
        System.out.println("Enter the return number");
        String num = myObj4.nextLine();
        //int numReturn = myObj4.nextInt();

        System.out.println("Enter your/the original borrower name");
        String returnerN = myObj4.nextLine();
        int numReturn = Integer.parseInt(num);

        try {
            libraryManager.changeBookRecordSystemForReturn(bookNameReturn, bookTypeReturn, numReturn, returnerN, fileB);
            /////libraryManager.save1(fileN);/////
            //////libraryManager.getBookBorrowRecordRoom().save1(fileB);/////
        } catch (WrongPlaceToReturnException e) {
            //System.out.println("Return books to the wrong library!!!");
        } finally {
            System.out.println("Thanks for using our library system!" + "\n" + "----------------------------------");

        }
        libraryManager.getBookBorrowRecordRoom().save1(fileB);
        libraryManager.save1(fileN);


    }

    //EFFECTS: run borrow system
    private void borrowBookSystem(String fileName, String fileNameForBorrow, String fileForM) throws IOException {
        try {
            memberVerification(fileForM);
            Scanner myObj3 = new Scanner(System.in);
            System.out.println("Enter the name of book you want to borrow");
            String bookName = myObj3.nextLine();
            System.out.println("Enter its bookType");
            String bookType = myObj3.nextLine();
            if (libraryManager.canBookBeBorrowedOrNot(bookName, bookType)) {
                borrowProcess(fileName,fileNameForBorrow,bookName,bookType);
//                System.out.println("Please enter your name");
//                String borrowerName = myObj3.nextLine();
//            System.out.println("Enter the number that you want to borrow" + "\n" + "Available number is shown above"
//                        + " ( " + "totally no more than 5 books per person" + " ) ");
//                int numberToBeBorrowed = myObj3.nextInt();
//                borrowBookSystemHelper(numberToBeBorrowed, borrowerName, bookName, bookType, fileName,
//                        fileNameForBorrow);
            }
        } catch (NoAccessRightException e) {
            System.out.println("Sorry, non-member has no right to access to Borrow System");
        } catch (MembershipNotFoundException e) {
            System.out.println("Your membership info is not found. You are not a member yet");
        } catch (NoEnoughBookException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: run borrow system
    private void borrowProcess(String fileName, String fileNameForBorrow,String bookName,String bookType) throws
            IOException, NoEnoughBookException {
        Scanner myObj3 = new Scanner(System.in);
        System.out.println("Please enter your name");
        String borrowerName = myObj3.nextLine();
        System.out.println("Enter the number that you want to borrow" + "\n" + "Available number is shown above"
                + " ( " + "totally no more than 5 books per person" + " ) ");
        int numberToBeBorrowed = myObj3.nextInt();
        borrowBookSystemHelper(numberToBeBorrowed, borrowerName, bookName, bookType, fileName,
                fileNameForBorrow);

    }

    public MemberManager getMemberManager() {
        return memberManager;
    }

    public LibraryManager getLibraryManager() {
        return libraryManager;
    }

    //        Scanner myObj3 = new Scanner(System.in);
//            System.out.println("Enter the name of book you want to borrow");
//            String bookName = myObj3.nextLine();
//            System.out.println("Enter its bookType");
//            String bookType = myObj3.nextLine();
//            if (libraryManager.canBookBeBorrowedOrNot(bookName, bookType)) {
//                System.out.println("Please enter your name");
//                String borrowerName = myObj3.nextLine();
//             System.out.println("Enter the number that you want to borrow" + "\n" + "Available number is shown above"
//                        + " ( " + "totally no more than 5 books per person" + " ) ");
//                int numberToBeBorrowed = myObj3.nextInt();
//
//            borrowBookSystemHelper(numberToBeBorrowed, borrowerName, bookName, bookType, fileName, fileNameForBorrow);


//            if (libraryManager.enoughBookToBeBorrowed(numberToBeBorrowed, bookName, bookType)) {
//                //if (numberToBeBorrowed > maxNumberOnce) {
//                //System.out.println("Excess maximum");
//                //}
//                Book bookToBeBorrowed = new Book(bookType, bookName, FALSE, null);
//                libraryManager.changeBookRecordSystemForBorrow(bookToBeBorrowed, numberToBeBorrowed, borrowerName);
//                System.out.println("All done! Remember to return your book within 30 days");
//            } else {
//                System.out.println("Enter the number that you want to borrow" + "Available number is shown above"
//                        + "(" + "5 books limited" + ")");
//                numberToBeBorrowed = myObj3.nextInt();
//            }
//        } else {
//            System.out.println("THIS BOOK IS NOT AVAILABLE");

            //bookBorrowRecordRoom = libraryManager.getBookBorrowRecordRoom();

            //////libraryManager.save1(fileName);/////////////////
            //////libraryManager.getBookBorrowRecordRoom().save1(fileNameForBorrow); //////////


    // EFFECTS: verify member,
    //          throw new NoAccessRightException if the user is not a member and does mot want to be
    public void memberVerification(String fileForMemberList) throws NoAccessRightException,
            MembershipNotFoundException, IOException {
        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Are you a member of our library? (Y or N)");
        String answer = myObj1.nextLine();
        if (answer.equals("N")) {
            System.out.println("Sorry, only members can borrow books." + "\n"
                    + "Do you want to be a member now? (Y or N)");
           // String answer1 = myObj1.nextLine();
            if (myObj1.nextLine().equals("Y")) {
                //Member newMember = createNewMembership();
                addMember(createNewMembership());
                memberManager.notify(current);
                memberManager.save1(fileForMemberList);

            } else {
                throw new NoAccessRightException();
            }
        } else {
            checkMemberInfo();

        }
    }

    //EFFECTS: check Member Info, throw new MembershipNotFoundException if the input is not found
    private void checkMemberInfo() throws MembershipNotFoundException {
        if (!memberManager.checkMembership(infoInput())) {
            throw new MembershipNotFoundException();
        }
    }

    //EFFECTS: create new membership
    private Member createNewMembership() {
        System.out.println("Great! Please go to the front desk to pay for the member fee later!");
        return infoInput();
    }

    //EFFECTS: collect input info and return it
    private Member infoInput() {
        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = myObj1.nextLine();
        System.out.println("Enter the last 4 digit of your id");
        int idLast4Digit = Integer.parseInt(myObj1.nextLine());
        //Member m = new Member(name,idLast4Digit);
        current = new Member(name,idLast4Digit);////
        System.out.println("Do you want to subscribe to new book notifications? Y or N");
        String choice = myObj1.nextLine();
        if (!choice.equals("Y")) {
            //m.setWantNotifications(false);
            current.setWantNotifications(false);
        }
        return current;
        //return new Member(name,idLast4Digit);
    }


    // EFFECTS: handle borrow system
    private void borrowBookSystemHelper(
            int numberToBeBorrowed, String borrowerName, String bookName, String bookType, String fileName,
            String fileNameForBorrow) throws IOException, NoEnoughBookException {
        if (libraryManager.enoughBookToBeBorrowed(numberToBeBorrowed, bookName, bookType)) {
            Book bookToBeBorrowed = new Book(bookType, bookName, null);
// //////           Book bookToBeBorrowed = new Book(bookType, bookName, FALSE, null);
            BookRecord found = libraryManager.findBookRecord(bookToBeBorrowed);
            found.setNumberMinus(numberToBeBorrowed);

            ////BookBorrowRecord newAdded = new BookBorrowRecord(bookName, bookType);
            ////libraryManager.changeBookBorrowRecordRoom(newAdded, numberToBeBorrowed, borrowerName, fileName);
            BookBorrowRecord newAdded = libraryManager.getBookBorrowRecordRoom().findOrCreateBookBorrowRecordWhenBorrow(
                    bookName,bookType);
            newAdded.updateAllBorrowInfoForBorrow(borrowerName,numberToBeBorrowed);

            System.out.println("All done! Remember to return your book within 30 days");
        } else {
            System.out.println("Enter the number that you want to borrow" + "Available number is shown above"
                    + "(" + "5 books limited" + ")");
            Scanner myObj3 = new Scanner(System.in);
            int numToBeBorrowed = myObj3.nextInt();
            borrowBookSystemHelper(numToBeBorrowed, borrowerName, bookName, bookType, fileName,fileNameForBorrow);
        }
        libraryManager.getBookBorrowRecordRoom().save1(fileNameForBorrow);
        libraryManager.save1(fileName);
    }




//
//
//
//
//
//

    //
//
//    private void changeBookRecordSystemForBorrow(Book bk,int num,String brn) throws IOException {
//        BookRecord currentBookRecord = findBookRecord1(bk);
//        if (currentBookRecord != null) {
//            ArrayList<String> borrowerNameToBeRecorded = new ArrayList<>();
//            for (int i = num; i > 0; i = i - 1) {
//                borrowerNameToBeRecorded.add(brn);
//            }
//            currentBookRecord.setNumber(-1 * num);
//            if (currentBookRecord.getBorrower() != null) {
//                currentBookRecord.getBorrower().setAllBorrowerNamesForBorrowSystem(borrowerNameToBeRecorded);
//            }
//        }
//        save1();
//    }
//
//
//
//
    // EFFECTS: handle addBook system
    private void addBookSystem(String fileName) throws IOException {
        Scanner myObj2 = new Scanner(System.in);
        System.out.println("Enter bookName");
        String bookName = myObj2.nextLine();

        Book newBookAdded = new Book();
        newBookAdded.setBookTitle(bookName);

        //Scanner myObj3 = new Scanner(System.in);
        System.out.println("Enter bookType");
        String bookType = myObj2.nextLine();

        newBookAdded.setBookType(bookType);

        System.out.println("Enter Number Added");
        int numberAdded = myObj2.nextInt();

        //////////////BookRecord newBookRecord = new BookRecord(newBookAdded, null, numberAdded);
        BookRecord newBookRecord = new BookRecord(newBookAdded,numberAdded);
        newBookAdded.setBookRecord(newBookRecord);
        newBookRecord.setAvailableStatus();
        //////////newBookAdded.setBookStatus();

        libraryManager.addNewBookToLibrary(newBookAdded);
        libraryManager.changeBookRecordSystemForAdd(newBookRecord);
        System.out.println("Added successfully!");
        notifyObservers(newBookAdded);
        libraryManager.save1(fileName);
    }


    //    // MODIFIES: library (if Book not found)
//    // EFFECTS: add new book to book list in library if it is not found in library book list
//    private void addNewBookToLibrary(Book bk) {
//        Book searchResult = getBook(bk.getTitle(),bk.getType());
//        if (searchResult == null) {
//            library.add(bk);
//        } else if (!searchResult.getType().equals(bk.getType())) {
//            library.add(bk);
//        }
//    }
//
//
//    // EFFECTS: print out the book record if book wanted by user is found successfully
//    //          otherwise, print out ""Sorry,NOT AVAILABLE"


    //EFFECTS: handle search book system
    private void searchSystem(String fileName) throws IOException {
        //makeLibraryBookList();
        //load1();
        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Enter bookName");
        String bookName = myObj1.nextLine();
        System.out.println("Enter bookType");
        String bookType = myObj1.nextLine();

//        Book targetBook = libraryManager.getBook(bookName, bookType);
        Book search = new Book(bookType,bookName,null);
        BookRecord targetBookRecord = libraryManager.findBookRecord(search);

        if (targetBookRecord == null) {
            System.out.println("Sorry,book is not available!");
        } else {
            targetBookRecord.showBookRecord();
        }
    }


//
//        if (targetBook == null || !targetBook.getType().equals(bookType)) {
//            System.out.println("Sorry,book is not available!");
//        } else {
//            BookRecord targetedBookRecord = targetBook.getBookRecord();
//            targetedBookRecord.showBookRecord();
//        }
//    }

}


//            BookRecord targetedBookRecord = targetBook.getBookRecord();
//            targetedBookRecord.showBookRecord();





//
//    // MODIFIES: (Book b1 to b7).BookRecord
//    // EFFECTS: set BookRecord to Book (b1 to b7)
//    //          make a Library with 7 Books and a Reservation with 7 bookRecords
//    private void initializeLibrary() {
//        b1.setBookRecord(bi1);
//        b2.setBookRecord(bi2);
//        b3.setBookRecord(bi3);
//        b4.setBookRecord(bi4);
//        b5.setBookRecord(bi5);
//        b6.setBookRecord(bi6);
//        b7.setBookRecord(bi7);
//        makeLibraryBookList();
//        //makeReservationList();
//        makeBookRecordsList();
//
//    }
//
//
//    // EFFECTS: make a Library with 7 Books
//    private void makeLibraryBookList() {
//        library.add(b1);
//        library.add(b2);
//        library.add(b3);
//        library.add(b4);
//        library.add(b5);
//        library.add(b6);
//        library.add(b7);
//
//    }
//
//    // EFFECTS: make a Reservation with 7 bookRecords
//   /* private void makeReservationList() {
//        reservation.addBookRecord(bi1);
//        reservation.addBookRecord(bi2);
//        reservation.addBookRecord(bi3);
//        reservation.addBookRecord(bi4);
//        reservation.addBookRecord(bi5);
//        reservation.addBookRecord(bi6);
//        reservation.addBookRecord(bi7);
//    }
//
//    */
//
//    private void makeBookRecordsList() {
//        bookRecords.add(bi1);
//        bookRecords.add(bi2);
//        bookRecords.add(bi3);
//        bookRecords.add(bi4);
//        bookRecords.add(bi5);
//        bookRecords.add(bi6);
//        bookRecords.add(bi7);
//    }
//
//
//    // EFFECTS: return Book with bookName wanted if its name is found in library;
//    //          otherwise, return null
//    private Book getBook(String bookName,String bookType) {
//        if (library.size() != 0) {
//            for (Book bk : library) {
//                if (bookName.equals(bk.getTitle()) && bookType.equals(bk.getType())) {
//                    return bk;
//                }
//
//            }
//            return null;
//        } else {
//            return null;
//        }
//    }
//
//    private boolean canBookBeBorrowedOrNot(String bookName,String bookType) {
//        Book targetedBook = new Book(bookType, bookName, FALSE, null);
//        BookRecord result = findBookRecord1(targetedBook);
////        if (bookRecords.size() != 0) {
////            for (BookRecord bi : bookRecords) {
////                if (bi.getBook().getType() == bookType && bi.getBook().getTitle() == bookName) {
//        if (result.getNumber() == 0) {
//            System.out.println("Please wait for others to return");
//            return false;
//        } else {
//            System.out.println("Available Number: " + result.getNumber());
//            return true;
//        }
//    }
//
//
//
//
//
//
//    private void changeBookRecordSystemForAdd(BookRecord biAdded) {
//
//        // if (bookRecords.size() == 0) {
//        //bookRecords.add(biAdded);
//        //} else {
//        BookRecord searchResult = findBookRecord1(biAdded.getBook());
//        if (searchResult == null) {
//            bookRecords.add(biAdded);
//        } else {
//            searchResult.setNumber(biAdded.getNumber());
//        }
//    }
//
//
////    @Override
////    public void save() throws IOException {
////        List<String> bookNameList = Files.readAllLines(Paths.get("inputFile.txt"));
////        ;
////        PrintWriter writer = new PrintWriter("outputFile.txt", "UTF-8");
////        bookNameList.add("Book to be Added");
////        for (Book book : library) {
////            System.out.print("Name: " + book.getTitle());
////            System.out.println("Type: " + book.getType());
////
////            writer.println(book.getTitle());
////            writer.println(book.getType());
////            writer.println(book.getBookRecord().getNumber());
////
////
////        }
////        writer.close();
//
//
//    //}
//
//    @Override
//    public void save1() throws IOException {
//        BookRecord thingToSaved;
//        PrintWriter writer = new PrintWriter("./data/outputFile.txt", "UTF-8");
//        for (Book bk : library) {
//            writer.println(bk.getTitle());
//            //System.out.println(bk.getTitle());
//            writer.println(bk.getType());
//            //System.out.println(bk.getType());
//            writer.println(bk.getBookRecord().getNumber());
//            // System.out.println(bk.getBookRecord().getNumber());
//
//        }
//        writer.close();
//
//
//    }
//
//    public BookRecord findBookRecord1(Book bk) {
//        //ArrayList<BookRecord> bookRecordsLibraryList = getBookRecords();
//        if (bookRecords.size() != 0) {
//            for (BookRecord bi : bookRecords) {
//                if (bk.getTitle().equals(bi.getBook().getTitle())
//                        && bk.getType().equals(bi.getBook().getType())) {
//                    return bi;
//                }
//            }
//            return null;
//        } else {
//            return null;
//        }
//    }
//
//
//    @Override
//    public void load1() throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("./data/outputFile.txt"));
//        // for (String line: lines) {
//        //     System.out.println(line);
//        //  }
//        //String bookName = "";
//        //String bookType = "";
//        //String numberAvailable = "0";
//        //int bookNum;
//        for (String line : lines) {
//            if (line.equals("")) {
//                Book bk = new Book(bookType, bookName, FALSE, null);
//                //library.add(book);
//                //bookName = "";
//                //bookType = "";
//                //numberAvailable = "";
//            }
//
//            if (bookName.equals("")) {
//                bookName = line;
//                //bk.setBookTitle(line);
//            } else if (bookType.equals("")) {
//                bookType = line;
//                //bk.setBookType(line);
//            } else if (numberAvailable.equals("0")) {
//                //numberAvailable = line;
//                //int bookNum = Integer.parseInt(numberAvailable);
//                //bi.setNumber(Integer.parseInt(numberAvailable));
//                //bk.setBookRecord(bi);
//                Book bk = new Book(bookType, bookName, TRUE, null);
//                BookRecord bi = new BookRecord(bk, null, Integer.parseInt(line));
//                bk.setBookRecord(bi);
//
//                //sortBook(bk);
//
//                //library.add(book);
//                //bookRecords.add(bi);
//                addNewBookToLibrary(bk);
//                changeBookRecordSystem2(bi);
//                reNew();
//
//            }
//        }
//    }
//
//
//    private void reNew() {
//        bookName = "";
//        bookType = "";
//        numberAvailable = "0";
//    }
//
//
////            Book book = new Book(bookType, bookName, TRUE, null);
////            BookRecord bi = new BookRecord(book, null, bookNum);
////            book.setBookRecord(bi);
////            library.add(book);
////            bookRecords.add(bi);
////        }
//
//
//    private void changeBookRecordSystem2(BookRecord biAdded) {
//
//        // if (bookRecords.size() == 0) {
//        //bookRecords.add(biAdded);
//        //} else {
//        BookRecord searchResult = findBookRecord1(biAdded.getBook());
//        if (searchResult == null) {
//            bookRecords.add(biAdded);
//        } else {
//            //searchResult.setNumber(biAdded.getNumber());
//            searchResult.setNumber2(biAdded.getNumber());
//
//        }
//    }
//
//    public void setLibrary(ArrayList<Book> library1) {
//        this.library = library1;
//    }
//
//
////    public void sortBook(Book bookToBeSorted) throws NotAvailableBookTypeException {
//////        if (bookToBeSorted.getType() != "Arts"
//////                | bookToBeSorted.getType() != "Engineering"
//////                | bookToBeSorted.getType() != "Geography"
//////                | bookToBeSorted.getType() != "Science") {
//////            throw new NotAvailableBookTypeException("");
//////        }
////        if (bookToBeSorted.getType() == ("Arts")) {
////            ArtsBookShelf a1 = new ArtsBookShelf();
////            //a1.bookList.add(bookToBeSorted);
////        }
////
////        if (bookToBeSorted.getType() == ("Engineering")) {
////            //new EngineeringBookShelf().bookList.add(bookToBeSorted);
////        }
////
////        if (bookToBeSorted.getType() == "Geography") {
////            //new GeographyBookShelf().bookList.add(bookToBeSorted);
////        }
////
////        if (bookToBeSorted.getType() == ("Science")) {
////            //new ScienceBookShelf().bookList.add(bookToBeSorted);
////        }
////    }
//

//    private int checkInputType(String input) {
//        while (true) {
//            try {
//                int numReturn = Integer.parseInt(input);
//                return numReturn;
//
//            } catch (Exception e) {
//                //System.out.println("Could not parse input, please try again");
//            }
//        }
//    }









































