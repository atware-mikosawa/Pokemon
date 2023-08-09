package org.example;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

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
}