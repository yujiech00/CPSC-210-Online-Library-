package model;

import ui.Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Observer;

public class MemberManager extends Observable implements Loadable, Savable  {
    private Library library;
    private Set<Member> members;
    private String currentName = "";
    private String currentID = "0";
    //private String currentChoice = "";


    public MemberManager(Observer o) {
        members = new HashSet<>();
        addObserver(o);
    }


    public void addNewMember(Member m) {
        members.add(m);
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setLibrary(Library library) {
        if (this.library != library) {
            this.library = library;
            library.setMemberManager(this);
        }
    }

    public Library getLibrary() {
        return library;
    }



    // return true if the he is really a member; otherwise return false
    public boolean checkMembership(Member m) {
        //return library.getObservers().contains(m);
        return members.contains(m);
    }



    // EFFECTS: always return null
    @Override
    public ArrayList<BookRecord> load1(String fileName) throws IOException {
        return null;
    }

    // EFFECTS: load member list to system
    @Override
    public void load(String fileNameForMemberList) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileNameForMemberList));
        Set<Member> memberSet = new HashSet<>();
        for (String line : lines) {
            if (line.equals("---------------------------")) {
                reset();
            } else if (currentName.equals("")) {
                currentName = line;
            } else if (currentID.equals("0")) {
                currentID = line;
                //int id = Integer.parseInt(currentID);
            } else {
                //currentChoice = line;
                boolean choice = Boolean.parseBoolean(line);
                int id = Integer.parseInt(currentID);
                Member newMember = new Member(currentName, id);
                newMember.setWantNotifications(choice);
                memberSet.add(newMember);

            }
        }

        updateMembers(memberSet);
    }

//    private Member memberSetUp() {
//        boolean choice = Boolean.parseBoolean(currentChoice);
//        int id = Integer.parseInt(currentID);
//        Member newMember = new Member(currentName, id);
//        newMember.setWantNotifications(choice);
//        return newMember;
//    }


    private void reset() {
        currentName = "";
        currentID = "0";
        //currentChoice = "";
    }

    // MODIFIES: this
    // EFFECTS: update members in the library
    private void updateMembers(Set<Member> memberSet) {
        for (Member m : memberSet) {
            library.addMember(m);
            //library.getObservers().add(m);
        }

    }

    // EFFECTS: save member info to file
    @Override
    public void save1(String fileNameForMemberList) throws IOException {
        PrintWriter writer = new PrintWriter(fileNameForMemberList, "UTF-8");
        for (Member m : members) {
            writer.println(m.getMemberName());
            writer.println(m.getIdLast4Digit());/////
            writer.println(m.isWantNotifications());
            writer.println("---------------------------");
        }

        writer.close();

    }

    // EFFECTS: notify observers
    public void notify(Member current) {
        setChanged();
        notifyObservers(current);
    }

//    public Member findMember(Member target) {
//        for (Member m: members) {
//            if (m.equals(target)) {
//                return m;
//            }
//        }
//        return null;
//    }
}



