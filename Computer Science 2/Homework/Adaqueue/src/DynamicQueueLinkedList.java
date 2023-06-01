/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Homework 06 - DynamicQueueLinkedList Class
 */

import java.util.NoSuchElementException;

public class DynamicQueueLinkedList<T> extends Queue<T> {

    private Node<T> front, rear;

    public DynamicQueueLinkedList() {
        front = rear = null;
    }

    // TODOd: implement the method
    @Override
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty())
            front = rear = newNode;
        else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    // TODOd: push the given element to the front of the queue
    @Override
    public void pushToFront(T data){
        Node<T> newNode = new Node<>(data);
        if (isEmpty()){
            front = rear = newNode;
        }
        else {
            newNode.setNext(front);
            front = newNode;
        }
        
    }

    // TODOd: implement the method
    @Override
    public T pop() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        T data = front.getData();
        Node<T> temp = front;
        front = front.getNext();
        if (front == null)
            rear = null;
        temp.setNext(null);
        return data;
    }

    // TODOd: pop from the back of the queue
    @Override
    public T popFromBack() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else if(front == rear){
            front = rear = null;
        }
        else {
            Node<T> current = front;
            Node<T> previous = null;
            while(current != rear);{
                previous = current;
                current = current.getNext();
            }
            previous.setNext(null);
            rear = previous;
            return current.getData();
        }
        return null; // this is a placeholder
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        return front.getData();
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> current = front;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public void reverse() {
        if (isEmpty())
            return;
        Node<T> current = front;
        Node<T> previous = null;
        Node<T> temp = null;
        while (current != null) {
            temp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = temp;
        }
        temp = front;
        front = rear;
        rear = temp;
    }

    @Override
    public String toString() {
        String out = "(front)";
        Node current = front;
        while (current != null) {
            out += " " + current.toString();
            current = current.getNext();
        }
        out += " (rear)";
        return out;
    }
}
