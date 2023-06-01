/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 07 - StaticStack
 */

public class StaticStack {

    private int capacity;
    private int data[]; // assume index = 0 is the bottom
    public static final int MIN_CAPACITY = 2;
    private int size;

    public StaticStack() {
        this.capacity = MIN_CAPACITY;
        data = new int[this.capacity];
        size = 0;
    }

    public StaticStack(int capacity) {
        if (capacity < MIN_CAPACITY)
            this.capacity = MIN_CAPACITY;
        else
            this.capacity = capacity;
        data = new int[this.capacity];
        size = 0;
    }

    // TODOd: push data onto the stack (if no space is available, do nothing or throw an exception)
    public void push(int data) {
        if(size < capacity){
            this.data[size] = data;
            size++;
        }
    }

    // TODO: peek just returns the element on top of the stack but does not remove it;
    // if the stack is empty, return 0 or throw an exception
    public int peek() {
        if(size > 0){
            int data = this.data[size-1];
            return data;
        }
        return 0; // placeholder
    }

    // TODO: pop returns the element on top of the stack, also removing it
    // if the stack is empty, return 0 or throw an exception
    public int pop() {
        if(size > 0){
            int data = this.data[size-1];
            size--;
            return data;
        }
        return 0; // placeholder
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    // TODO: implement isEmpty
    public boolean isEmpty() {
        return size == 0; // placeholder
    }

    public boolean isFull() { return size == capacity; }

    @Override
    public String toString() {
        String out = "(top)";
        for (int i = size - 1; i >= 0; i--)
            out += " " + data[i];
        out += " (bottom)";
        return out;
    }
}
