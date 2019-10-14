package pl.slemjet.algorithms.search;

import pl.slemjet.trees.binary.MyBinarySearchTree;
import pl.slemjet.trees.binary.MyBinarySearchTree.Node;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public static <T extends Comparable<T>> Object[] traverseInOrder(MyBinarySearchTree<T> tree) {
        List<T> result = new ArrayList<>();
        traverseInOrder(tree.getRoot(), result);
        return result.toArray();
    }

    // Expected [1, 4, 6, 9, 15, 20, 170]
    private static <T extends Comparable<T>> void traverseInOrder(Node node, List<T> result) {
        if (node == null)
            return;
        if (node.getLeft() != null) {
            traverseInOrder(node.getLeft(), result);
        }
        result.add((T) node.getValue());
        if (node.getRight() != null) {
            traverseInOrder(node.getRight(), result);
        }
    }

    public static <T extends Comparable<T>> Object[] traversePreOrder(MyBinarySearchTree<T> tree) {
        List<T> result = new ArrayList<>();
        traversePreOrder(tree.getRoot(), result);
        return result.toArray();
    }

    // Expected [9, 4, 1, 6, 20, 15, 170]
    private static <T extends Comparable<T>> void traversePreOrder(Node node, List<T> result) {
        if (node == null)
            return;
        result.add((T) node.getValue());
        if (node.getLeft() != null) {
            traversePreOrder(node.getLeft(), result);
        }
        if (node.getRight() != null) {
            traversePreOrder(node.getRight(), result);
        }
    }

    public static <T extends Comparable<T>> Object[] traversePostOrder(MyBinarySearchTree<T> tree) {
        List<T> result = new ArrayList<>();
        traversePostOrder(tree.getRoot(), result);
        return result.toArray();
    }

    // Expected [1, 6, 4, 15, 170, 20, 9]
    private static <T extends Comparable<T>> void traversePostOrder(Node node, List<T> result) {
        if (node == null)
            return;
        if (node.getLeft() != null) {
            traversePostOrder(node.getLeft(), result);
        }
        if (node.getRight() != null) {
            traversePostOrder(node.getRight(), result);
        }
        result.add((T) node.getValue());
    }
}
