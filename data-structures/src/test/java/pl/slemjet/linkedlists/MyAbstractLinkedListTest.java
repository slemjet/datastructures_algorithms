package pl.slemjet.linkedlists;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    @Test
    void testLinkedList() {
        //given
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(10);

        //when
        linkedList.append(5).append(16);
        System.out.println(linkedList);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(10);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(16);
        Assertions.assertThat(linkedList.getLength()).isEqualTo(3);

        linkedList.prepend(1);
        System.out.println(linkedList);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getLength()).isEqualTo(4);

        linkedList.insert(2, 99);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(16);
        linkedList.insert(100, 88);
        System.out.println(linkedList);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(88);
        Assertions.assertThat(linkedList.getLength()).isEqualTo(6);

        linkedList.remove(3);
        System.out.println(linkedList);
        Assertions.assertThat(linkedList.getLength()).isEqualTo(5);

        linkedList.reverse();
        System.out.println("Reversed:" + linkedList);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(88);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(1);
        Assertions.assertThat(linkedList.getLength()).isEqualTo(5);

        linkedList.reverse2();
        System.out.println("Reversed again:" + linkedList);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(88);
        Assertions.assertThat(linkedList.getLength()).isEqualTo(5);
        //then
    }
}