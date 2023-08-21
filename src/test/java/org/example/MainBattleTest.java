package org.example;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainBattleTest {
    @Test
    void バトルフィールドにモンスター2体出ること() {
        Monster hitokage = new Hitokage();
        Monster zenigame = new Monster("ゼニガメ");
        int actual = MainBattle.monsterToField(hitokage, zenigame).size();
        assertThat(actual, is(2));
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
}