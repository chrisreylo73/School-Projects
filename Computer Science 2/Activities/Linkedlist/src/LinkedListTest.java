/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 05 - LinkedListTest
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void testListEmpty() {
        LinkedList ll = new LinkedList();
        assertTrue(ll.isEmpty());
        assertEquals(0, ll.size());
    }

    @Test
    public void testListNotEmpty() {
        LinkedList ll = new LinkedList();
        ll.add(5);
        assertFalse(ll.isEmpty());
        assertNotEquals(0, ll.size());
    }

    @Test
    public void testListThreeFiveEight() {
        // create the scenario 3, 5, 8
        LinkedList ll = new LinkedList();
        ll.append(3);
        ll.append(5);
        ll.append(8);
        // do the assertions with isEmpty, size, get
        assertFalse(ll.isEmpty());
        assertEquals(3, ll.size());
        assertEquals(3, ll.get(0));
        assertEquals(5, ll.get(1));
        assertEquals(8, ll.get(2));
    }

    @Test
    public void testListThreeFiveEightInsertTenBtwThreeFive() {
        // create the scenario 3, 5, 8
        LinkedList ll = new LinkedList();
        ll.append(3);
        ll.append(5);
        ll.append(8);
        ll.insert(1, 10);
        // do the assertions with isEmpty, size, get
        assertFalse(ll.isEmpty());
        assertEquals(4,  ll.size());
        assertEquals(3,  ll.get(0));
        assertEquals(10, ll.get(1));
        assertEquals(5,  ll.get(2));
        assertEquals(8,  ll.get(3));
    }
}