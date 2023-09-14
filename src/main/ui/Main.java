package ui;


import model.*;



import java.io.IOException;
import java.util.*;

public class Main {
    public static List<Book> books;
    public static Book currentBook;
    private static final int empty = 0;



//    private void read() {
//        try {
//            List<String> lines = Files.readAllLines(Paths.get("inputFile.txt"));
//            String bookName = "";
//            String bookType = "";
//            List<String> borrowerNames = new ArrayList<>();
//            List<Book> bookList = new ArrayList<>();
//            List<BookRecord> bookRecordList = new ArrayList<>();
//            for (String line : lines) {
//                if (line.equals("")) {
//                    Book book = new Book(bookType, bookName, TRUE, null);
//                    BookRecord bookRecord = new BookRecord(book, null, 0);
//                    book.setBookRecord(bookRecord);
//                    book.setBookStatus();
//                    bookList.add(book);
//                    bookRecordList.add(bookRecord);
//                }
//
//                if (bookName.equals("")) {
//                    bookName = line;
//                } else if (bookType.equals("")) {
//                    bookType = line;
//                } else {
//                    borrowerNames.add(line);
//                }
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void write() {
//        try {
//            PrintWriter writer = new PrintWriter("outputFile.txt", "UTF-8");
//            for (Book bk : bookList) {
//                writer.println(book.getTitle());
//                writer.println(book.getType());
//
//
//                for (BookRecord br : bookRecordList) {
//                    writer.println(br.getNumber());
//                }
//                writer.println();
//            }
//
//
//            writer.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
//
//
//    public static void read() {
//        try {
//            List<String> lines = Files.readAllLines(Paths.get("inputFile.txt"));
//            String bookName = "";
//            String bookType = "";
//            String numberAdded = Integer.toString(0);
//            //int numberAdded1 = 0;
//            //List<Integer> availableNo = new ArrayList<>();
//            // Number = 0;
//            List<BookRecord> reservations = new ArrayList<>();
//            for (String line : lines) {
//                if (line.equals("")) {
//                    Book book = new Book(bookType, bookName, TRUE, null);
//                    //BookRecord bookRecord = new BookRecord(book, null, Number);
//                    books.add(book);
//                    bookName = "";
//                    bookType = "";
//                    book.getStatus();
//                    reservations = new ArrayList<>();
//                }
//                if (bookName.equals("")) {
//                    bookName = line;
//                } else if (bookType.equals("")) {
//                    bookType = line;
//                } else if (numberAdded.equals(Integer.toString(0))) {
//                    numberAdded = line;
//                } else {
//                    lines.add(line);
//                }
//
//            }
//
//            Book book = new Book(bookType, bookName, TRUE, null);
//            //BookRecord bookRecord = new BookRecord(book,null,(int)numberAdded);
//            //book.setBookRecord().
//            books.add(book);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void write() {
//        try {
//            PrintWriter writer = new PrintWriter("Output.txt", "UTF-8");
//            for (Book book : books) {
//                writer.println(book.getTitle());
//                writer.println(book.getType());
//                writer.println(book.getStatus2());
//
//
//                // writer.println();
//                //writer.println(); status
//                //for (Integer availableNo : ) {
//                //writer.println();
//            }
//
//            writer.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//



    public static void main(String[] args) throws IOException {
        System.out.println("Register to be a member today! We hold the following lottery activity: ");
        Lottery lottery = new Lottery("2019 New Member Welcome Lottery");
        Lottery l1 = new Lottery("Try Again");
        Lottery l2 = new Lottery("Thanks for participation");
        GiftCard g1 = new GiftCard("Type1 GiftCard",50);
        GiftCard g2 = new GiftCard("Type2 GiftCard",100);
        GiftCard g3 = new GiftCard("Type3 GiftCard",150);
        GiftCard g4 = new GiftCard("Type4 GiftCard",200);
        lottery.addPrize(l1);
        lottery.addPrize(g1);
        lottery.addPrize(g2);
        lottery.addPrize(g3);
        l1.addPrize(l2);
        lottery.addPrize(g4);
        lottery.description();

        new Library("Vancouver").run("./data/outputFile.txt",
                "./data/borrowersListFile.txt","./data/memberListFile.txt");




    }
}
        //r.addBookInfo(bi1);
        //r.addBookInfo(bi2);
        //r.addBookInfo(bi3);
        //r.addBookInfo(bi4);
        //r.addBookInfo(bi5);
        //r.addBookInfo(bi6);

        //Book b1 = new Book("Science", "Earth", TRUE);
        //Reservation library = bookInLibrary.addBook(b1);


        //Scanner myObj = new Scanner(System.in);
        //System.out.println("Search book(input search) or Add book(input add) or Quit (input quit)");
        //String answer = myObj.nextLine();

        //while (!answer.equals("quit")) {
            //switch (answer) {
                //case "search":
                    //new Main().searchSystem();
                   // break;


                //Scanner myObj1 = new Scanner(System.in);
                //System.out.println("Enter bookName");
                //String bookName = myObj.nextLine();
                //if (r1.getBook(myObj.nextLine()) == null) {
                //System.out.println("NOT AVAILABLE");
                //} else System.out.println(
                //r1.getBook(myObj.nextLine()).book.getStatus());
                //System.out.println("BookName is: " + bookName);


               // case "add":
                   // new Main().addBookSystem();
                    //break;
                //default:
                    //System.out.println("Command is not supported.Please input search, add or quit");
            //}
           // System.out.println("Search book(input search) or Add book(input add) or Quit (input quit)");
           // answer = myObj.nextLine();
        //}
    //}





    //Scanner myObj2 = new Scanner(System.in);
    //System.out.println("Enter bookName");
    // String bookName = myObj.nextLine();
    //Book newBookAdded = new Book("", bookName, TRUE);
    // Scanner myObj3 = new Scanner(System.in);
    //System.out.println("Enter bookType");
    //String bookType = myObj.nextLine();
    //Book newBookAdded = new Book(myObj.nextLine(), bookName, TRUE);


    //private static void makeLibraryBookLists() {
        //Reservation.makeLibraryBookList(bi1);
       // r.addBookInfo(bi1);
        //r.addBookInfo(bi2);
       // r.addBookInfo(bi3);
       // r.addBookInfo(bi4);
        //r.addBookInfo(bi5);
        //r.addBookInfo(bi6);
        //r.addBookInfo(bi7);

    //}

//    private void addBookSystem() {
//        Scanner myObj2 = new Scanner(System.in);
//        System.out.println("Enter bookName");
//        String bookName = myObj2.nextLine();
//
//        Book newBookAdded = new Book();
//        newBookAdded.setBookTitle(bookName);
//
//        //Scanner myObj3 = new Scanner(System.in);
//        System.out.println("Enter bookType");
//        //String bookType = myObj2.nextLine();
//
//        newBookAdded.setBookType(myObj2.nextLine());
//        //newBookAdded.setBookStatus(TRUE);
//
//        System.out.println("Enter Number Added");
//        //int numberAdded = myObj2.nextInt();
//
//
//        if (r.getBookRecord(bookName) == null) {
//            BookRecord newBookRecordAdded = new BookRecord(
//                    newBookAdded, new Borrower(""), myObj2.nextInt());
//            r.addBookRecord(newBookRecordAdded);
//            newBookAdded.setBookStatus(newBookRecordAdded);
//
//        } else {
//            r.getBookRecord(bookName).setNumber(myObj2.nextInt());
//            newBookAdded.setBookStatus(r.getBookRecord(bookName));
//
//
//        }
//
//        System.out.println("Book is added successfully");
//    }
//
//
//
//    private void notAvailableNotification() {
//        System.out.println("Sorry,not available");
//        //return "NOT AVAILABLE";
//    }
//
//    private void searchSystem() {
//        Scanner myObj1 = new Scanner(System.in);
//        System.out.println("Enter bookName");
//        String bookName = myObj1.nextLine();
//
//        if (r.getBookRecord(bookName) == null) {
//            System.out.println("Sorry,NOT AVAILABLE");
//            //notAvailableNotification();
//
//        } else {
//            BookRecord.showBookInformation(r.getBookRecord(bookName));
//        }
//    }
//}











        //Scanner myObj = new Scanner(System.in);
        //System.out.println("Enter bookName");

        //String bookName = myObj.nextLine();
        //System.out.println("BookName is: " + bookName);


    // System.out.println("Announcement:");
    // System.out.println(b1.getType());
    // System.out.println(b1.getTitle());
    // System.out.println(p1.getBorrowerName());




    //public void getType(Book b) {
        //System.out.println("BookType:" + b.getType());

   // }

    //public void getTitle(Book b) {
       // System.out.println("Title:" + b.getTitle());

    //}

    //public void getStatus(Book b) {
        //System.out.println("Status: " + b.getStatus());
    //}


    // public void getBorrowerName(Borrower p) {
        //System.out.println("Borrower:" + p.getBorrowerName());

    //}


    //public void getDDL() {
        //System.out.println("Return deadline:");
    //}



