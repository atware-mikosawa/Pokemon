package org.example;

public class Fushigidane extends Monster {
    Fushigidane() {
        super();
        setName("フシギダネ");
        setHp(90);
        setAtk(14);
    }

    Fushigidane(int lv) {
        this();
        setLv(lv);
        if (lv > 1) {
            levelUp(lv);
        }
    }

    @Override
    public void levelUp(int risingLv) {
        setHp(getHp() + (risingLv * 6));
        setAtk(getAtk() + (risingLv * 4));
    }
}
