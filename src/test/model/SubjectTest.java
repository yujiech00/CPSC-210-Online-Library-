package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Library;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubjectTest {
    private Subject testSubject;
    private Observer o1;

    @BeforeEach
    void setUp() {
        testSubject = new Library("Toronto");
        o1 = new Member("Tom",1111);
        testSubject.addObserver(o1);
    }

    @Test
    void testAddObserver() {
        assertEquals(1,testSubject.getObservers().size());
    }

    @Test
    void testNotifyObservers() {
       testSubject.notifyObservers(new Book("Science","Earth",
               new BookRecord(null,3)));

    }
}
