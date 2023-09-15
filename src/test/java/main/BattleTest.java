package main;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BattleTest {
    @Test
    void 敵モンスターがランダムに選ばれること() {
        Monster actual = Battle.getRandomMonster();
        assertThat(actual, anyOf(is(instanceOf(Pikachu.class)), is(instanceOf(Eevee.class))));
    }

    @Test
    void スピードの判定ができること() throws InvalidValueException {
        Pikachu pikachu = new Pikachu();
        Eevee eevee = new Eevee(10);
        assertThat(Battle.getPriorityAttacker(pikachu, eevee), is(eevee));
    }

    @Test
    void スピードの差が10以内であればスピードの判定が半分の確率になること() {
        Pikachu pikachu = new Pikachu();
        Eevee eevee = new Eevee();
        Map<Monster, Long> resultList = IntStream.range(0, 1000)
                .mapToObj(num -> {
                    try {
                        return Battle.getPriorityAttacker(pikachu, eevee);
                    } catch (InvalidValueException e) {
                        System.out.println(e.getMessage());
                    }
                    return null;
                })
                .collect(groupingBy(identity(), counting()));
        assertThat(resultList.get(eevee), is(greaterThan(400L)));
    }

    @ParameterizedTest
    @MethodSource
    void 取得するHPによって正しく結果が返ること(int myHp, int otherHp, Result expected) {
        assertThat(Battle.returnResult(myHp, otherHp), is(expected));
    }

    static Stream<Arguments> 取得するHPによって正しく結果が返ること() {
        return Stream.of(
                arguments(10, -10, Result.WIN),
                arguments(0, 10, Result.LOSE),
                arguments(10, 10, Result.DRAW)
        );
    }

    @ParameterizedTest
    @MethodSource
    void それぞれの結果に名前があること(Result result, String expected) {
        assertThat(result.toString(), is(expected));
    }

    static Stream<Arguments> それぞれの結果に名前があること() {
        return Stream.of(
                arguments(Result.WIN, "勝ち"),
                arguments(Result.LOSE, "負け"),
                arguments(Result.DRAW, "引き分け")
        );
    }

    @Test
    void WINを受け取ったら勝利のメッセージが返ること() {
        Pikachu myMonster = new Pikachu();
        assertThat(Result.WIN.resultMessage(myMonster), is("ピカチュウの勝ち！"));
    }

    @ParameterizedTest
    @MethodSource
    void それぞれの結果に応じてメッセージが返ること(Result result, String expected) {
        assertThat(result.resultMessage(new Pikachu()), is(expected));
    }

    static Stream<Arguments> それぞれの結果に応じてメッセージが返ること() {
        return Stream.of(
                arguments(Result.WIN, "ピカチュウの勝ち！"),
                arguments(Result.LOSE, "ピカチュウの負け！"),
                arguments(Result.DRAW, "まだバトルは続いている！")
        );
    }

    @Nested
    class ExceptionTest {
        @Test
        void 引数にnullが渡ったら例外とそれに伴うメッセージが返ること() {
            try {//例外が発生する可能性がある処理
                Battle.getPriorityAttacker(null, null);
            } catch (InvalidValueException e) {//tryで発生した例外をキャッチしてその例外に応じた処理を返す
                assertThat(e.getMessage(), is("空の値が渡りました。"));
            }
        }

        @Test
        void 引数にnullが渡ったら例外とそれに伴うメッセージが返ること2() {
            assertThrows(InvalidValueException.class, () -> Battle.getPriorityAttacker(null, new Pikachu()));
        }

        @Test
        void 引数にnullが渡ったら例外とそれに伴うメッセージが返ること3() {
            //ラムダ無し
            assertThrows(InvalidValueException.class, new Executable() {
                @Override
                public void execute() throws InvalidValueException {
                    Battle.getPriorityAttacker(null, new Pikachu());
                }
            });
        }

        @Test
        void 数値が1つだけ渡されたら例外とそれに伴うメッセージが返ること() {
            assertThrows(IllegalArgumentException.class, () -> Battle.returnResult(10));
        }

        @Test
        void 数値が1つだけ渡されたら例外とそれに伴うメッセージが返ること_tryCatch() {
            try {
                Battle.returnResult(10);
            } catch (IllegalArgumentException e) {
                assertThat(e.getMessage(), is("引数が1個しか渡されていません"));
            }
        }

        @Test
        void 数値が1つだけ渡されたら例外とそれに伴うメッセージが返ること_assertThrows() {
            assertThrows(IllegalArgumentException.class, () -> Battle.returnResult(10));
        }
    }
}


