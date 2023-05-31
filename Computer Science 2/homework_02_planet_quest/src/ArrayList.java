/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 02 - ArrayList Class
 */

public class ArrayList {

    private static Planet data[];
    private int size;
    private static int INCREMENT_SIZE = 5;

    public ArrayList() {
        data = new Planet[INCREMENT_SIZE];
        size = 0;
    }

    public void add(Planet value) {
        if (size == data.length) {
            Planet newData[] = new Planet[size + INCREMENT_SIZE];
            for (int i = 0; i < data.length; i++)
                newData[i] = data[i];
            data = newData;
        }
        data[size++] = value;
    }

    public Planet get(int index) {
        if (index < 0 || index >= size)
            return null;
        return data[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++)
            str += data[i] + " ";
        return str;
    }
}
