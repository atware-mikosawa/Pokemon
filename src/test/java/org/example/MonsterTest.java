package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {
    @Test
    void モンスターはHpを持つこと() {
        Monster monster = new Monster("ヒトカゲ", 100, 15);
        int actual = monster.getHp();
        assertThat(actual, is(100));
    }

    @Test
    void インスタンス化されたモンスターは攻撃力を持つこと() {
        Monster monster = new Monster("ヒトカゲ", 100, 15);
        int actual = monster.getAtk();
        assertThat(actual, is(15));
    }

    @Test
    void レベルアップすると正常にステータスが変わること() {
        Monster monster = new Monster("ヒトカゲ", 100, 15, 3);
        String actual = monster.getStatsu();
        System.out.println(actual);
        assertThat(actual, CoreMatchers.allOf(//全てのコアマッチャーズには次の全てが含まれています
                CoreMatchers.containsString("115"),//文字の核心には次の文字列が含まれています
                CoreMatchers.containsString("24")
        ));
    }

    @Test
    void メソッドに渡したListの2番目の値の名前が取得できること() {
        Monster hitokage = new Hitokage();
        Monster fushigidane = new Monster("フシギダネ");
        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(hitokage);
        monsterList.add(fushigidane);
        try {
            String actual = MainBattle.getEnemyName(monsterList);
            assertThat(actual, is("フシギダネ"));
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getEnemyNameメソッドに例外が渡された時エクセプションを返すこと() {
        List<Monster> emptyList = new ArrayList<>();
//        assertThrows(呼び出される例外処理, 実行される処理);
        //ラムダ式を使うバージョン
        assertThrows(IllegalAccessException.class, () -> {
           MainBattle.getEnemyName(emptyList);
        });

        //ラムダ式不使用
//        assertThrows(IllegalAccessException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                MainBattle.getEnemyName(emptyList);
//            }
//        });
    }

}