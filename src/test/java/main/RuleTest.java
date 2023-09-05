package main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class RuleTest {
    @ParameterizedTest
    @MethodSource
    void 取得するタイプに応じて正しい数値が返ること(String attackType, String receiveType, double expected) {
        assertThat(Rule.decideCompatibility(attackType, receiveType), is(expected));
    }

    static Stream<Arguments> 取得するタイプに応じて正しい数値が返ること() {
        return Stream.of(
                arguments("電気", "ノーマル", 1.0),
                arguments("ノーマル", "電気", 1.0),
                arguments("電気", "水", 2.0)
        );
    }
}

