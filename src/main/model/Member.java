package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

public class Member implements Observer {
    private String name;
    private int idLast4Digit;
    private boolean wantNotifications;
    //private int borrowNum;
    
    
    public Member(String name,int idLast4Digit) {
        this.name = name;
        this.idLast4Digit = idLast4Digit;
        wantNotifications = true;
    }
    
    public String getMemberName()  {
        return this.name;
    }

    public int getIdLast4Digit() {
        return this.idLast4Digit;
    }

    public boolean isWantNotifications() {
        return wantNotifications;
    }

    public void setWantNotifications(boolean choice) {
        this.wantNotifications = choice;
    }

    //EFFECTS: show updated result
    @Override
    public void update(Book newAdded) {
        System.out.println(name + ": " + "Great! " + newAdded.getBookRecord().getNumber() + " "
                + newAdded.getTitle() + " was/were newly added to the library!");
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof Member)) {
//            return false;
//        }
//        Member member = (Member) o;
//        return idLast4Digit == member.idLast4Digit
//                && name.equals(member.name);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Member member = (Member) o;
        return idLast4Digit == member.idLast4Digit
                && Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, idLast4Digit);
    }
}


