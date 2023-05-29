/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - DoublyLinkedList
 */

package p2;

// In a doubly linked list, each node points not only to the next node but also to the previous one
public class DoublyLinkedList {

    private Node head, tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    // TODO: return true when the list is empty, false otherwise
    public boolean isEmpty() {
        return false;
    }

    // TODO: add a new node with data in front of the list, making it the new head
    public void add(int data) {

    }

    // TODO: add a new node with data at the end of the list, making it the new tail
    public void append(int data) {

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

    // TODO: return a String representation of the list, similar to toString, but with a reverse order tail to head
    public String toStringBackwards() {
        return "";
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
            newNode.setPrevious(current);
            if (current.getNext() != null)
                current.getNext().setPrevious(newNode);
            current.setNext(newNode);
        }
    }

    void remove(int index) {
        if (index < 0 || index >= size())
            return;
        if (index == 0) {
            if (head == tail) {
                head.setNext(null);
                head.setPrevious(null);
                head = tail = null;
            }
            else {
                Node toBeRemoved = head;
                head = head.getNext();
                head.setPrevious(null);
                toBeRemoved.setNext(null);
                toBeRemoved.setPrevious(null);
            }
        }
        else {
            int i = 0;
            Node current = head;
            while (i < index - 1) {
                i++;
                current = current.getNext();
            }
            Node toBeRemoved = current.getNext();
            current.setNext(toBeRemoved.getNext());
            if (toBeRemoved == tail)
                tail = current;
            else
                toBeRemoved.getNext().setPrevious(current);
            toBeRemoved.setNext(null);
            toBeRemoved.setPrevious(null);
        }
    }
}
