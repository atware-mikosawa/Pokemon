package org.example;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainBattleTest {
    @Test
    void バトルフィールドにモンスター2体出ること() {
        Monster hitokage = new Hitokage();
        Monster zenigame = new Monster("ゼニガメ");
        int actual = MainBattle.monsterToField(hitokage, zenigame).size();
        assertEquals(2, actual);
//        assertThat(actual, is(2));
    }

    @Test
    void バトルフィールドに出ているモンスター名がヒトカゲとゼニガメであること() {
        Monster hitokage = new Hitokage();
        Monster zenigame = new Monster("ゼニガメ");
        String actual = MainBattle.getMonsterNametoString(hitokage);
        actual += MainBattle.getMonsterNametoString(zenigame);
        MatcherAssert.assertThat(
                actual, CoreMatchers.allOf(
                        CoreMatchers.containsString("ヒトカゲ"),
                        CoreMatchers.containsString("ゼニガメ")
                ));
    }

    @Test
    void getMyMonsterNameメソッドに例外が渡された場合エクセプションが返ること() {
//空のリストを作る
        List<Monster> emptyList = new ArrayList<>();
        //assertThrowsを使って空のリストを渡す
        assertThrows(IllegalArgumentException.class, () -> {
            MainBattle.getMyMonsterName(emptyList);
        });
    }

    @Test
    void getEnemyNameメソッドに例外が渡された時エクセプションを返すこと() {
        List<Monster> emptyList = new ArrayList<>();
//        assertThrows(呼び出される例外処理, 実行される処理);
        //ラムダ式を使うバージョン
        assertThrows(IllegalArgumentException.class, () -> {
            MainBattle.getEnemyName(emptyList);
        });
//
//        Predicate<Integer> isZero = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer == 0;
//            }
//        };
//
//        Predicate<Integer> isZeroByLambda = (Integer integer) -> integer == 0;
//
//        List<Integer> values = List.of(1, 2, 3, 4, 5);
//
//        for (Integer value : values) {
//            if (value % 2 == 0) {
//                System.out.println(value * 2);
//            }
//        }
//
//        values.stream()
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        return integer % 2 == 0;
//                    }
//                })
//                .map(value -> value * 2)
//                .forEach(value -> System.out.println(value));
//
//
//        System.out.println(isZero.test(0));
//        System.out.println(isZero.test(1));


        //ラムダ式不使用
//        assertThrows(IllegalAccessException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                MainBattle.getEnemyName(emptyList);
//            }
//        });
    }

    @Test
    void コマンドラインで受け取った値を正確に返すこと() {
        //オブジェクト生成
        int inputNum = 1;
        String inputValue = String.valueOf(inputNum);
        InputStream systemInNum = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(systemInNum);//コマンドに値が渡されたことをシュミレーション
        //期待値
        int expected = 1;
        //実測値
        int actual = MainBattle.processCommandNumber();
        //比較
        assertEquals(expected, actual);
    }

    @Test
    void processCommandNumberメソッドにint型以外の値が渡された際例外を返すこと() {
        String testValue = "あ";
        InputStream inputValue = new ByteArrayInputStream(testValue.getBytes());
        System.setIn(inputValue);
        assertThrows(InputMismatchException.class, () -> {
            MainBattle.processCommandNumber();
        });
    }

    @Test
    void processCommandNumberメソッドに空の値が渡された際例外を返すこと() {
        String emptyValue = "";
        InputStream inputValue = new ByteArrayInputStream(emptyValue.getBytes());
        System.setIn(inputValue);
        assertThrows(NoSuchElementException.class, () -> {
            MainBattle.processCommandNumber();
        });
    }

    @Test
    void モンスターのスピードが同じ場合50の確立でtrueが返されること() {
        Monster myMonster = new Monster("フシギダネ", 80, 15, 30);
        Monster enemyMonster = new Monster("ヒトカゲ", 70, 20, 30);
        int trueCount = 0;
        int falseCount = 0;
        int totalTest = 1000;
        for (int i = 0; i < totalTest; i++) {
            if (MainBattle.decideStartingAttacker(myMonster, enemyMonster) == true) {
                trueCount++;
            } else {
                falseCount++;
            }
        }
        double trueProbability = (double) trueCount / totalTest;
        double falseProbability = (double) falseCount / totalTest;
        assertThat(trueProbability, allOf(greaterThan(0.4), lessThan(0.6)));
        assertThat(falseProbability, allOf(greaterThan(0.4), lessThan(0.6)));
    }

    @Test
    void モンスターのスピードを比較してどちらが先にアタックできるか判定されること() {
        Monster myMonster = new Monster("フシギダネ", 80, 15, 40);
        Monster enemyMonster = new Monster("ヒトカゲ", 70, 20, 30);
        boolean actual = MainBattle.decideStartingAttacker(myMonster, enemyMonster);
//        assertThat(actual, is(true));
        assertEquals(true, actual);
    }
}