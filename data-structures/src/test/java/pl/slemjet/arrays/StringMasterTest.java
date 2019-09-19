package pl.slemjet.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringMasterTest {
    @Test
    void testReverse() {
        String input = "Hi, my name is Sergei!";
        String expectedOutput = "!iegreS si eman ym ,iH";

        String reversed = StringMaster.reverse(input);
        Assertions.assertThat(reversed).isEqualTo(expectedOutput);
    }

    @Test
    void testReverse2() {
        String input = "Hi, my name is Sergei!";
        String expectedOutput = "!iegreS si eman ym ,iH";

        String reversed = StringMaster.reverse2(input);
        Assertions.assertThat(reversed).isEqualTo(expectedOutput);
    }

    @Test
    void testReverse3() {
        String input = "Hi, my name is Sergei!";
        String expectedOutput = "!iegreS si eman ym ,iH";

        String reversed = StringMaster.reverse3(input);
        Assertions.assertThat(reversed).isEqualTo(expectedOutput);
    }
}