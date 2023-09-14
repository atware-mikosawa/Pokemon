package main;

import java.util.Random;

public class MainBattle {
    public static void main(String... args) {
        Monster myMonster = new Pikachu(3);
        Monster enemyMonster;
        Monster firstAttackMonster = null;
        int receiveNum = 0;

//        モンスターの決定
        enemyMonster = Battle.getRandomMonster();
        System.out.println(PrintBattle.messageEnemyMonsterAppend(enemyMonster));
        System.out.println(PrintBattle.messageMyMonsterAppend(myMonster));

        System.out.println("\n敵モンスターのステータス");
        System.out.println(enemyMonster.getStatus());
        System.out.println("\n自分のステータス");
        System.out.println(myMonster.getStatus());

        System.out.println("\n" + PrintBattle.beforeReceiveCommand(myMonster));
        try {
            receiveNum = Battle.commandReturnValue();
        } catch (IllegalArgumentException e) {
            System.out.println("1~4の値を入力してください");
        }

        //たたかう
        if (receiveNum == 1) {
            try {
                firstAttackMonster = Battle.getPriorityAttacker(myMonster, enemyMonster);
            } catch (InvalidValueException e) {
                System.out.println();
            }
            //自分が先行の場合
            if (firstAttackMonster == myMonster) {
                System.out.println(myMonster.afterAttackMessage());
                int damage1 = myMonster.attack(enemyMonster);
                System.out.println(myMonster.printDamage(damage1) + "\n");

                System.out.println(enemyMonster.afterAttackMessage());
                int damage2 = enemyMonster.attack(myMonster);
                System.out.println(enemyMonster.printDamage(damage2) + "\n");
                //相手が先行の場合
            } else {
                System.out.println(enemyMonster.afterAttackMessage());
                int damage2 = enemyMonster.attack(myMonster);
                System.out.println(enemyMonster.printDamage(damage2) + "\n");

                System.out.println(myMonster.afterAttackMessage());
                int damage = myMonster.attack(enemyMonster);
                System.out.println(myMonster.printDamage(damage) + "\n");
            }
        }

        //ステータス確認
        System.out.println("相手のステータス");
        System.out.println(enemyMonster.getStatus());
        System.out.println("自分のステータス");
        System.out.println(myMonster.getStatus());
    }
}

