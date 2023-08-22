package org.example;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class HitokageTest {
    @Test
    void オーバーライドしたレベルアップメソッドが正常に作動していること() {
        //オブジェクト生成
        Hitokage hitokage = new Hitokage(5);
        String actual = hitokage.getStatsu();
        System.out.println(actual);
        assertThat(actual, CoreMatchers.allOf(
                CoreMatchers.containsString("90"),//文字列には次の文字が含まれていること
                CoreMatchers.containsString("48"),
                CoreMatchers.containsString("40")
        ));

    }
}
