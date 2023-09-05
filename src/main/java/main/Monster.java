package main;


abstract class AbstractMonster {
    protected String name;
    protected int hp;
    protected int hpMax;
    protected int attackPoint;
    protected int spd;
    protected String attribute;
    protected int level;

    AbstractMonster(int hp, int hpMax, int attackPoint, int spd, String attribute, int level) {
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

    public String getAttribute() {
        return this.attribute;
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
        return "[名前:" + this.getName() + " アタック:" + this.getAttackPoint() + " スピード:" + this.getSpd() + " タイプ:" + this.getAttribute() + " HP" + this.getHp() + "/" + this.getHpMax() + "]";
    }

    public void attack(AbstractMonster myMonster, AbstractMonster other) {
        int attackPoint = myMonster.getAttackPoint();
        int receiveOther = other.getHpMax();
        double typeValue = Rule.decideCompatibility(myMonster.getAttribute(), other.getAttribute());
        other.setHpMax((int) (receiveOther - (attackPoint * typeValue)));
    }

}

