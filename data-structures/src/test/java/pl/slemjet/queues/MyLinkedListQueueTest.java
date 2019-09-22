package pl.slemjet.queues;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyLinkedListQueueTest {
    @Test
    void name() {
        //given
        MyLinkedListQueue<String> queue = new MyLinkedListQueue<>();

        //when
        Assertions.assertThat(queue.isEmpty()).isTrue();
        System.out.println(queue);
        queue.enqueue("Joy");
        queue.enqueue("Matt");
        queue.enqueue("Pavel");
        queue.enqueue("Samir");
        Assertions.assertThat(queue.isEmpty()).isFalse();
        System.out.println(queue);

        Assertions.assertThat(queue.dequeue()).isEqualTo("Joy");
        Assertions.assertThat(queue.getLength()).isEqualTo(3);
        System.out.println(queue);

    }
}