package pl.slemjet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class MyArrayTest {
    @Test
    void testAppend() {
        MyArray<Integer> array = new MyArray(new Integer[]{1, 2, 3});
        System.out.println(array);
        Assertions.assertThat(array.get(100)).isNull();

        System.out.println(array.get(1));
        Assertions.assertThat(array.get(1)).isEqualTo(2);

        array.append(5);
        System.out.println(array);
        Assertions.assertThat(array.get(3)).isEqualTo(5);

        array.append(8);
        System.out.println(array);
        Assertions.assertThat(array.get(4)).isEqualTo(8);
    }

    @Test
    void testPop() {
        MyArray<Integer> array = new MyArray(IntStream.range(0, 10).boxed().toArray());
        System.out.println(array);

        Integer pop = array.pop();
        System.out.println(pop);
        Assertions.assertThat(pop).isEqualTo(9);

        System.out.println(array);
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        array.pop();
        Integer pop1 = array.pop();
        System.out.println(array);
        Assertions.assertThat(pop1).isEqualTo(3);
        Assertions.assertThat(array.get(9)).isNull();
    }

    @Test
    void testRemove() {
        MyArray<Integer> array = new MyArray(IntStream.range(0, 10).boxed().toArray());
        System.out.println(array);

        array.remove(100);
        System.out.println(array);
        Assertions.assertThat(array.get(9)).isNotNull();

        array.remove(2);
        System.out.println(array);
        Assertions.assertThat(array.get(9)).isNull();

        array.remove(2);
        array.remove(2);
        array.remove(2);
        array.remove(2);
        array.remove(2);
        System.out.println(array);
        Assertions.assertThat(array.get(2)).isEqualTo(8);
    }
}