package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MoveTest {
    Taiatari taiatari = new Taiatari();

    @ParameterizedTest
    @MethodSource
    void 各わざに名前があること(Move move, String expected) {
        assertThat(move.getName(), is(expected));
    }

    static Stream<Arguments> 各わざに名前があること() {
        return Stream.of(
                arguments(new Taiatari(), "たいあたり"),
                arguments(new Hikkaku(), "ひっかく")
        );
    }

    @ParameterizedTest
    @MethodSource
    void 各わざにダメージがあること(Move move, int expected) {
        assertThat(move.getDamage(), is(expected));
    }

    static Stream<Arguments> 各わざにダメージがあること() {
        return Stream.of(
                arguments(new Taiatari(), 4),
                arguments(new Hikkaku(), 4)
        );
    }

    @Test
    void たいあたりにタイプがあること() {
        assertThat(taiatari.getAttribute(), is(Attribute.NORMAL));
    }

}
