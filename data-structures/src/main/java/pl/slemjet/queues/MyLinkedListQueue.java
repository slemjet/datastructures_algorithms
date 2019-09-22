package pl.slemjet.queues;

import pl.slemjet.linkedlists.MyLinkedList;

public class MyLinkedListQueue<T> {

    private MyLinkedList<T> linkedList;

    public MyLinkedListQueue() {
        linkedList = new MyLinkedList<>();
    }

    public T peek() {
        return linkedList.getHead();
    }

    public void enqueue(T value) {
        linkedList.append(value);
    }

    public T dequeue() {
        T result = linkedList.getHead();
        linkedList.remove(0);
        return result;
    }

    public int getLength() {
        return linkedList.getLength();
    }

    public boolean isEmpty() {
        return linkedList.getLength() <= 0;
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
