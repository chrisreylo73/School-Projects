/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 26 - Hashtable class
 */

public class Hashtable<K, V> {

    private static final int SIZE = 17;
    private HashNode<K, V> table[];

    public Hashtable() {
        table = new HashNode[SIZE];
    }

    // TODO: finish the implementation of the method
    public void put(K key, V value) {

        // index points to the location in the table
        int index = key.hashCode() % SIZE;

        // TODO: create a new HashNode from (key, value)

        // TODO: if table @ index is unoccupied, have the location point to the new node

        // TODO: otherwise, search the hash nodes at the location for one with the same
        // key

        // TODO: if found, rewrite the value of hash node

        // TODO: if not found, add the new hash node at the end of the list

    }

    // TODO: finish the implementation of the method
    public V get(K key) {

        // index points to the location in the table
        int index = key.hashCode() % SIZE;

        // TODO: get the hash node at table @ index

        // TODO: try to find a hash node with the same key and if found, return the hash
        // node's value

        // if not found, the method returns null
        return null;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                str += "[" + i + "]: ";
                HashNode<K, V> current = table[i];
                while (current != null) {
                    str += current.toString() + " ";
                    current = current.getNext();
                }
                str += "\n";
            }
        }
        return str;
    }

}
