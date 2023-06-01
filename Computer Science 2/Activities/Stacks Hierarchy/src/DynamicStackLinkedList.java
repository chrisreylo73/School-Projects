/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Activity 11 - DynamicStackLinkedList Class
 */

import java.util.EmptyStackException;

public class DynamicStackLinkedList<T> extends Stack<T> {

    private Node<T> top;

    public DynamicStackLinkedList() {
        top = null;
    }

    @Override
    public void push(final T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(top);
        top = newNode;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        T data = top.getData();
        Node<T> temp = top;
        top = top.getNext();
        temp.setNext(null);
        return data;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return top.getData();
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> current = top;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        String out = "(top)";
        Node<T> current = top;
        while (current != null) {
            out += " " + current.toString();
            current = current.getNext();
        }
        out += " (bottom)";
        return out;
    }
}