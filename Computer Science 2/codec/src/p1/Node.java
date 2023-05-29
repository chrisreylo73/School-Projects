/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - Node
 */

package p1;

public class Node {

    private int  id;
    private Node next;

    public Node(int id) {
        this.id = id;
        next = null;
    }

    public int getId() {
        return id;
    }

    public Node getNext() {
        return next;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return id + "";
    }

    @Override
    public boolean equals(Object obj) {
        Node other = (Node) obj;
        return id == other.id;
    }
}