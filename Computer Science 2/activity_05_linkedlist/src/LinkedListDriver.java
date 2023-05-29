/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 05 - LinkedListDriver
 */

public class LinkedListDriver {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        System.out.println(ll);
        ll.append(5);
        ll.append(8);
        ll.append(3);
        System.out.println(ll);
        System.out.println(ll.isEmpty());
    }
}
