package model;

public class NamePlusBorrowNumber {
    private String name;
    private int borrowNum;


    public NamePlusBorrowNumber(String name,int borrowNum) {
        this.name = name;
        this.borrowNum = borrowNum;
    }


    public String getName() {
        return this.name;
    }

    public int getBorrowNum() {
        return this.borrowNum;
    }

    // MODIFIES: this
    // EFFECTS: change the number recorded when borrowing
    public void setBorrowNum(int num) {
        this.borrowNum = this.borrowNum + num;
    }

}
