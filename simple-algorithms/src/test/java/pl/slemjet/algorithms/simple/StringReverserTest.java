package pl.slemjet.algorithms.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReverserTest {

    @Test
    void reverseStringRecursive() {
        // when
        String reversedString = StringReverser.reverseStringRecursive("yoyo mastery");

        // then
        Assertions.assertThat(reversedString).isEqualTo("yretsam oyoy");
    }
}