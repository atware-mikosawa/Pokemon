package main;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MainBattleTest {
    @Test
    void スピードの判定ができること() {
        Pikachu pikachu = new Pikachu();
        Eevee eevee = new Eevee();
        assertThat(Battle.getPriorityAttacker(pikachu, eevee), is(eevee));
    }
}
