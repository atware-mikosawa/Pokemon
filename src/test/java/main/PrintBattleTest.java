package main;

import org.example.Monster;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrintBattleTest {
    @Test
    void モンスターを2体受け取って戦闘前のメッセージが表示されること() {
        Eevee myMonster = new Eevee();
        Pikachu other = new Pikachu();
        //テキストブロック
        String expected = "あっ!野生のピカチュウが出てきた!\n" + "ゆけっ!イーブイ";
        assertThat(PrintBattle.messageMonsterAppend(myMonster, other), is(expected));
    }
}
