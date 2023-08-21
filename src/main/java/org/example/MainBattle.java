package org.example;

import java.util.*;

public class MainBattle {
//    static Hitokage hitokage = new Hitokage(3);
    //    static Monster zenigame = new Monster("ゼニガメ");
//    static Fushigidane fushigidane = new Fushigidane(3);


    public static void main(String[] args) {
        Hitokage hitokage = new Hitokage(3);
        Fushigidane fushigidane = new Fushigidane(3);
        List<Monster> monsters = monsterToField(hitokage, fushigidane);

        System.out.println(MainBattle.getTheNameListMonster(monsters));
        try {
            String enemyMonster = getEnemyName(monsters);
            System.out.println(messageWhenEnemyEncounter(enemyMonster));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            String myMonsterName = getMyMonsterName(monsters);
            System.out.println(messageForMyMonster(myMonsterName));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        System.out.println("ボンっ！");
        System.out.println("【それぞれのステータス】");
        System.out.println(hitokage.getStatsu());
        System.out.println(fushigidane.getStatsu());
    }

    public static String getMyMonsterName(List<Monster> monsters) throws IllegalArgumentException {
        if (monsters.size() > 1) {
            Monster MyMonster = monsters.get(0);
            return MyMonster.getName();
        }
        throw new IllegalArgumentException("味方のモンスターが正常に読み込まれていません。");
    }

    public static String getEnemyName(List<Monster> monster) throws IllegalArgumentException {
        if (monster.size() > 1) {
            Monster enemyMonster = monster.get(1);
            return enemyMonster.getName();
        }
        throw new IllegalArgumentException("敵のモンスターが正常に入力されていません");
    }

    public static String messageForMyMonster(String myMonster) {
        return "ゆけっ！" + myMonster;
    }

    public static String messageWhenEnemyEncounter(String enemyMonster) {
        return "あっ！野生の　" + enemyMonster + "　がでてきた！";
    }

    public static List<Monster> monsterToField(Monster myMonster, Monster enemyMonster) {
        return List.of(myMonster, enemyMonster);
    }

    public static String getTheNameListMonster(List<Monster> monsters) {
        String monsterName = "";
        for (Monster monster : monsters) {
            monsterName += monster.getName() + "　";
        }
        return monsterName;
    }

    public static String getMonsterNametoString(Monster monster) {
        return monster.getName();
    }
}
