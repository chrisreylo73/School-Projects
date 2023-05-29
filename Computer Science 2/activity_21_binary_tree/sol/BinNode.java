/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 21 - BinNode class
 */

// TODO: implement the BinNode<T> class
public class BinNode<T> {

    private T  data;
    private BinNode<T> left, right;

    public BinNode() {
        data = null;
        left = right = null;
    }

    public BinNode(T data) {
        this.data = data;
        left = right = null;
    }

    public T getData() {
        return data;
    }

    public BinNode<T> getLeft() {
        return left;
    }

    public BinNode<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinNode<T> left) {
        this.left = left;
    }

    public void setRight(BinNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String str = "";
        if (left == null)
            str += "-";
        str += data;
        if (right == null)
            str += "-";
        return str;
    }
}