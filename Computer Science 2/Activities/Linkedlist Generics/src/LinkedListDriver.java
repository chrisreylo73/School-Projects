/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 05 - LinkedListDriver
 */

public class LinkedListDriver {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        System.out.println(ll);
        ll.append("Thyago");
        ll.append("Lisboa");
        ll.append("Mota");
        System.out.println(ll);
        System.out.println(ll.isEmpty());
    }
}
