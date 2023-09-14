package model;

import java.util.ArrayList;
import java.util.Observable;

public abstract class Subject extends Observable {
    private ArrayList<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }


    public ArrayList<Observer> getObservers() {
        return observers;
    }

    //EFFECTS: only notify observers that want notifications
    public void notifyObservers(Book newAdded) {
        int counter = 0;
        for (Observer o : observers) {
            Member m = (Member) o;
            if (m.isWantNotifications()) {
                o.update(newAdded);
                counter++;
            }
        }
        System.out.println(counter + " members have received notifications about new books added!");
    }




}
