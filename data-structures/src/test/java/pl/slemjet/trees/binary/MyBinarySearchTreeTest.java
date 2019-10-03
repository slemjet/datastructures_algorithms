package pl.slemjet.trees.binary;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyBinarySearchTreeTest {

    @Test
    void testInsert() {
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();
        tree.insert(9);
        tree.insert(4);
        tree.insert(1);
        tree.insert(6);
        tree.insert(20);
        tree.insert(15);
        tree.insert(170);

        // when
        MyBinaryTreePrinter.printNode(tree.getRoot());

        // then
        Assertions.assertThat(tree.lookup(9)).isNotNull();
        Assertions.assertThat(tree.lookup(9).getValue()).isEqualTo(9);
        Assertions.assertThat(tree.lookup(6).getValue()).isEqualTo(6);
        Assertions.assertThat(tree.lookup(7)).isNull();
    }

    @Test
    void testDeleteBalanced() {
        // given
        MyBinarySearchTree<Integer> tree0 = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);
        MyBinarySearchTree<Integer> tree1 = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);
        MyBinarySearchTree<Integer> tree2 = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);
        MyBinarySearchTree<Integer> tree3 = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170);

        // when
        tree0.remove(9);
        tree1.remove(6);
        tree2.remove(4);
        tree3.remove(20);
        MyBinaryTreePrinter.printNode(tree0.getRoot());
        MyBinaryTreePrinter.printNode(tree1.getRoot());
        MyBinaryTreePrinter.printNode(tree2.getRoot());
        MyBinaryTreePrinter.printNode(tree3.getRoot());

        // then
        Assertions.assertThat(tree0.lookup(9)).isNull();
        Assertions.assertThat(tree1.lookup(6)).isNull();
        Assertions.assertThat(tree2.lookup(4)).isNull();
        Assertions.assertThat(tree3.lookup(20)).isNull();
    }

    @Test
    void testDeleteUnBalanced() {
        // given
        MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>(9, 4, 1, 6, 20, 15, 170, 190);

        // when
        MyBinaryTreePrinter.printNode(tree.getRoot());
        tree.remove(170);
        MyBinaryTreePrinter.printNode(tree.getRoot());

        // then
        Assertions.assertThat(tree.lookup(170)).isNull();
        Assertions.assertThat(tree.lookup(190)).isNotNull();
    }
}