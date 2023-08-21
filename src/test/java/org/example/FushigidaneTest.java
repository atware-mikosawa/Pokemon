package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class FushigidaneTest {
    @Test
    void レベルアップをすると正常にステータスが変わること() {
        Fushigidane fushigidane = new Fushigidane(5);
        assertThat(fushigidane.getStatsu(), CoreMatchers.allOf(
                CoreMatchers.containsString("120"),
                CoreMatchers.containsString("34")
        ));
    }
}
