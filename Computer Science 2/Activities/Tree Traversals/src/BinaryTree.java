/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 22 - BinaryTree class
 */

public class BinaryTree<T extends Comparable<T>> {

    private BinNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private BinNode<T> addRecursively(BinNode<T> current, final T data) {
        if (current == null)
            return new BinNode<T>(data);
        else {
            if (data.compareTo(current.getData()) < 0)
                current.setLeft(addRecursively(current.getLeft(), data));
            else if (data.compareTo(current.getData()) > 0)
                current.setRight(addRecursively(current.getRight(), data));
            return current;
        }
    }

    public void add(final T data) {
        if (isEmpty())
            root = new BinNode<T>(data);
        else
            addRecursively(root, data);
    }

    public String preOrder(final BinNode<T> current) {
        if (current != null)
            return  current.getData() + " "     +
                    preOrder(current.getLeft()) +
                    preOrder(current.getRight());
        return "";
    }

    public String inOrder(final BinNode<T> current) {
        if (current != null)
            return  inOrder(current.getLeft())  +
                    current.getData() + " "     +
                    inOrder(current.getRight());
        return "";
    }

    public String postOrder(final BinNode<T> current) {
        if (current != null)
            return  postOrder(current.getLeft())  +
                    postOrder(current.getRight()) +
                    current.getData() + " ";
        return "";
    }

    @Override
    public String toString() {
        Stack<BinNode<T>> stack = new Stack<>();
        BinNode<T> current = root;
        stack.push(current);
        String str = "";
        while (!stack.isEmpty()) {
            current = stack.pop();
            str += current.getData() + " ";
            if (current.getLeft() != null) // left node pushed 1st
                stack.push(current.getRight());
            if (current.getRight() != null) // right node pushed 2nd
                stack.push(current.getLeft());

        }
        return str;
    }
}