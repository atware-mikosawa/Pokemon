package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayTest {
    @Test
    void testGetTheNameSetMonster() {
        Monster hitokage = new Hitokage();
        Monster zenigame = new Monster("ゼニガメ");
        List<Monster> monsters = MainBattle.monsterToField(hitokage, zenigame);
        String actual = MainBattle.getTheNameListMonster(monsters);
        assertThat(actual, CoreMatchers.allOf(
                CoreMatchers.containsString("ヒトカゲ"),
                CoreMatchers.containsString("ゼニガメ")
        ));
    }

    @Test
    void フィールドに出ているモンスターのステータスが表示されこと() {
        Monster hitokage = new Hitokage();
        String actual = hitokage.getStatsu();
        assertThat(actual, is(
                "[" + hitokage.getName()
                        + " lv" + hitokage.getlv() + "　攻撃力" + hitokage.getAtk()
                        + " HP" + hitokage.getHp() + "/" + hitokage.getHp() + "]"
        ));
    }

    @Test
    void 味方のモンスター名が表示されること() {
        Hitokage hitokage = new Hitokage();
        Fushigidane fushigidane = new Fushigidane();
        List<Monster> monsters = Arrays.asList(hitokage, fushigidane);

        String actual = MainBattle.messageForMyMonster(MainBattle.getMyMonsterName(monsters));
//        assertEquals("ゆけっ！ヒトカゲ", actual);
        assertThat(actual, is("ゆけっ！ヒトカゲ"));
    }

}