package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MonsterTest {
    @Test
    void モンスターはHpを持つこと() {
        Monster monster = new Monster("ヒトカゲ", 100, 15, 10);
        int actual = monster.getHp();
        assertThat(actual, is(100));
    }

    @Test
    void インスタンス化されたモンスターは攻撃力を持つこと() {
        Monster monster = new Monster("ヒトカゲ", 100, 15,10);
        int actual = monster.getAtk();
        assertThat(actual, is(15));
    }

    @Test
    void レベルアップすると正常にステータスが変わること() {
        Monster monster = new Monster("ヒトカゲ", 100, 15, 10,3);
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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}