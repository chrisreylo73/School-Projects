/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 23 - Node class
 */

public class Node {

    private String  data;
    private Node   next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(String data) {
        this.data = data;
        next = null;
    }

    public String getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data;
    }
}