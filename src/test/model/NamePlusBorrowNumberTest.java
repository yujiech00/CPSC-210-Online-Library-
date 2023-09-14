package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NamePlusBorrowNumberTest {
    private NamePlusBorrowNumber testNamePlusBorrowNumber;



    @BeforeEach
    void setUp() {
        testNamePlusBorrowNumber = new NamePlusBorrowNumber("Tina",2);

    }

    @Test
    void testGetName() {
        assertEquals(testNamePlusBorrowNumber.getName(),"Tina");
    }

    @Test
    void testGetBorrowNum() {
        assertEquals(2, testNamePlusBorrowNumber.getBorrowNum());

    }

    @Test
    void testDetBorrowNum() {
        testNamePlusBorrowNumber.setBorrowNum(2);
        assertEquals(4, testNamePlusBorrowNumber.getBorrowNum());
    }
}
