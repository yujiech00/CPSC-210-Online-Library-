package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MemberManagerTest {
    private MemberManager testMemberManager;
    private Member member1;
    private Member member2;
    private Set<Member> members;
    private Lottery lottery = new Lottery("New Member Lottery");

    @BeforeEach
    void setUp() {
        testMemberManager = new MemberManager(lottery);
        member1 = new Member("Tom",1235);
        member2 = new Member("Selena",1111);
        members = new HashSet<>();
        Library library = new Library("Toronto");
        testMemberManager.setLibrary(library);
        //testMember4 = new Member("Tom",1245);

    }

    @Test
    void testAddNewMember() {
        members.add(member1);
        assertEquals(1,members.size());
    }

    @Test
    void testCheckMembership() {
        assertFalse(testMemberManager.checkMembership(member1));
        testMemberManager.addNewMember(member1);
        assertEquals(1,testMemberManager.getMembers().size());
        assertTrue(testMemberManager.checkMembership(member1));
    }

    @Test
    void testLoad1() throws IOException {
        assertNull(testMemberManager.load1("./data/testMemberListFile.txt"));
    }

    @Test
    void testSave1() throws IOException {
        MemberManager anotherMemberManager = new MemberManager(lottery);
        Library library1 = new Library("Vancouver");
        anotherMemberManager.setLibrary(library1);
        testMemberManager.addNewMember(member1);
        testMemberManager.save1("./data/testMemberListFile.txt");
        anotherMemberManager.load("./data/testMemberListFile.txt");
        assertEquals(testMemberManager.getMembers().size(),anotherMemberManager.getMembers().size());
    }

    @Test
    void testLoad() throws IOException {
        MemberManager anotherMemberManager = new MemberManager(lottery);
        anotherMemberManager.addNewMember(member2);
        anotherMemberManager.save1("./data/testMemberListFile.txt");
        testMemberManager.load("./data/testMemberListFile.txt");
        assertEquals(anotherMemberManager.getMembers().size(),testMemberManager.getMembers().size());
    }

    @Test
    void testSetLibrary() {
        Library l = new Library("Montreal");
        l.addMember(member1);
        l.addMember(member2);
        testMemberManager.setLibrary(l);
        assertEquals(2,testMemberManager.getLibrary().getObservers().size());
    }

    @Test
    void testNotify() {
        testMemberManager.notify(member1);
    }














}
