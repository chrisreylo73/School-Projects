/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 25 - Target class
 */

public class Target extends DecisionTreeData {

    private int value;

    public Target(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" +
                "target = " + value +
                '}';
    }
}
