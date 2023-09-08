package main;

public class PrintBattle {
    public static String messageMonsterAppend(Monster myMonster, Monster other) {
        return "あっ!野生の" + other.getName() + "が出てきた!\n"
                + "ゆけっ!" + myMonster.getName();
    }
}
