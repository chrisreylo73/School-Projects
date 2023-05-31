/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 04 - ArrayListDriver
 */

public class ArrayListDriver {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        System.out.println("Size: " + al.size());
        System.out.println("Empty? " + al.isEmpty());
        System.out.println(al);
        al.add(3); al.add(5); al.add(2); al.add(10); al.add(8);
        System.out.println("Size: " + al.size());
        System.out.println("Empty? " + al.isEmpty());
        System.out.println(al);
        al.add(7); al.add(1); al.add(3); al.add(3); al.add(5);
        System.out.println("Size: " + al.size());
        System.out.println("Empty? " + al.isEmpty());
        System.out.println(al);
        al.add(1);
        System.out.println("Size: " + al.size());
        System.out.println("Empty? " + al.isEmpty());
        System.out.println(al);
        // removal
        al.remove(3); // number 10
        System.out.println("Size: " + al.size());
        System.out.println("Empty? " + al.isEmpty());
        System.out.println(al);
    }
}
