package main;

import org.junit.jupiter.api.Test;
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
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MainBattleTest {
    @Test
    void スピードの判定ができること() {
        Pikachu pikachu = new Pikachu();
        Eevee eevee = new Eevee();
        assertThat(Battle.getPriorityAttacker(pikachu, eevee), is(eevee));
    }

    @Test
    void スピードの差が10以内であればスピードの判定が半分の確率になること() {
        Pikachu pikachu = new Pikachu();
        Eevee eevee = new Eevee();
        Map<Monster, Long> resultList = IntStream.range(0, 1000)
                .mapToObj(num -> Battle.getPriorityAttacker(pikachu, eevee))
                .collect(groupingBy(identity(), counting()));
        assertThat(resultList.get(pikachu), is(greaterThan(400L)));
    }

    @ParameterizedTest
    @MethodSource
    void 取得するHPによって正しく結果が返ること(int myHp, int otherHp, Result expected) {
        assertThat(Battle.returnResult(myHp, otherHp), is(expected));
    }

    static Stream<Arguments> 取得するHPによって正しく結果が返ること() {
        return Stream.of(
                arguments(10, 0, Result.WIN),
                arguments(0, 10, Result.LOSE),
                arguments(10, 10, Result.DRAW)
        );
    }

}
