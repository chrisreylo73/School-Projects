/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Prg 02 - StackOfVersionedObjects Class
 */

import java.util.EmptyStackException;

/**
 * A StackOfVersionedObjects uses a stack to keep a collection of VersionedObjects that share the same key. The version numbers of the objects increase as they move up the stack. When the stack becomes empty, no more objects are allowed to enter the stack.
 */
public class StackOfVersionedObjects {

    private Node<VersionedObject> latest;
    private String                key;

    public StackOfVersionedObjects(String key, final Object object) {
        this.key = key;
        VersionedObject vrObject = new VersionedObject(object);
        latest = new Node<VersionedObject>(vrObject);
    }

    public boolean isEmpty() {
        return latest == null;
    }

    // TODOd: create a new version of the given object by pushing it to the top of the stack; the new versioned object should have the version of the latest object plus one; ; if the stack is empty, this method should throw an EmptyStackException
    public void put(final Object object) throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        VersionedObject vrObject = new VersionedObject(object, latest.getData().getVersion() + 1);
        Node <VersionedObject> newNode = new Node<VersionedObject>(vrObject);
        newNode.setNext(latest);
        latest = newNode;


    }

    // TODOd: return the latest version of the object; if the stack is empty, this method should throw an EmptyStackException
    public Object get() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return latest.getData().getObject();
    }

    // TODOd: delete the latest version of the object; if the stack is empty, this method should throw an EmptyStackException
    public void delete() {
        if (isEmpty())
            throw new EmptyStackException();
        Object data = latest.getData();
        Node temp = latest;
        latest = latest.getNext();
        temp.setNext(null);
    }

    public String getKey() {
        return key;
    }

    // TODOd: override toString showing all versions of the object; you must follow the format described in the instructions
    @Override
    public String toString() {
        String out = "key: " +/* "\"" +*/ key /*+ "\"\n" */;
        Node current = latest;
        if(isEmpty()) return out + "; this stack is empty!";
        while(current != null) {
            out += "\n\t" + current.getData();
            current = current.getNext();
        }
        return out;
    }
}