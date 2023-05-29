/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 20 - LinkedList class
 */

public class LinkedList<T> {

    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    // add in front
    public void add(T data) {
        Node<T> newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
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

    public void set(int index, T data) {
        if (index < 0 || index >= size())
            return;
        int i = 0;
        Node<T> current = head;
        while (i < index) {
            i++;
            current = current.getNext();
        }
        current.setData(data);
    }

    void insert(int index, T data) {
        if (index < 0 || index >= size())
            return;
        if (index == 0)
            add(data);
        else {
            Node<T> newNode = new Node(data);
            int i = 0;
            Node<T> current = head;
            while (i < index - 1) {
                i++;
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
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

    void clear() {
        Node current = head;
        while (current != null) {
            Node temp = current.getNext();
            current.setNext(null);
            current = temp;
        }
        head = null;
    }
}