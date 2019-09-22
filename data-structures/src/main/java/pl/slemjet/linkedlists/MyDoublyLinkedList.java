package pl.slemjet.linkedlists;

public class MyDoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public MyDoublyLinkedList(T value) {
        this.head = this.tail = new Node<T>(value);
        length = 1;
    }

    public MyDoublyLinkedList<T> append(T value) {
        Node<T> newNode = new Node<>(value, null, tail);
        tail.next = newNode;
        tail = newNode;
        length++;
        return this;
    }

    public MyDoublyLinkedList<T> prepend(T value) {
        Node<T> newNode = new Node<>(value, head, null);
        head.previous = newNode;
        head = newNode;
        length++;
        return this;
    }

    public MyDoublyLinkedList<T> insert(int index, T newValue) {
        if (index >= length)
            append(newValue);
        else if (index <= 0) {
            prepend(newValue);
        } else {
            Node<T> leader = getNodeAt(index - 1);
            Node<T> follower = leader.next;
            leader.next = new Node<T>(newValue, follower, leader);
            length++;
        }
        return this;
    }

    public MyDoublyLinkedList<T> remove(int index) {
        if (index >= 0 && index <= length) {
            Node<T> leader = getNodeAt(index - 1);
            Node<T> nextFollower = leader.next.next;
            leader.next = nextFollower;
            nextFollower.previous = leader;
        }
        length--;
        return this;
    }

    public T getHead() {
        return head.getValue();
    }

    public T getTail() {
        return tail.getValue();
    }

    public int getLength() {
        return length;
    }

    private Node<T> getNodeAt(int index) {
        int i = 0;
        Node<T> nodeAtIndex = head;
        while (i < index && nodeAtIndex != null) {
            nodeAtIndex = nodeAtIndex.next;
            i++;
        }
        return nodeAtIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{head: ").append(head.getValue())
                .append(", tail: ").append(tail.getValue())
                .append(", length: ").append(length).append("}");
        sb.append("[").append(head.getValue());
        appendSubNodes(sb, head.getNext());
        sb.append("]");
        return sb.toString();
    }

    private void appendSubNodes(StringBuilder sb, Node node) {
        if (node != null) {
            sb.append(" <-> ").append(node.getValue());
            appendSubNodes(sb, node.getNext());
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
            this.next = this.previous = null;
        }

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
