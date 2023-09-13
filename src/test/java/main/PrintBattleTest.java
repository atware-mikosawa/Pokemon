package main;

import org.example.Monster;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrintBattleTest {
    @Test
    void 敵モンスターを受け取って戦闘前のメッセージが表示されること() {
        Pikachu other = new Pikachu();
        String expected = "あっ!野生のピカチュウが出てきた!";
        assertThat(PrintBattle.messageEnemyMonsterAppend(other), is(expected));
    }

    @Test
    void 味方モンスターの値を受け取ってメッセージが表示されること() {
        assertThat(PrintBattle.messageMyMonsterAppend(new Pikachu()), is("ゆけっ!ピカチュウ"));
    }
    @Test
    void 戦闘コマンドを受け取る直前のメッセージが正しく出ること() {
        Pikachu pikachu = new Pikachu();
        String expected = """
                ピカチュウはどうする?
                1:たたかう     3:バッグ
                2:逃げる       4:ポケモン
                                """;
        assertThat(PrintBattle.beforeReceiveCommand(pikachu), is(expected));
    }
}
