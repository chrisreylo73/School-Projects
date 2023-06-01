/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - CircularLinkedListTest
 */

package p1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    @Test
    public void testSimpleAdditions() {
        CircularLinkedList cll = new CircularLinkedList(0);
        assertEquals(0, cll.size());
        assertTrue(cll.isEmpty());
        //System.out.println(cll.isEmpty());
        cll.append();
        assertEquals(1, cll.size());
        assertFalse(cll.isEmpty());
        //System.out.println(cll.isEmpty());
        assertEquals(new Node(0), cll.getHead());
        assertEquals(new Node(0), cll.getTail());
        cll.append();
        assertEquals(2, cll.size());
        assertFalse(cll.isEmpty());
        assertEquals(new Node(0), cll.getHead());
        assertEquals(new Node(1), cll.getTail());
        cll.append();
        assertEquals(3, cll.size());
        assertFalse(cll.isEmpty());
        assertEquals(new Node(0), cll.getHead());
        assertEquals(new Node(2), cll.getTail());
    }

    @Test
    public void testSimpleAdditionsAfterNext() {
        CircularLinkedList cll = new CircularLinkedList(0);
        cll.append(); cll.append(); cll.append();
        cll.next();
        assertEquals(3, cll.size());
        assertFalse(cll.isEmpty());
        assertEquals(new Node(1), cll.getHead());
        assertEquals(new Node(0), cll.getTail());
    }

    @Test
    public void testSimpleAdditionsAfterRemove() {
        CircularLinkedList cll = new CircularLinkedList(0);
        cll.append(); cll.append(); cll.append();
        cll.remove();
        assertEquals(2, cll.size());
        assertFalse(cll.isEmpty());
        assertEquals(new Node(1), cll.getHead());
        assertEquals(new Node(2), cll.getTail());
    }

    @Test
    public void testAdditionsNextAndRemove() {
        CircularLinkedList cll = new CircularLinkedList(0);
        cll.append(); cll.append(); cll.append();
        cll.next();
        cll.remove();
        assertEquals(2, cll.size());
        assertFalse(cll.isEmpty());
        assertEquals(new Node(2), cll.getHead());
        assertEquals(new Node(0), cll.getTail());
    }

    @Test
    public void testAddRemoveReturnToEmpty() {
        CircularLinkedList cll = new CircularLinkedList(0);
        cll.append(); cll.append(); cll.append();
        cll.remove(); cll.remove(); cll.remove();
        assertEquals(0, cll.size());
        assertTrue(cll.isEmpty());
    }

    @Test
    public void testAddRemoveReturnToEmptyAddAfter() {
        CircularLinkedList cll = new CircularLinkedList(0);
        cll.append(); cll.append(); cll.append();
        cll.remove(); cll.remove(); cll.remove();
        cll.append();
        assertEquals(1, cll.size());
        assertFalse(cll.isEmpty());
        assertEquals(new Node(3), cll.getHead());
        assertEquals(new Node(3), cll.getTail());
        cll.append();
        assertEquals(2, cll.size());
        assertFalse(cll.isEmpty());
        assertEquals(new Node(3), cll.getHead());
        assertEquals(new Node(4), cll.getTail());
        cll.append();
        assertEquals(3, cll.size());
        assertFalse(cll.isEmpty());
        assertEquals(new Node(3), cll.getHead());
        assertEquals(new Node(5), cll.getTail());
    }
}