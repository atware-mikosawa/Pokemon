package org.example;

import java.util.*;

public class MainBattle {
//    static  hitokage = new Hitokage(3);
    //    static Monster zenigame = new Monster("ゼニガメ");
//    static Fushigidane fushigidane = new Fushigidane(3);


    public static void main(String[] args) {
        Hitokage hitokage = new Hitokage(3);
        Fushigidane fushigidane = new Fushigidane(3);
        List<Monster> monsters = monsterToField(hitokage, fushigidane);
        String myMonsterName = getMyMonsterName(monsters);
        String enemyMonster = getEnemyName(monsters);
        int commandNum = 0;

        System.out.println(MainBattle.getTheNameListMonster(monsters));
        try {
            System.out.println(messageWhenEnemyEncounter(enemyMonster));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(messageForMyMonster(myMonsterName));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        System.out.println("ボンっ！");
        System.out.println("【それぞれのステータス】");
        System.out.println(hitokage.getStatsu());
        System.out.println(fushigidane.getStatsu());

        //ここから無限ループ？
        //たたかうか逃げるを選択させる
        System.out.println(monsterActionMessage(myMonsterName));
        try {
            commandNum = processCommandNumber();
        } catch (InputMismatchException e) {
            System.out.println("1か2の数値を入力してください");
        } catch (NoSuchElementException e) {
            System.out.println("入力された値が空です");
        }

        if (commandNum == 1) {
            //どちらが初めに攻撃をするのか？を判定するメソッド
            //攻撃でダメージが減るメソッド

        } else if (commandNum == 2) {
            //逃げられるか？を判定するメソッド
        }
        //逃げるが選択された場合、逃げられるか？を判定するメソッド
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

    public static String monsterActionMessage(String myMonsterName) {
        String result = myMonsterName + "はどうする？\n";
        result += "たたかう：1\nにげる：2\n";
        return result;
    }

    //コマンドから数字を受けとり受け取った数字を返すメソッド
    public static int processCommandNumber() {
        int tmpNum;
        Scanner sc = new Scanner(System.in);
//        try {
//            tmpNum = sc.nextInt();
//        } catch (InputMismatchException e) {
//            System.out.println("1か2の数値を入力してください");
//        } catch (NoSuchElementException e) {
//            System.out.println("値が空です");
//        }
        tmpNum = sc.nextInt();
        return tmpNum;
    }

    public static boolean decideStartingAttacker(Monster myMonster, Monster enemyMonster) {
        int myMonsterSpeed = myMonster.getSpeed();
        int enemyMonsterSpeed = enemyMonster.getSpeed();
        if (myMonsterSpeed == enemyMonsterSpeed) {
            //50%の確立でtrue,false
            int roundNum = (int) Math.round(Math.random() * 10);
            if (roundNum % 2 == 0) {
                return true;
            } else {
                return false;
            }
        } else if (myMonsterSpeed > enemyMonsterSpeed) {
            return true;
        } else {
            return false;
        }
    }
}
