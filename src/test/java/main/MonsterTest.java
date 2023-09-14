package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MonsterTest {
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

    @Nested
    class MonsterBasicTest {
        private Pikachu pikachu;
        private Eevee eevee;

        @BeforeEach
        void setUp() {//共通部分
            pikachu = new Pikachu();
            eevee = new Eevee();
        }

        @Test
        void 各モンスターに固有の名前があること() {
            assertThat(pikachu.getName(), is("ピカチュウ"));
            assertThat(eevee.getName(), is("イーブイ"));
        }

        @Test
        void ピカチュウの初期HPは30であること() {
            assertThat(pikachu.getHpMax(), is(30));
        }

        @Test
        void イーブイの初期HPが40であること() {
            assertThat(eevee.getHpMax(), is(40));
        }

        @Test
        void ピカチュウの攻撃力が4であること() {
            assertThat(pikachu.getAttackPoint(), is(4));
        }

        @Test
        void モンスターの初期レベルが1であること() {
            assertThat(pikachu.getLevel(), is(1));
        }

        @Test
        void モンスターはスピードをもつこと() {
            assertThat(pikachu.getSpd(), is(3));
        }

        @Test
        void モンスターはタイプを持つこと() {
            assertThat(pikachu.getAttribute(), is(Attribute.ELECTRICITY));
        }

        @Test
        void モンスターが攻撃したら攻撃力分だけ相手のHPが減ること() {
            pikachu.attack(eevee);
            assertThat(eevee.getHp(), is(36));
        }

        @Test
        void 現在のモンスターのステータスが返されること() {
            String expected = "[名前:ピカチュウ アタック:4 スピード:3 タイプ:電気 HP30/30]";
            assertThat(pikachu.getStatus(), is(expected));
        }

        @Test
        void 攻撃を行った後メッセージが出ること() {
            assertThat(pikachu.afterAttackMessage(), is("ピカチュウの攻撃!"));
        }

        @Test
        void 何ダメージ与えたのかメッセージされること() {
            int damage = pikachu.attack(eevee);
            assertThat(pikachu.printDamage(damage), is("ピカチュウは4ダメージ与えた!"));
        }
    }
}
