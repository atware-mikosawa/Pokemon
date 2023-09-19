package main;

public class Move {
    protected String name;
    protected int damage;
    protected Attribute attribute;

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }
}
