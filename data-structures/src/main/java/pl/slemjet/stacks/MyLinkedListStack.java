package pl.slemjet.stacks;

import pl.slemjet.linkedlists.MyLinkedList;

public class MyLinkedListStack<T> {
    private MyLinkedList<T> linkedList;

    public MyLinkedListStack() {
        this.linkedList = new MyLinkedList<>();
    }

    public T peek() {
        return linkedList.getHead();
    }

    public void push(T value) {
        linkedList.prepend(value);
    }

    public T pop() {
        T head = linkedList.getHead();
        linkedList.remove(0);
        return head;
    }

    public boolean isEmpty() {
        return linkedList.getLength() == 0;
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
