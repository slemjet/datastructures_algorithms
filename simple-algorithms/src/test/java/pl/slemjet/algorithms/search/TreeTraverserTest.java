package pl.slemjet.algorithms.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.slemjet.trees.binary.MyBinarySearchTree;

class TreeTraverserTest {

    @Test
    void test() {
        //          9
        //       /     \
        //      4       20
        //    /   \    /   \
        //   1     6  15   170
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);

        // when
        Object[] result = TreeTraverser.breadthFirstSearch(tree);

        // then
        Assertions.assertThat(result).isEqualTo(new Integer[]{9, 4, 20, 1, 6, 15, 170});
    }

    @Test
    void test2() {
        //          9
        //       /     \
        //      4       20
        //    /   \    /   \
        //   1     6  15   170
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);

        // when
        Object[] result = TreeTraverser.breadthFirstSearch2(tree);

        // then
        Assertions.assertThat(result).isEqualTo(new Integer[]{9, 4, 20, 1, 6, 15, 170});
    }
}