package com.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NegativeNumbersTest {

    @Test
    public void firstNumberIsNegative() {
        Assertions.assertThat(MathParser.parse("-2+2").execute()).isEqualTo(0);
        Assertions.assertThat(MathParser.parse("-2-2").execute()).isEqualTo(-4);
    }

    @Test
    public void secondNumberIsNegativeNoBrackets() {
        Assertions.assertThat(MathParser.parse("-2--2").execute()).isEqualTo(0);
    }

    @Test
    public void firstNumberIsNegativeAndLong() {
        Assertions.assertThat(MathParser.parse("-10+2").execute()).isEqualTo(-8);
        Assertions.assertThat(MathParser.parse("-5*2").execute()).isEqualTo(-10);
    }
}
