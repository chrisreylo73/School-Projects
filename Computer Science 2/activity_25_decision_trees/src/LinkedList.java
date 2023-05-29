/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 25 - LinkedList class
 */

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    // add tail
    public void append(T data) {
        Node<T> newNode = new Node(data);
        if (isEmpty())
            head = newNode;
        else {
            Node<T> current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(newNode);
        }
    }

    public T getFirst() {
        if (head == null)
            return null;
        return head.getData();
    }

    @Override
    public String toString() {
        String out = "";
        Node<T> current = head;
        while (current != null) {
            out += current.toString() + " ";
            current = current.getNext();
        }
        return out;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null)
            if (current.getData().equals(data))
                return true;
            else
                current = current.getNext();
        return false;
    }

    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> temp = current;
            current = current.getNext();
            temp.setNext(null);
        }
        head = null;
    }

    public void remove(final T data) {
        if (head == null)
            return;
        if (head.getData().equals(data)) {
            Node<T> temp = head;
            head = head.getNext();
            temp.setNext(null);
            return;
        }
        Node<T> previous = null;
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                previous.setNext(current.getNext());
                current.setNext(null);
                return;
            }
            else {
                previous = current;
                current = current.getNext();
            }
        }
    }

    @Override
    public Object clone() {
        LinkedList<T> clone = new LinkedList<>();
        Node<T> current = head;
        while (current != null) {
            clone.append(current.getData());
            current = current.getNext();
        }
        return clone;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current != null) {
                    T data = current.getData();
                    current = current.getNext();
                    return data;
                }
                return null;
            }
        };
    }
}