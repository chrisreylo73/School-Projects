/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 05 - DynamicStack
 */

public class DynamicStack {

    private Node top;

    public DynamicStack() {
        top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
    }

    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public String toString() {
        String out = "(top)";
        Node current = top;
        while (current != null) {
            out += " " + current.toString();
            current = current.getNext();
        }
        out += " (bottom)";
        return out;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty())
            return 0;
        return top.getData();
    }

    public int pop() {
        if (isEmpty())
            return 0;
        int data = top.getData();
        Node newTop = top.getNext();
        top.setNext(null);
        top = newTop;
        return data;
    }
}
