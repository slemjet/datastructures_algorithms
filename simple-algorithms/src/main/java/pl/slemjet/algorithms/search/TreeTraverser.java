package pl.slemjet.algorithms.search;

import pl.slemjet.trees.binary.MyBinarySearchTree;
import pl.slemjet.trees.binary.MyBinarySearchTree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class TreeTraverser {

    public static <T extends Comparable<T>> Object[] breadthFirstSearch(MyBinarySearchTree<T> tree) {

        List<T> result = new ArrayList<>();

        Node root = tree.getRoot();
        getNodeLevel(result, List.of(root));

        return result.stream().toArray();
    }

    private static void getNodeLevel(List result, List<Node> nodes) {

        for (Node node : nodes)
            result.add(node.getValue());

        List<Node> subNodes = getSubNodes(nodes);

        if (subNodes != null && subNodes.size() > 0) {
            getNodeLevel(result, subNodes);
        }

        return;
    }

    private static List<Node> getSubNodes(List<Node> nodes) {
        List<Node> subNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node.getLeft() != null)
                subNodes.add(node.getLeft());
            if (node.getRight() != null)
                subNodes.add(node.getRight());
        }
        return subNodes;
    }


    public static <T extends Comparable<T>> Object[] breadthFirstSearch2(MyBinarySearchTree<T> tree) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Comparable> result = new ArrayList<>();

        Node currentNode = tree.getRoot();
        queue.add(currentNode);

        while (!queue.isEmpty()){
            currentNode = queue.poll();
            result.add(currentNode.getValue());

            if (currentNode.getLeft() != null)
                queue.add(currentNode.getLeft());
            if (currentNode.getRight() != null)
                queue.add(currentNode.getRight());
        }

        return result.stream().toArray();
    }
}
