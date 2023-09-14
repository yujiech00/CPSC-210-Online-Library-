package model;

public abstract class Prize {
    protected String name;

    public Prize(String name) {
        this.name = name;
    }

    protected abstract void description();
}
