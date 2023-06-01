/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 07 - PriorityQueueTest
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    public void testSamePriority() {
        PriorityQueue pq = new PriorityQueue();
        pq.push(new Customer("a"));
        pq.push(new Customer("b"));
        pq.push(new Customer("c"));
        assertEquals(new Customer("a"), pq.pop());
        assertEquals(new Customer("b"), pq.pop());
        assertEquals(new Customer("c"), pq.pop());
    }

    @Test
    public void testHigherThanFront() {
        PriorityQueue pq = new PriorityQueue();
        pq.push(new Customer("b"));
        System.out.println(pq);
        pq.push(new Customer("c"));
        System.out.println(pq);
        pq.push(new Customer("a", 1));
        System.out.println(pq);
        assertEquals(new Customer("a", 1), pq.pop());
        assertEquals(new Customer("b"), pq.pop());
        assertEquals(new Customer("c"), pq.pop());
    }

    @Test
    public void testPriorityInBetween() {
        PriorityQueue pq = new PriorityQueue();
        pq.push(new Customer("d"));
        pq.push(new Customer("a", 2));
        pq.push(new Customer("b", 2));
        pq.push(new Customer("c", 1));
        assertEquals(new Customer("a", 2), pq.pop());
        assertEquals(new Customer("b", 2), pq.pop());
        assertEquals(new Customer("c", 1), pq.pop());
        assertEquals(new Customer("d"), pq.pop());
    }

    @Test
    public void testLowestPriority() {
        PriorityQueue pq = new PriorityQueue();
        pq.push(new Customer("a", 1));
        pq.push(new Customer("b", 1));
        pq.push(new Customer("c", 1));
        pq.push(new Customer("d"));
        assertEquals(new Customer("a", 1), pq.pop());
        assertEquals(new Customer("b", 1), pq.pop());
        assertEquals(new Customer("c", 1), pq.pop());
        assertEquals(new Customer("d"), pq.pop());
    }
}