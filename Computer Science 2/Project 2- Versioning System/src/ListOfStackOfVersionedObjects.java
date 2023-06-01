/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Prg 02 - ListOfStackOfVersionedObjects Class
 */
/**
 * A linked list that holds StackOfVersionedObjects objects
 */
public class ListOfStackOfVersionedObjects {
    private Node<StackOfVersionedObjects> head;

    public ListOfStackOfVersionedObjects() {
        head = null;
    }

    // append the stack to the list, making sure stacks have unique keys
    public void append(final StackOfVersionedObjects stack) {
        Node<StackOfVersionedObjects> newNode = new Node<StackOfVersionedObjects>(stack);
        if (isEmpty())
            head = newNode;
        else {
            Node<StackOfVersionedObjects> current = head;
            while (current.getNext() != null) {
                if (current.getData().getKey().equals(stack.getKey()))
                    return;
                current = current.getNext();
            }
            if (!current.getData().getKey().equals(stack.getKey()))
                current.setNext(newNode);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    // TODO: return the stack that has the given key (or null if key is not found)
    public StackOfVersionedObjects get(String key) {
        Node<StackOfVersionedObjects> current = head;
        while (current != null) {
            if (current.getData().getKey().equals(key)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        String out = "";
        Node<StackOfVersionedObjects> current = head;
        while (current != null) {
            out += current.toString() + "\n";
            current = current.getNext();
        }
        return out;
    }
}