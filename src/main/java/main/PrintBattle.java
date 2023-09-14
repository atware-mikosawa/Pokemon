package main;

public class PrintBattle {
    public static String messageEnemyMonsterAppend(Monster other) {
        return "あっ!野生の" + other.getName() + "が出てきた!";
    }

    public static String messageMyMonsterAppend(Monster myMonster) {
        return "ゆけっ!" + myMonster.getName();
    }

    public static String beforeReceiveCommand(Monster monster) {
        return monster.getName() + """
                はどうする?
                1:たたかう     3:バッグ
                2:逃げる       4:ポケモン
                                """;
    }

}
