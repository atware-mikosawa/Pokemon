package org.example;

public class Monster {
    private String name;
    private int hp;
    private int atk;
    private int lv;

    Monster() {
        this.name = "unknown";
        this.hp = 80;
        this.atk = 15;
        this.lv = 1;
    }

    Monster(String name) {
        this();
        this.name = name;
    }

    Monster(String name, int hp, int atk) {
        this(name);
        this.hp = hp;
        this.atk = atk;
    }

    Monster(String name, int hp, int atk, int lv) {
        this(name, hp, atk);
        this.lv = lv;
        if (lv > 1) {
            levelUp(lv);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public void levelUp(int risingLv) {
        this.hp = hp + (risingLv * 5);
        this.atk = atk + (risingLv * 3);
    }

    public int getlv() {
        return this.lv;
    }

    public String getStatsu() {
        return "[" + this.name + " lv" + this.lv + "　攻撃力" + this.atk + " HP" + this.hp + "/" + this.hp + "]";
    }
}
