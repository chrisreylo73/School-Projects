/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 10 - Hashtable class
 */

import java.util.Iterator;

public class Hashtable<K,V> implements Iterable<V> {

    private static final int SIZE = 17;
    private HashNode<K, V> table[];

    public Hashtable() {
        table = new HashNode[SIZE];
    }

    // TODOd: finish the implementation of the method
    public void put(K key, V value) {

        // index points to the location in the table
        int index = Math.abs(key.hashCode() % SIZE);

        // TODOd: if table @ index is unoccupied, have the location point to the new node
        if (table[index] == null)
            table[index] = new HashNode(key, value);

        // TODOd: otherwise, search the hash nodes at the location for one with the same key
        else {
            HashNode<K, V> current = table[index];
            while (!current.getKey().equals(key) &&
                    current.getNext() != null)
                current = current.getNext();

            // TODOd: if found, rewrite the value of hash node
            if (current.getKey().equals(key))
                current.setValue(value);

            // TODOd: if not found, add the new hash node at the end of the list
            else
                current.setNext(new HashNode(key, value));
        }
    }

    // TODOd: finish the implementation of the method
    public V get(K key) {

        // index points to the location in the table
        int index = key.hashCode() % SIZE;

        // TODOd: get the hash node at table @ index
        HashNode<K, V> current = table[index];

        // TODOd: try to find a hash node with the same key and if found, return the hash node's value
        while (current != null) {
            if (current.getKey().equals(key))
                return current.getValue();
            current = current.getNext();
        }

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

    // TODOd: implement an iterator for the hashtable
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            int index = 0;
            HashNode<K, V> current = table[index];

            @Override
            public boolean hasNext() {
                while (true) {
                    if (index == SIZE)
                        break;
                    if (current == null) {
                        index++;
                        if (index < SIZE)
                            current = table[index];
                    }
                    else
                        return true;
                }
                return false;
            }

            @Override
            public V next() {
                if (hasNext()) {
                    V v = current.getValue();
                    current = current.getNext();
                    while (true) {
                        if (index == SIZE)
                            break;
                        if (current == null) {
                            index++;
                            if (index < SIZE)
                                current = table[index];
                        }
                        else
                            break;
                    }
                    return v;
                }
                return null;
            }
        };
    }
}
