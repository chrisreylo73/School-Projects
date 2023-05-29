/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 25 - DecisionTree class
 */

public class DecisionTree {

    private DecisionTreeNode root;

    public DecisionTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public DecisionTreeNode getRoot() {
        return root;
    }

    public void setRoot(DecisionTreeData data) {
        root = new DecisionTreeNode(data);
    }

    public void setLeft(DecisionTree subtree) {
        root.setLeft(subtree.getRoot());
    }

    public void setRight(DecisionTree subtree) {
        root.setRight(subtree.getRoot());
    }

    // TODO: finish implementation of classifyRecursively
    private void classifyRecursively(DecisionTreeNode current, DataPoint dp) {

        // TODO: get DecisionTreeData from current DecisionTreeNode
        DecisionTreeData data = current.getData();

        // TODO: if DecisionTreeData is an instance of Decision, cast it to Decision and
        // use the object to decide whether to call classifyRecursively to the left or to the right
        if (data instanceof Decision) {
            Decision decision = (Decision) data;
            int attribute = decision.getAttribute();
            double value = decision.getValue();
            if (dp.getAttribute(attribute) <= value)
                classifyRecursively(current.getLeft(), dp);
            else
                classifyRecursively(current.getRight(), dp);
        }

        // TODO: if DecisionTreeData is an instance of Target, cast it to Target and
        // set the target of the data point
        else {
            Target target = (Target) data;
            dp.setTarget(target.getValue());
        }
    }

    public void classify(DataPoint dp) {
        classifyRecursively(root, dp);
    }

    @Override
    public String toString() {
        Queue<DecisionTreeNode> queue = new Queue<>();
        DecisionTreeNode current = root;
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
}