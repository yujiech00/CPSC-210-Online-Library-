package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    private Lottery lottery;
    private Lottery l1;
    private Lottery l2;
    private GiftCard g1;
    private GiftCard g2;
    private GiftCard g3;
    private GiftCard g4;


    @BeforeEach
    void setUp() {
        lottery = new Lottery("2019 New Member Welcome Lottery");
        l1 = new Lottery("Try Again");
        l2 = new Lottery("Thanks for participation");
        g1 = new GiftCard("Type1 GiftCard", 50);
        g2 = new GiftCard("Type2 GiftCard", 100);
        g3 = new GiftCard("Type3 GiftCard", 150);
        g4 = new GiftCard("Type4 GiftCard", 200);
    }

    @Test
    void testDescription() {
        lottery.addPrize(l1);
        lottery.addPrize(g1);
        lottery.addPrize(g2);
        lottery.addPrize(g3);
        l1.addPrize(l2);
        lottery.addPrize(g4);
        lottery.description();
        lottery.update(new MemberManager(lottery),new Member("Tom",1211));

    }
}

