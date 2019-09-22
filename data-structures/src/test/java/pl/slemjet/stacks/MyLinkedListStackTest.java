package pl.slemjet.stacks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyLinkedListStackTest {
    @Test
    void test() {
        //given
        MyLinkedListStack<String> stack = new MyLinkedListStack<>();

        stack.push("Discord");
        stack.push("Udemy");
        stack.push("Google");

        //when
        System.out.println(stack);
        Assertions.assertThat(stack.isEmpty()).isFalse();
        String first = stack.pop();
        System.out.println(stack);
        Assertions.assertThat(first).isEqualTo("Google");
        Assertions.assertThat(stack.pop()).isEqualTo("Udemy");
        System.out.println(stack);
        Assertions.assertThat(stack.pop()).isEqualTo("Discord");
        System.out.println(stack);
        Assertions.assertThat(stack.isEmpty()).isTrue();

        stack.push("Hello");
        System.out.println(stack);
        Assertions.assertThat(stack.isEmpty()).isFalse();
    }
}