package pl.slemjet.algorithms.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.slemjet.trees.binary.MyBinarySearchTree;

//          9
//       /     \
//      4       20
//    /   \    /   \
//   1     6  15   170
class TreeTraverserTest {

    @Test
    void testRecursion1() {
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);

        // when
        Object[] result = TreeTraverser.breadthFirstSearchRecursion1(tree);

        // then
        Assertions.assertThat(result).isEqualTo(new Integer[]{9, 4, 20, 1, 6, 15, 170});
    }

    @Test
    void testRecursion2() {
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);

        // when
        Object[] result = TreeTraverser.breadthFirstSearchRecursion2(tree);

        // then
        Assertions.assertThat(result).isEqualTo(new Integer[]{9, 4, 20, 1, 6, 15, 170});
    }

    @Test
    void testLoop() {
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);

        // when
        Object[] result = TreeTraverser.breadthFirstSearchLoop(tree);

        // then
        Assertions.assertThat(result).isEqualTo(new Integer[]{9, 4, 20, 1, 6, 15, 170});
    }
}