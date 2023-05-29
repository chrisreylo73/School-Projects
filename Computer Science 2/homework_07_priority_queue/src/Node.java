/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 07 - Node
 */

public class Node {

    private Customer customer;
    private Node     next;

    public Node() {
        customer = null;
        next = null;
    }

    public Node(Customer customer) {
        this.customer = customer;
        next = null;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Node getNext() {
        return next;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return customer.toString();
    }
}