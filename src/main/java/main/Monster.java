package main;


abstract class Monster {
    protected String name;
    protected int hp;
    protected int hpMax;
    protected int attackPoint;
    protected int spd;
    protected Attribute attribute;
    protected int level;

    Monster(int hp, int hpMax, int attackPoint, int spd, Attribute attribute, int level) {
        this.hp = hp;
        this.hpMax = hpMax;
        this.attackPoint = attackPoint;
        this.spd = spd;
        this.attribute = attribute;
        this.level = level;
    }


    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getHpMax() {
        return this.hpMax;
    }

    public int getAttackPoint() {
        return this.attackPoint;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getSpd() {
        return this.spd;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public String getAttributeName() {
        return this.attribute.getName();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void levelUp(int level) {
        this.attackPoint = (this.attackPoint + level * 2);
        this.spd = (this.spd + level * 2);
        this.hp = (this.hp + level * 3);//hp
        this.hpMax = (this.hp + level * 3);//hp
        this.level = ((this.level + level) - 1);//level
    }

    public String getStatus() {
        return "[名前:" + this.getName() + " アタック:" + this.getAttackPoint() + " スピード:" + this.getSpd() + " タイプ:" + this.getAttributeName() + " HP" + this.getHp() + "/" + this.getHpMax() + "]";
    }

    public int attack(Monster other) {
        int attackPoint = this.getAttackPoint();
        int receiveOtherHp = other.getHp();
        double typeValue = Rule.decideCompatibility(this.getAttribute(), other.getAttribute());
        int result = (int) (attackPoint * typeValue);
        other.setHp(receiveOtherHp - result);
        return result;
    }

    public String afterAttackMessage() {
        return this.name + "の攻撃!";
    }

    public String printDamage(int damage) {
        return this.name + "は" + damage + "ダメージ与えた!";
    }
}

