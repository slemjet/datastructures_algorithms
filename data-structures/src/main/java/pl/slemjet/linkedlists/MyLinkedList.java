package pl.slemjet.linkedlists;

public class MyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int length = 0;

    public MyLinkedList() {
    }

    public MyLinkedList(T headValue) {
        Node<T> firstNode = new Node<>(headValue, null);
        head = tail = firstNode;
        length = 1;
    }

    public MyLinkedList<T> append(T newValue) {
        if (tail == null) {
            tail = head = new Node<>(newValue, null);
        } else {
            Node<T> newNode = new Node<>(newValue, null);
            tail.next = newNode;
            tail = newNode;
        }
        length++;
        return this;
    }

    public MyLinkedList<T> prepend(T newValue) {
        head = new Node<>(newValue, head);
        if (tail == null) {
            tail = head;
        }
        length++;
        return this;
    }

    public MyLinkedList<T> insert(int index, T newValue) {
        if (index >= length)
            append(newValue);
        else if (index <= 0) {
            prepend(newValue);
        } else {
            Node<T> nodeAtIndex = getNodeAt(head, index - 1);
            Node<T> prevNextNode = nodeAtIndex.next;
            nodeAtIndex.next = new Node<>(newValue, prevNextNode);
            length++;
        }
        return this;
    }

    public MyLinkedList<T> remove(int index) {
        if (index == 0) {
            head = head.getNext();
        } else if (index > 0 && index <= length) {
            Node<T> prevNode = getNodeAt(head, index - 1);
            prevNode.next = prevNode.getNext() != null ? prevNode.getNext().getNext() : null;
            if (index == length - 1) {
                tail = prevNode;
            }
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
        return head != null ? head.getValue() : null;
    }

    public T getTail() {
        return tail != null ? tail.getValue() : null;
    }

    public int getLength() {
        return length;
    }

    private Node<T> getNodeAt(Node<T> start, int index) {
        int i = 0;
        Node<T> nodeAtIndex = start;
        while (i < index && nodeAtIndex != null) {
            nodeAtIndex = nodeAtIndex.next;
            i++;
        }
        return nodeAtIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{head: ").append(getHead())
                .append(", tail: ").append(getTail())
                .append(", length: ").append(getLength()).append("}");
        sb.append("[").append(getHead());
        if (head != null) {
            appendSubNodes(sb, head.getNext());
        }
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
