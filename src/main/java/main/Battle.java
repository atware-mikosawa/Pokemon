package main;

import java.util.Random;

public class Battle {
    //先行後攻の決定
    public static Monster getPriorityAttacker(Monster myMonster, Monster other) {
        int mySpd = myMonster.getSpd();
        int otherSpd = other.getSpd();
        Random random = new Random();

        if (mySpd < otherSpd) {
            return other;
        } else if (otherSpd < mySpd) {
            return myMonster;
        } else if (Math.abs(mySpd - otherSpd) <= 10) {
            int num = random.nextInt(10) + 1;
            if (num % 2 == 0) {
                return other;
            } else {
                return myMonster;
            }
        } else if (Math.abs(otherSpd - mySpd) <= 10) {
            int num = random.nextInt(10) + 1;
            if (num % 2 == 0) {
                return other;
            } else {
                return myMonster;
            }
        } else {
            int num = random.nextInt(10) + 1;
            if (num % 2 == 0) {
                return other;
            } else {
                return myMonster;
            }
        }
    }

    //バトル結果の判定
    public static Result returnResult(int myMonsterHp, int otherHp) {
        if (otherHp == 0) {
            return Result.WIN;
        } else if (myMonsterHp == 0) {
            return Result.LOSE;
        } else {
            return Result.DRAW;
        }

    }
}
