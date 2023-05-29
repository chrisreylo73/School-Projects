/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Activity 11 - Stack Class
 */

import java.util.EmptyStackException;

public abstract class Stack<T> {

    public abstract void push(final T data);

    public abstract T pop() throws EmptyStackException ;

    public abstract T peek() throws EmptyStackException;

    public abstract int size();

    public abstract boolean isEmpty();

}
