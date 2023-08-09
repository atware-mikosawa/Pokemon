package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
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

}