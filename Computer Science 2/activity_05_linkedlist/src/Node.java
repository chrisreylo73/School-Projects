/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 05 - Node (of integers)
 */

public class Node {

    private int  data;//Any data that the node is representing. EX: Think of like a name of a employee.
    private Node next;//Points to the next node.EX: Think of it like pointing to a employee's supervisor.

    public Node() {//default constructor where no data is required. EX: Employee with no name in the system.
        data = 0; // set to a default value
        next = null; // does not refer to any particular node
    }

    public Node(int data) {//constructor where the Node contains data. EX: Employee has a name.
        this.data = data;//this. refers to current objects data. EX: Employees name would be different for each employee so it calls the current employees name.
        next = null;//next is the pointer and since the list is empty it is initialized as null.
    }
    //last Node can be found by .getNext() == null. Or when list is empty head == null.

    public int getData() {
        return data;
    }//returns the data of the current node. EX: The current employees name.

    public Node getNext() {
        return next;
    }//gets the next Node that was pointed to.

    public void setData(int data) {
        this.data = data;
    }//sets data to some other piece of data

    public void setNext(Node next) {
        this.next = next;
    }//
    // Node a = new Node(5);
    // Node b = new Node(8);
    // a -> b
    // a.setNext(b);
    // which node comes after a?
    // Node temp;
    // temp = a.getNext();

    @Override
    public String toString() {
        return data + "";
    }
}
