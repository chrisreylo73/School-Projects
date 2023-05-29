/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - LinkedList
 */

package p3;

// a singly linked list with nodes carrying integers
public class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }

    // add in front
    public void add(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    // add tail
    public void append(int data) {
        Node newNode = new Node(data);
        if (isEmpty())
            head = newNode;
        else {
            Node current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(newNode);
        }
    }

    @Override
    public String toString() {
        String out = "";
        Node current = head;
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
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public int get(int index) {
        if (index < 0 || index >= size())
            return 0;
        int i = 0;
        Node current = head;
        while (i < index) {
            i++;
            current = current.getNext();
        }
        return current.getData();
    }

    public void set(int index, int data) {
        if (index < 0 || index >= size())
            return;
        int i = 0;
        Node current = head;
        while (i < index) {
            i++;
            current = current.getNext();
        }
        current.setData(data);
    }

    void insert(int index, int data) {
        if (index < 0 || index >= size())
            return;
        if (index == 0)
            add(data);
        else {
            Node newNode = new Node(data);
            int i = 0;
            Node current = head;
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
            Node temp = head;
            head = head.getNext();
            temp.setNext(null);
        }
        else {
            int i = 0;
            Node current = head;
            while (i < index - 1) {
                i++;
                current = current.getNext();
            }
            Node temp = current.getNext();
            current.setNext(current.getNext().getNext());
            temp.setNext(null);
        }
    }

    // TODO: return a static array with all of the elements of the list, respecting its order; return null if the list is empty
    public int[] toArray() {
        return new int[0];
    }
}
