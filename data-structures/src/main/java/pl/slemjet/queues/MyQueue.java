package pl.slemjet.queues;

public class MyQueue<T> {
    private Node<T> first = null;
    private Node<T> last = null;
    private int length = 0;

    public MyQueue() {
    }

    public T peek() {
        return last != null ? last.getValue() : null;
    }

    public void enqueue(T value) {
        if (first == null) {
            first = last = new Node<>(value);
        } else {
            Node<T> newValue = new Node<>(value);
            last.setNext(newValue);
            last = newValue;
        }
        length++;
    }

    public T dequeue() {
        if (last == null) {
            return null;
        }
        if (last == first) {
            Node<T> result = this.last;
            first = last = null;
            length--;
            return result.getValue();
        } else {
            Node<T> next = first;
            first = first.getNext();
            length--;
            return next.getValue();
        }
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length <= 0;
    }

    public T getFirst() {
        return first != null ? first.getValue() : null;
    }

    public T getLast() {
        return last != null ? last.getValue() : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{head: ").append(getFirst())
                .append(", tail: ").append(getLast())
                .append(", length: ").append(getLength()).append("}");
        sb.append("[").append(getFirst());
        if (first != null) {
            appendSubNodes(sb, first.getNext());
        }
        sb.append("]");
        return sb.toString();
    }

    void appendSubNodes(StringBuilder sb, Node node) {
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
