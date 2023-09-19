package main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static main.Attribute.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class RuleTest {
    @ParameterizedTest
    @MethodSource
    void 取得するタイプに応じて正しい数値が返ること(Attribute attackType, Attribute receiveType, double expected) {
        assertThat(Rule.decideCompatibility(attackType, receiveType), is(expected));
    }

    static Stream<Arguments> 取得するタイプに応じて正しい数値が返ること() {
        return Stream.of(
                arguments(NORMAL, NORMAL, 1.0),
                arguments(ELECTRICITY, ELECTRICITY, 1.0),
                arguments(NORMAL, ELECTRICITY, 1.0),
                arguments(ELECTRICITY, WATER, 2.0)
        );
    }

}

