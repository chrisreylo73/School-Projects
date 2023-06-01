import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    public void testEmptyTree() {
        BinaryTree<String> tree = new BinaryTree<>();
        assertTrue(tree.isBalanced());
        assertEquals(0, tree.height());
    }

    @Test
    public void testUnaryTree() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("M");
        assertTrue(tree.isBalanced());
        assertEquals(1, tree.height());
    }

    @Test
    public void testSimpleBalancedTree() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("M");
        tree.add("B");
        tree.add("R");
        assertTrue(tree.isBalanced());
        assertEquals(2, tree.height());
    }

    @Test
    public void testSimpleUnbalancedTree() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("M");
        tree.add("R");
        tree.add("T");
        assertFalse(tree.isBalanced());
        assertEquals(3, tree.height());
    }

    @Test
    public void testComplexBalancedTree() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("M");
        tree.add("F");
        tree.add("R");
        tree.add("B");
        tree.add("G");
        tree.add("N");
        tree.add("S");
        tree.add("A");
        tree.add("C");
        tree.add("T");
        assertTrue(tree.isBalanced());
        assertEquals(4, tree.height());
    }

    @Test
    public void testComplexUnbalancedTreeV1() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("M");
        tree.add("F");
        tree.add("R");
        tree.add("B");
        tree.add("N");
        tree.add("S");
        tree.add("A");
        tree.add("C");
        tree.add("T");
        assertFalse(tree.isBalanced());
        assertEquals(4, tree.height());
    }

    @Test
    public void testComplexUnbalancedTreeV2() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("M");
        tree.add("F");
        tree.add("R");
        tree.add("B");
        tree.add("G");
        tree.add("S");
        tree.add("A");
        tree.add("C");
        tree.add("T");
        assertFalse(tree.isBalanced());
        assertEquals(4, tree.height());
    }

    public void testComplexUnbalancedTreeV3() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("M");
        tree.add("F");
        tree.add("R");
        tree.add("B");
        tree.add("S");
        tree.add("A");
        tree.add("C");
        tree.add("T");
        assertFalse(tree.isBalanced());
        assertEquals(4, tree.height());
    }
}