/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 05 - LinkedList (of integers)
 */

public class LinkedList {

    private Node head;// pointer to where the head of the list is

    public LinkedList() {
        head = null;
    }// constructor setting head to null. This means the list is empty at first.

    // TODOd: add in front
    public void add(int data) {
        Node newNode = new Node(data);// creates the object that must contain data
        newNode.setNext(head);// Think of it like this.newNode sets its pointer to head.head is now assigned
                              // to where new node is. newNode --> head, head = newNode, head -->
                              // lastNodeAdded
        head = newNode;
    }

    // TODOd: add at the tail
    public void append(int data) {
        Node newNode = new Node(data);
        if (isEmpty())// calls method isEmpty() to check if the LinkedList is empty.
            head = newNode;// if it is empty make the first Node the head.
        else {
            Node current = head;// assigns pointer named current to the head.
            while (current.getNext() != null)// while the pointer current is not pointing to null.
                current = current.getNext();//
            current.setNext(newNode);
        }
    }

    // TODOd: toString override
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

    // TODOd: return true if the list is empty, false otherwise
    public boolean isEmpty() {
        return head == null;
    }

    // TODOd: return the number of elements of the list
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // TODOd: return the element at the given index location (if index is invalid,
    // just return 0 or throw an exception)
    public int get(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size()) {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.getNext();
                i++;
            }
            return current.getData();
        }
        throw new IndexOutOfBoundsException();
    }

    // TODOd: change the element at the given index location (if index is invalid,
    // do nothing or throw an exception)
    public void set(int index, int data) {
        if (index >= 0 && index < size()) {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.getNext();
                i++;
            }
            current.setData(data);
        } else
            throw new IndexOutOfBoundsException();
    }

    // TODOd: insert the element at the given index location (if the index is
    // invalid, do nothing)
    void insert(int index, int data) {
        if (index > 0 && index < size()) {
            Node newNode = new Node(data);
            Node current = head;
            int i = 0;
            while (i < index - 1) {
                current = current.getNext();
                i++;
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        else if (index == 0)
            add(data);
        else
            throw new N
    }

    // TODO: remove the element at the given index location (if the index is
    // invalid, do nothing)
    void remove(int index) {

    }
}
