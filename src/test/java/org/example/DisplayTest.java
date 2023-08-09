package org.example;

import com.sun.tools.javac.Main;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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


}