/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - DoublyLinkedListTest
 */

package p2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    public void simpleAdditionsTest() {
        DoublyLinkedList dll = new DoublyLinkedList();
        assertTrue(dll.isEmpty());
        assertEquals(0, dll.size());
        dll.add(1);
        assertFalse(dll.isEmpty());
        assertEquals(1, dll.size());
        assertEquals(1, dll.get(0));
        dll.add(2);
        assertFalse(dll.isEmpty());
        assertEquals(2, dll.size());
        assertEquals(2, dll.get(0));
        assertEquals(1, dll.get(1));
        dll.add(3);
        assertFalse(dll.isEmpty());
        assertEquals(3, dll.size());
        assertEquals(3, dll.get(0));
        assertEquals(2, dll.get(1));
        assertEquals(1, dll.get(2));
    }

    @Test
    public void removeWhenEmptyTest() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.remove(0);
        assertTrue(dll.isEmpty());
    }

    @Test
    public void additionWithRemoveTest() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.remove(1);
        assertFalse(dll.isEmpty());
        assertEquals(2, dll.size());
        assertEquals(3, dll.get(0));
        assertEquals(1, dll.get(1));
    }

    @Test
    public void insertAtHeadTest() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.insert(0, 4);
        assertFalse(dll.isEmpty());
        assertEquals(4, dll.size());
        assertEquals(4, dll.get(0));
        assertEquals(3, dll.get(1));
        assertEquals(2, dll.get(2));
        assertEquals(1, dll.get(3));
    }

    @Test
    public void appendTest() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.append(4);
        assertFalse(dll.isEmpty());
        assertEquals(4, dll.size());
        assertEquals(3, dll.get(0));
        assertEquals(2, dll.get(1));
        assertEquals(1, dll.get(2));
        assertEquals(4, dll.get(3));
    }

    @Test
    public void insertInBetweenTest() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.insert(1, 4);
        assertFalse(dll.isEmpty());
        assertEquals(4, dll.size());
        assertEquals(3, dll.get(0));
        assertEquals(4, dll.get(1));
        assertEquals(2, dll.get(2));
        assertEquals(1, dll.get(3));
    }

    @Test
    public void toStringBackwardsTest() {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(1);
        dll.append(2);
        dll.append(3);
        assertEquals("3 2 1 ", dll.toStringBackwards());
        dll.remove(0);
        assertEquals("3 2 ", dll.toStringBackwards());
        dll.remove(1);
        assertEquals("2 ", dll.toStringBackwards());
        dll.remove(0);
        assertEquals("", dll.toStringBackwards());
    }
}