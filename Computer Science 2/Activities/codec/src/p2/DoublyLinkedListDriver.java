/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - DoublyLinkedListDriver
 */

package p2;

public class DoublyLinkedListDriver {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.insert(1, 99);
        System.out.println(dll);
        System.out.println(dll.toStringBackwards());
        dll.remove(1);
        System.out.println(dll);
        System.out.println(dll.toStringBackwards());
    }
}
