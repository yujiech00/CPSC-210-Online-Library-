package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Lottery extends Prize implements Observer {
    private ArrayList<Prize> prizes;


    public Lottery(String name) {
        super(name);
        prizes = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: add child
    public void addPrize(Prize p) {
        if (!prizes.contains(p)) {
            prizes.add(p);
        }
    }

    // EFFECTS: show description
    @Override
    public void description() {
        System.out.println(name);
        for (Prize p : prizes) {
            p.description();
        }
    }


    //EFFECTS: print out updated result
    @Override
    public void update(Observable observable, Object o) {
        Member member = (Member) o;
        System.out.println("Welcome " + member.getMemberName()
                + " to be our member! You get a chance of lottery to win a prize!");
    }
}
