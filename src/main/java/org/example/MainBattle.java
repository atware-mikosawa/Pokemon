package org.example;

import java.util.Map;
import java.util.Set;

public class MainBattle {
    static Monster hitokage = new Hitokage();
    static Monster zenigame = new Monster("ゼニガメ");

    public static void main(String[] args) {
        monsterToField(hitokage, zenigame);
    }

    public static Set<Monster> monsterToField(Monster myMonster, Monster enemyMonster) {
        return Set.of(myMonster, enemyMonster);
    }

    public static String toString(Monster monster) {
        return monster.getName();
    }
}