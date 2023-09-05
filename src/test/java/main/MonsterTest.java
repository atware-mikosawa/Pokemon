package main;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MonsterTest {
    @Test
    void 各モンスターに固有の名前があること() {
        Pikachu pikachu = new Pikachu();
        Eevee eevee = new Eevee();
        assertThat(pikachu.getName(), is("ピカチュウ"));
        assertThat(eevee.getName(), is("イーブイ"));
    }

    @Test
    void ピカチュウの初期HPは30であること() {
        Pikachu pikachu = new Pikachu();
        assertThat(pikachu.getHpMax(), is(30));
    }

    @Test
    void イーブイの初期HPが40であること() {
        Eevee eevee = new Eevee();
        assertThat(eevee.getHpMax(), is(40));
    }

    @Test
    void ピカチュウの攻撃力が4であること() {
        Pikachu pikachu = new Pikachu();
        assertThat(pikachu.getAttackPoint(), is(4));
    }

    @Test
    void モンスターの初期レベルが1であること() {
        Pikachu pikachu = new Pikachu();
        assertThat(pikachu.getLevel(), is(1));
    }

    @Test
    void モンスターはスピードをもつこと() {
        Pikachu pikachu = new Pikachu();
        assertThat(pikachu.getSpd(), is(3));
    }

    @Test
    void ピカチュウのレベルに応じてステータスが上がること() {
        Pikachu pikachu = new Pikachu(3);
        String expected = "[名前:ピカチュウ アタック:13 スピード:9 タイプ:電気 HP39/39]";
        assertThat(pikachu.getStatus(), is(expected));
    }

    @Test
    void イーブイのレベルに応じてステータスが上がること() {
        Eevee eevee = new Eevee(4);
        String expected = "[名前:イーブイ アタック:12 スピード:16 タイプ:ノーマル HP56/56]";
        assertThat(eevee.getStatus(), is(expected));
    }

    @Test
    void モンスターが攻撃したら攻撃力分だけ相手のHPが減ること() {
        Eevee eevee = new Eevee();
        Pikachu pikachu = new Pikachu();
        pikachu.attack(pikachu, eevee);
        assertThat(eevee.getHpMax(), is(36));
    }

    @Test
    void 現在のモンスターのステータスが返されること() {
        Pikachu pikachu = new Pikachu();
        String expected = "[名前:ピカチュウ アタック:4 スピード:3 タイプ:電気 HP30/30]";
        assertThat(pikachu.getStatus(), is(expected));
    }
}
