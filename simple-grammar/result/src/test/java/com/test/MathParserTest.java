package com.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathParserTest {

    @Test
    public void simpleTest() {
        Assertions.assertThat(MathParser.parse("2+2").execute()).isEqualTo(4);
    }
}
