/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 21 - BinaryTree class
 */

public class BinaryTree<T extends Comparable<T>> {

    private BinNode<T> root;

    public BinaryTree() {
        root = null;
    }

    // TODO: implement the isEmpty method
    public boolean isEmpty() {
        return root == null;
    }

    // TODO: implement the addRecursively private method
    private BinNode<T> addRecursively(BinNode<T> current, final T data) {

        // TODO: check if current is null, if that is the case, return a new BinNode with the data
        if (current == null)
            return new BinNode<T>(data);

        // TODO: if current is not null...
        else {

            // TODO: if given data is smaller than current data, call addRecursively to the left,
            //  making sure to use the method's return to set current's left node
            if (data.compareTo(current.getData()) < 0)
                current.setLeft(addRecursively(current.getLeft(), data));

            // TODO: if given data is greater than current data, call addRecursively to the right,
            //  making sure to use the method's return to set current's right node
            else if (data.compareTo(current.getData()) > 0)
                current.setRight(addRecursively(current.getRight(), data));

            // TODO: don't forget to return current
            return current;
        }
    }

    // TODO: implement the add method
    public void add(final T data) {
        Queue queue = new Queue();

        if (isEmpty())
            root = new BinNode<T>(data);
        else {
            BinNode<T> newNode = new BinNode<>(data);
            BinNode<T> current = root;
            while(true){
                if(data.compareTo(current.getData()) < 0){
                    if(current.getLeft() == null) {
                        current.setLeft((newNode));
                        return;
                    }
                    else {
                        current = current.getLeft();
                    }
                }
                else{
                    if(current.getRight() == null) {
                        current.setRight((newNode));
                        return;
                    }
                    else {
                        current = current.getRight();
                    }
                }
            }

        }
    }

    // TODO: override the toString method using a breadth first tree traversal using a queue of binary nodes
    @Override
    public String toString() {
        Queue<BinNode<T>> queue = new Queue<>();
        BinNode<T> current = root;
        queue.push(current);
        String str = "";
        while (!queue.isEmpty()) {
            current = queue.pop();
            str += current.getData() + " ";
            if (current.getLeft() != null)
                queue.push(current.getLeft());
            if (current.getRight() != null)
                queue.push(current.getRight());
        }
        return str;
    }

    // TODO: implement searchRecursively
    private boolean searchRecursively(final BinNode<T> current, final T data) {
        if (current == null)
            return false;
        else if (data.compareTo(current.getData()) == 0)
            return true;
        else if (data.compareTo(current.getData()) < 0)
            return searchRecursively(current.getLeft(), data);
        else
            return searchRecursively(current.getRight(), data);
    }

    // TODO: boolean search
    public boolean search(final T data) {
        return searchRecursively(root, data);
    }
}
