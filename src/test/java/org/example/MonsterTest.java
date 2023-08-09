package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {
    @Test
    void モンスターはHpを持つこと() {
        Monster monster = new Monster("ヒトカゲ", 100,15);
        int actual = monster.getHp();
        assertThat(actual, is(100));
    }

    @Test
    void インスタンス化されたモンスターは攻撃力を持つこと() {
        Monster monster = new Monster("ヒトカゲ", 100, 15);
        int actual = monster.getAtk();
        assertThat(actual, is(15));
    }

}