package pl.slemjet.algorithms.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.slemjet.trees.binary.MyBinarySearchTree;

//          9
//       /     \
//      4       20
//    /   \    /   \
//   1     6  15   170
class DepthFirstSearchTest {

    @Test
        // Expected [1, 4, 6, 9, 15, 20, 170]
    void searchInOrder() {
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);

        // when
        Object[] result = DepthFirstSearch.traverseInOrder(tree);

        // then
        Assertions.assertThat(result).isEqualTo(new Integer[]{1, 4, 6, 9, 15, 20, 170});
    }

    @Test
        // Expected [9, 4, 1, 6, 20, 15, 170]
    void searchPreOrder() {
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);

        // when
        Object[] result = DepthFirstSearch.traversePreOrder(tree);

        // then
        Assertions.assertThat(result).isEqualTo(new Integer[]{9, 4, 1, 6, 20, 15, 170});
    }

    @Test
        // Expected [1, 6, 4, 15, 170, 20, 9]
    void searchPostOrder() {
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);

        // when
        Object[] result = DepthFirstSearch.traversePostOrder(tree);

        // then
        Assertions.assertThat(result).isEqualTo(new Integer[]{1, 6, 4, 15, 170, 20, 9});
    }
}