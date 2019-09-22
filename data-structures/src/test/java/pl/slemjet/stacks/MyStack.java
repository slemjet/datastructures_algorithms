package pl.slemjet.stacks;

public class MyStack<T> {

    private Node<T> top;
    private Node<T> bottom;
    private int length = 0;

    public T peek() {
        return top != null ? top.getValue() : null;
    }

    public void push(T value) {
        if (top == null) {
            top = bottom = new Node<>(value);
        } else {
            top = new Node<T>(value, top);
        }
        length++;
    }

    public T pop() {
        T result = null;
        if (top != null) {
            result = top.getValue();
            top = top.getNext();
            if (top == null) {
                bottom = null;
            }
            length--;
        }
        return result;
    }

    public boolean isEmpty() {
        return length <= 0;
    }

    public T getTop() {
        return top != null ? top.getValue() : null;
    }

    public T getBottom() {
        return bottom != null ? bottom.getValue() : null;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{top: ").append(getTop())
                .append(", bottom: ").append(getBottom())
                .append(", length: ").append(getLength()).append("}");
        sb.append("[").append(getTop());
        if (top != null) {
            appendSubNodes(sb, top.getNext());
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
