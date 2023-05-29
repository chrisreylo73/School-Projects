/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 08 - LinkedList
 */

public class LinkedList<T> {

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

    public T get(int index) {
        if (index < 0 || index >= size())
            return null;
        int i = 0;
        Node<T> current = head;
        while (i < index) {
            i++;
            current = current.getNext();
        }
        return current.getData();
    }

    void remove(int index) {
        if (index < 0 || index >= size())
            return;
        if (index == 0) {
            Node<T> temp = head;
            head = head.getNext();
            temp.setNext(null);
        }
        else {
            int i = 0;
            Node<T> current = head;
            while (i < index - 1) {
                i++;
                current = current.getNext();
            }
            Node<T> temp = current.getNext();
            current.setNext(current.getNext().getNext());
            temp.setNext(null);
        }
    }
}