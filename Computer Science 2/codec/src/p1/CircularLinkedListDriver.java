/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - CircularLinkedListDriver
 */

package p1;

public class CircularLinkedListDriver {

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        System.out.println(cll);
        cll.append();
        System.out.println(cll);
        cll.append();
        System.out.println(cll);
        cll.append();
        System.out.println(cll);
        cll.next();
        System.out.println(cll);
        cll.remove();
        System.out.println(cll);
        cll.next();
        System.out.println(cll);
        cll.remove();
        System.out.println(cll);
    }

}