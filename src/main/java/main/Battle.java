package main;

import java.util.Random;

public class Battle {
    public static AbstractMonster getPriorityAttacker(AbstractMonster myMonster, AbstractMonster other) {
        int mySpd = myMonster.getSpd();
        int otherSpd = other.getSpd();
        Random random = new Random();

        if (mySpd < otherSpd) {
            return other;
        } else if (otherSpd < mySpd) {
            return myMonster;
        } else {
            int num = random.nextInt(10) + 1;
            if (num % 2 == 0) {
                return other;
            } else {
                return myMonster;
            }
        }
    }
}
