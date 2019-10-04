package pl.slemjet.graphs;

import java.util.*;

public class MyGraph<T extends Comparable> {

    private int numberOfNodes;
    private Map<T, Set<T>> adjacentList;

    public MyGraph() {
        numberOfNodes = 0;
        adjacentList = new HashMap<>();
    }

    public void addVertex(T value) {
        if (!adjacentList.containsKey(value)) {
            adjacentList.put(value, new HashSet<>());
            numberOfNodes++;
        }
    }

    public void addEdge(T value1, T value2) {
        addNodes(value1, value2);
        addNodes(value2, value1);
    }

    private void addNodes(T value1, T value2) {
        if (!adjacentList.containsKey(value1)) {
            adjacentList.put(value1, new HashSet<T>(Arrays.asList(value2)));
        } else {
            adjacentList.get(value1).add(value2);
        }
    }

    public void addEdges(T value1, T... value2) {
        for (T value : value2) {
            addEdge(value1, value);
        }
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<T, Set<T>> entry : adjacentList.entrySet()) {
            sb.append("[ ").append(entry.getKey()).append(": ");
            for (T value : entry.getValue()) {
                sb.append(value).append(" ");
            }
            sb.append("]").append("\n");
        }
        return sb.toString();
    }

    class Node<T extends Comparable> implements Comparable {
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        @Override
        public int compareTo(Object o) {
            return getValue().compareTo(((Node<T>) o).getValue());
        }
    }
}
