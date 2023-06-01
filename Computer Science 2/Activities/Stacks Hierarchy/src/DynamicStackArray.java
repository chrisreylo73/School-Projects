/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Activity 11 - DynamicStackArray Class
 */

public class DynamicStackArray<T> extends StaticStackArray<T> {

    public static final int CAPACITY_INCREMENT = 5;

    public DynamicStackArray() {
        super();
    }

    public DynamicStackArray(int capacity) {
        super(capacity);
    }

    @Override
    public void push(T data) {
        if (size == this.data.length) {
            Class<T> t = null;
            Object newData[] = new Object[this.data.length + CAPACITY_INCREMENT];
            for (int i = 0; i < this.data.length; i++)
                newData[i] = this.data[i];
            this.data = newData;
        }
        super.push(data);
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
