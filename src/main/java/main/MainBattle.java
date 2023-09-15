package main;

import java.util.InputMismatchException;
import java.util.Random;

public class MainBattle {
    public static void main(String... args) {
//        モンスターの決定
        Monster myMonster = new Pikachu(3);
        Monster enemyMonster;
        enemyMonster = Battle.getRandomMonster();
        System.out.println(PrintBattle.messageEnemyMonsterAppend(enemyMonster));
        System.out.println(PrintBattle.messageMyMonsterAppend(myMonster));

        while (true) {
            Monster firstAttackMonster = null;
            int receiveNum = 0;
            boolean decide = false;
            System.out.println("\n敵モンスターのステータス");
            System.out.println(enemyMonster.getStatus());
            System.out.println("\n自分のステータス");
            System.out.println(myMonster.getStatus());

            while (!decide) {
                try {
                    System.out.println("\n" + PrintBattle.beforeReceiveCommand(myMonster));
                    decide = true;
                    receiveNum = Battle.commandReturnValue();
                } catch (InputMismatchException e) {
                    decide = false;
                }
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
            } else {// 逃げる

            }
//            ステータス確認
            System.out.println("相手のステータス");
            System.out.println(enemyMonster.getStatus());
            System.out.println("自分のステータス");
            System.out.println(myMonster.getStatus());
            Result battleResult = Battle.returnResult(myMonster.getHp(), enemyMonster.getHp());
            System.out.println(battleResult.resultMessage(myMonster));
            if (battleResult == Result.WIN || battleResult == Result.LOSE) {
                System.out.println("バトル終了！");
                break;
            } else {

            }
        }
    }
}

