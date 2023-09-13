package main;


public class Eevee extends Monster {
    Eevee() {
        super(40, 40, 4, 4, Attribute.NORMAL, 1);
        this.name = "イーブイ";
    }

    Eevee(String name) {
        super(40, 40, 4, 4, Attribute.NORMAL, 1);
        this.name = name;
    }

    Eevee(int level) {
        super(40, 40, 4, 4, Attribute.NORMAL, 1);
        this.name = "イーブイ";
        this.level = level;
        if (1 < level) {
            levelUp(level);
        }
    }

    @Override
    public void levelUp(int level) {
        this.attackPoint = (this.attackPoint + level * 2);
        this.spd = (this.spd + level * 3);
        this.hp = (this.hp + level * 4);
        this.hpMax = (this.hpMax + level * 4);
        this.level = ((this.level + level) - 1);
    }


}
