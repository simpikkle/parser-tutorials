package com.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FloatingPointNumbersTest {

    @Test
    public void firstNumberIsNotInteger() {
        Assertions.assertThat(MathParser.parse("10.5+1").execute()).isEqualTo(11.5);
    }

    @Test
    public void secondNumberIsNotInteger() {
        Assertions.assertThat(MathParser.parse("10+1.5").execute()).isEqualTo(11.5);
    }


    @Test
    public void bothNumbersIsNotInteger() {
        Assertions.assertThat(MathParser.parse("10.5+1.5").execute()).isEqualTo(12);
    }


    @Test
    public void firstNumberIsNotIntegerAndNegative() {
        Assertions.assertThat(MathParser.parse("-11.5+1.5").execute()).isEqualTo(-10);
    }

}
