/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Activity 12 - Queue Class
 */

import java.util.NoSuchElementException;

public abstract class Queue<T> {

    public abstract void push(final T data);

    public abstract T pop() throws NoSuchElementException;

    public abstract T peek() throws NoSuchElementException;

    public abstract int size();

    public abstract boolean isEmpty();

}