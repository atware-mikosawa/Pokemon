package org.example;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class MainTest {
    @Test
    void test() {
        int actual = 1;
        assertThat(actual, is(1));
    }

}