package org.example;

public class Hitokage extends Monster {
    Hitokage() {
        super();
        setName("ヒトカゲ");
        setHp(70);
        setAtk(18);
    }

    Hitokage(int lv) {
        this();
        setLv(lv);
        if (lv > 1) {
            levelUp(lv);
        }
    }

    @Override
    public void levelUp(int risingLv) {
        super.levelUp(risingLv);
        setHp(getHp() + (risingLv * 4));
        setAtk(getAtk() + (risingLv * 6));
    }
}
