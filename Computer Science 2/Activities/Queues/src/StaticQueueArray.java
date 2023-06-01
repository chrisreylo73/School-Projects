/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Activity 12 - StaticQueueArray Class
 */

import java.util.NoSuchElementException;

public class StaticQueueArray<T> extends Queue<T> {

    protected Object data[];
    protected int size;
    protected int front;
    private static final int MIN_CAPACITY = 2;

    public StaticQueueArray(int capacity) {
        if (capacity < MIN_CAPACITY)
            data = new Object[MIN_CAPACITY];
        else
            data = new Object[capacity];
        size = 0;
        front = 0;
    }

    public StaticQueueArray() {
        this(MIN_CAPACITY);
    }

    // TODO: implement the method
    @Override
    public void push(final T data) throws QueueOverflowError {
        if (size < this.data.length) {
            int rear = (front + size)%this.data.length;
            this.data[rear] = rear;
            size++;
        }
    }

    // TODO: implement the method
    @Override
    public T pop() throws NoSuchElementException {
        if(size > 0) {
            T data = (T) this.data[front];
            front = (front + 1) % this.data.length;
            size--;
            return data;
        }
        throw new NoSuchElementException();
    }

    // TODO: implement the method
    @Override
    public T peek() throws NoSuchElementException {
        if(size > 0) {
            T data = (T) this.data[front];
            return data;
        }
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == this.data.length;
    }

    @Override
    public String toString() {
        String out = "(front)";
        int current = front;
        for (int i = 0; i < size; i++) {
            out += " " + data[current];
            current = (current + 1) % this.data.length;
        }
        out += " (hear)";
        return out;
    }
}