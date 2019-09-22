package pl.slemjet.linkedlists;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length = 0;

    public MyLinkedList(T headValue) {
        Node<T> firstNode = new Node<>(headValue, null);
        head = tail = firstNode;
        length = 1;
    }

    public MyLinkedList<T> append(T newValue) {
        Node<T> newNode = new Node<>(newValue, null);
        tail.next = newNode;
        this.tail = newNode;
        length++;
        return this;
    }

    public MyLinkedList<T> prepend(T newValue) {
        this.head = new Node<>(newValue, head);
        length++;
        return this;
    }

    public MyLinkedList<T> insert(int index, T newValue) {
        if (index >= length)
            append(newValue);
        else if (index <= 0) {
            prepend(newValue);
        } else {
            Node<T> nodeAtIndex = getNodeAt(index - 1);
            Node<T> prevNextNode = nodeAtIndex.next;
            nodeAtIndex.next = new Node<>(newValue, prevNextNode);
            length++;
        }
        return this;
    }

    public MyLinkedList<T> remove(int index) {
        if (index >= 0 && index <= length) {
            Node<T> prevNode = getNodeAt(index - 1);
            Node<T> nextNode = prevNode.next.next;
            prevNode.next = nextNode;
        }
        length--;
        return this;
    }

    public MyLinkedList<T> reverse() {

        Node<T> first = head;
        Node<T> second = head.getNext();
        tail = head;
        while (second != null) {
            Node<T> tmp = second.getNext();
            second.setNext(first);
            first = second;
            second = tmp;
        }
        tail.setNext(null);
        head = first;
        return this;
    }

    public MyLinkedList<T> reverse2() {
        MyLinkedList<T> reversed = new MyLinkedList<>(head.getValue());
        Node<T> next = head.getNext();
        while (next != null) {
            reversed.prepend(next.getValue());
            next = next.getNext();
        }
        head = reversed.head;
        tail = reversed.tail;
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

    void appendSubNodes(StringBuilder sb, MyLinkedList.Node node) {
        if (node != null) {
            sb.append(" -> ").append(node.getValue());
            appendSubNodes(sb, node.getNext());
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
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
    }
}
