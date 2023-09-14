package model;

public class GiftCard extends Prize {

    private int balance;

    public GiftCard(String name,int balance) {
        super(name);
        this.balance = balance;
    }

    // EFFECTS: show description of this gift card
    @Override
    protected void description() {
        System.out.println(name + ": " + balance);
    }
}
