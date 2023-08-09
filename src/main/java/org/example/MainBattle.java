package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainBattle {
    static Monster hitokage = new Hitokage();
    static Monster zenigame = new Monster("ゼニガメ");

    public static void main(String[] args)  {
        List<Monster> monsters = monsterToField(hitokage, zenigame);
        System.out.println(MainBattle.getTheNameListMonster(monsters));
        try {
            String enemyMonster = getEnemyName(monsters);
            System.out.println(messageWhenEnemyEncounter(enemyMonster));
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        System.out.println("【それぞれのステータス】");
        System.out.println(hitokage.getStatsu());
        System.out.println(zenigame.getStatsu());
    }

    public static String getEnemyName(List<Monster> monster) throws IllegalAccessException {
        if (monster.size() > 1) {
            Monster enemyMonster = monster.get(1);
            return enemyMonster.getName();
        }
        throw new IllegalAccessException("敵のモンスターが正常に入力されていません");
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