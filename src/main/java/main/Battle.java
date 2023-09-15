package main;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    //敵モンスターをランダムに出現させる
    public static Monster getRandomMonster() {
        Random rand = new Random();
        int num = rand.nextInt(2);
        switch (num) {
            case (0) -> {
                return new Pikachu();
            }
            case (1) -> {
                return new Eevee();
            }
            default -> {
                throw new IllegalStateException();
            }
        }
    }

    public static int commandReturnValue() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        try {
            result = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("1~4の値を入力してください");
        }
        return result;
    }

    //先行後攻の決定
    public static Monster getPriorityAttacker(Monster myMonster, Monster other) throws InvalidValueException {
        if (myMonster == null || other == null) {
            throw new InvalidValueException();
        }
        int mySpd = myMonster.getSpd();
        int otherSpd = other.getSpd();
        Random random = new Random();

        if ((mySpd - otherSpd) >= 0 && (mySpd - otherSpd) <= 10) {
            int num = random.nextInt(10) + 1;
            if (num % 2 == 0) {
                return other;
            } else {
                return myMonster;
            }
        } else if ((otherSpd - mySpd) >= 0 && (otherSpd - mySpd) <= 10) {
            int num = random.nextInt(10) + 1;
            if (num % 2 == 0) {
                return other;
            } else {
                return myMonster;
            }
        } else if (mySpd < otherSpd) {
            return other;
        } else return myMonster;

    }


    //バトル結果の判定
    public static Result returnResult(int myMonsterHp, int otherHp) {
        if (otherHp < 1) {
            return Result.WIN;
        } else if (myMonsterHp < 1) {
            return Result.LOSE;
        } else {
            return Result.DRAW;
        }
    }

    public static Result returnResult(int myMonsterHp) throws IllegalArgumentException {
        throw new IllegalArgumentException("引数が1個しか渡されていません");
    }
}
