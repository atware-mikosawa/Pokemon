package main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AttributeTest {
    @ParameterizedTest
    @MethodSource
    void 各タイプはそれぞれ名前を持つこと(Attribute type, String expected) {
        assertThat(type.getName(), is(expected));
    }

    static Stream<Arguments> 各タイプはそれぞれ名前を持つこと() {
        return Stream.of(
                arguments(Attribute.NORMAL, "ノーマル"),
                arguments(Attribute.ELECTRICITY, "電気"),
                arguments(Attribute.WATER, "水"),
                arguments(Attribute.SOIL, "土")
        );
    }

}
