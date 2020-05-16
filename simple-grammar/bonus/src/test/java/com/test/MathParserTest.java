package com.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathParserTest {

    @Test
    public void simpleTest() {
        Assertions.assertThat(MathParser.parse("2+2").execute()).isEqualTo(4);
        Assertions.assertThat(MathParser.parse("2-2").execute()).isEqualTo(0);
        Assertions.assertThat(MathParser.parse("2*2").execute()).isEqualTo(4);
        Assertions.assertThat(MathParser.parse("2/2").execute()).isEqualTo(1);
    }

    @Test
    public void negativeAnswer() {
        Assertions.assertThat(MathParser.parse("2-4").execute()).isEqualTo(-2);
        Assertions.assertThat(MathParser.parse("14-20").execute()).isEqualTo(-6);
    }

    @Test
    public void longNumbers() {
        Assertions.assertThat(MathParser.parse("123+123").execute()).isEqualTo(246);
        Assertions.assertThat(MathParser.parse("15*4").execute()).isEqualTo(60);
    }

    @Test
    public void dividingByZero() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            MathParser.parse("1/0").execute();
        }).withMessageContaining("Cannot divide by zero");
    }
}
