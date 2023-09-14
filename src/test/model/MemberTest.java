package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for Borrower
public class MemberTest {
    private Member testMember1;
    private Member testMember2;
    private Member testMember3;
    private Member testMember4;
    private String name;


@BeforeEach
   void setUp(){
    testMember1 = new Member("Tom",1235);
    testMember2 = new Member("Tom",1235);
    testMember3 = new Member("Tommy",1235);
    testMember4 = new Member("Tom",1245);



}

@Test
    void testGetMemberName() {
    assertEquals("Tom", testMember1.getMemberName());
}

@Test
   void testGetLast4ID() {
    assertEquals(1235,testMember3.getIdLast4Digit());
}




@Test
    void testEquals() {
    assertTrue(testMember1.equals(testMember1));
    name = "";
    assertFalse(testMember1.equals(name));
    assertFalse(testMember1.equals(testMember3));
    assertFalse(testMember1.equals(testMember4));
    assertTrue(testMember1.equals(testMember2));
    assertEquals(testMember1.hashCode(),testMember2.hashCode());
    Book b = new Book("","",null);
    BookRecord br = new BookRecord(null,2);
    b.setBookRecord(br);
    testMember1.update(b);

}


}
