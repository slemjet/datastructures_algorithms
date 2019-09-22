package pl.slemjet.linkedlists;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyDoublyAbstractLinkedListTest {
    @Test
    void test() {
        //given
        MyDoublyLinkedList<Integer> doublyLinkedList = new MyDoublyLinkedList<>(1);

        //when
        doublyLinkedList
                .append(2)
                .append(4)
                .prepend(60);
        System.out.println(doublyLinkedList);
        Assertions.assertThat(doublyLinkedList.getHead()).isEqualTo(60);
        Assertions.assertThat(doublyLinkedList.getTail()).isEqualTo(4);
        Assertions.assertThat(doublyLinkedList.getLength()).isEqualTo(4);

        doublyLinkedList.insert(2, 55);
        System.out.println(doublyLinkedList);
        Assertions.assertThat(doublyLinkedList.getHead()).isEqualTo(60);
        Assertions.assertThat(doublyLinkedList.getTail()).isEqualTo(4);
        Assertions.assertThat(doublyLinkedList.getLength()).isEqualTo(5);

        doublyLinkedList.remove(1);
        System.out.println(doublyLinkedList);
        Assertions.assertThat(doublyLinkedList.getHead()).isEqualTo(60);
        Assertions.assertThat(doublyLinkedList.getTail()).isEqualTo(4);
        Assertions.assertThat(doublyLinkedList.getLength()).isEqualTo(4);
    }
}