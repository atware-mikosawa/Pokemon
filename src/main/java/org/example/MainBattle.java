package org.example;

import java.util.Map;
import java.util.Set;

public class MainBattle {
    static Monster hitokage = new Hitokage();
    static Monster zenigame = new Monster("ゼニガメ");

    public static void main(String[] args) {
        Set<Monster> monsters = monsterToField(hitokage, zenigame);
        System.out.println(MainBattle.getTheNameSetMonster(monsters));
        System.out.println("【それぞれのステータス】");
        System.out.println(hitokage.getStatsu());
        System.out.println(zenigame.getStatsu());
    }

    public static Set<Monster> monsterToField(Monster myMonster, Monster enemyMonster) {
        return Set.of(myMonster, enemyMonster);
    }

    public static String getTheNameSetMonster(Set<Monster> monsters) {
        String monsterName = "";
        for (Monster monster : monsters) {
            monsterName += monster.getName() + ",";
        }
        return monsterName;
    }

    public static String getMonsterNametoString(Monster monster) {
        return monster.getName();
    }
}