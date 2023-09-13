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

        if (receiveNum == 1) {//たたかう
            try {
                firstAttackMonster = Battle.getPriorityAttacker(myMonster, enemyMonster);
            } catch (InvalidValueException e) {
                System.out.println();
            }
            if (firstAttackMonster == myMonster) {

            } else {

            }
        }
    }
}
