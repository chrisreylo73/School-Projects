/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 04 - ArrayList (of integers)
 */

public class ArrayList {

    private static int data[];
    private int size;
    private static int INCREMENT_SIZE = 5;

    public ArrayList() {
        data = new int[INCREMENT_SIZE];
        size = 0;
    }

    // TODO: implement the method
    public void add(int value) {

    }

    // TODO: implement the method
    public int get(int index) {
        return 0;
    }

    // TODO: implement the method
    public boolean isEmpty() {
        return false;
    }

    // TODO: implement the method
    public int size() {
        return 0;
    }

    // TODO: implement the method
    public void remove(int index) {

    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++)
            str += data[i] + " ";
        return str;
    }
}
