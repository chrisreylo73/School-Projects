/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - Node
 */

package p2;

public class Node {

    private int  data;
    private Node next, previous;

    public Node() {
        this.data = 0;
        next = previous = null;
    }

    public Node(int data) {
        this.data = data;
        next = previous = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
