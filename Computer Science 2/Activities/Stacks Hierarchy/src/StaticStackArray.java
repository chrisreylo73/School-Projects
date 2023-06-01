/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Activity 11 - StaticStackArray Class
 */

import java.util.EmptyStackException;

public class StaticStackArray<T> extends Stack<T> {

    protected Object data[];
    protected int size;
    public static final int MIN_CAPACITY = 2;

    public StaticStackArray() {
        data = new Object[MIN_CAPACITY];
        size = 0;
    }

    public StaticStackArray(int capacity) {
        if (capacity < MIN_CAPACITY)
            data = new Object[MIN_CAPACITY];
        else
            data = new Object[capacity];
        size = 0;
    }

    @Override
    public void push(final T data) throws StackOverflowError {
        if (size < this.data.length)
            this.data[size++] = data;
        else
            throw new StackOverflowError();
    }

    @Override
    public T pop() throws EmptyStackException {
        if (size > 0) {
            T data = (T) this.data[size - 1];
            size--;
            return data;
        }
        throw new EmptyStackException();
    }

    @Override
    public T peek() throws EmptyStackException {
        if (size > 0)
            return (T) this.data[size - 1];
        throw new EmptyStackException();
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
        String out = "(top)";
        for (int i = size - 1; i >= 0; i--)
            out += " " + (T) data[i];
        out += " (bottom)";
        return out;
    }
}
