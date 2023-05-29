/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - LinkedList
 */

package p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void testEmptyList() {
        LinkedList ll = new LinkedList();
        assertNull(ll.toArray());
    }

    @Test
    public void testSingleElementList() {
        LinkedList ll = new LinkedList();
        ll.append(1);
        int array[] = ll.toArray();
        assertEquals(1, array.length);
        assertEquals(1, array[0]);
    }

    @Test
    public void testThreeElementList() {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        int array[] = ll.toArray();
        assertEquals(3, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

}