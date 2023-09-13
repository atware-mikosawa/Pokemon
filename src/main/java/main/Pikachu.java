package main;


public class Pikachu extends Monster {
    Pikachu() {
        super(30, 30, 4, 3, Attribute.ELECTRICITY, 1);
        this.name = "ピカチュウ";
    }

    Pikachu(String name) {
        super(30, 30, 4, 3, Attribute.ELECTRICITY, 1);
        this.name = name;
    }

    Pikachu(int level) {
        super(30, 30, 4, 3, Attribute.ELECTRICITY, 1);
        this.name = "ピカチュウ";
        this.level = level;
        if (1 < level) {
            levelUp(level);
        }
    }

    @Override
    public void levelUp(int level) {
        this.attackPoint = (this.attackPoint + level * 3);
        this.spd = (this.spd + level * 2);
        this.hp = (this.hp + level * 3);
        this.hpMax = (this.hpMax + level * 3);
        this.level = ((this.level + level) - 1);
    }

}

