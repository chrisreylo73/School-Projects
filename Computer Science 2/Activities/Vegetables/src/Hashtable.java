/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 27 - Hashtable class
 */

public class Hashtable<K, V> {

    private static final int SIZE = 17;
    private HashNode<K, V> table[];

    public Hashtable() {
        table = new HashNode[SIZE];
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode() % SIZE);
        HashNode<K, V> newHashNode = new HashNode(key, value);
        if (table[index] == null)
            table[index] = newHashNode;
        else {
            HashNode<K, V> current = table[index];
            while (!current.getKey().equals(key) &&
                    current.getNext() != null)
                current = current.getNext();
            if (current.getKey().equals(key))
                current.setValue(value);
            else
                current.setNext(newHashNode);
        }
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        HashNode<K, V> current = table[index];
        while (current != null) {
            if (current.getKey().equals(key))
                return current.getValue();
            current = current.getNext();
        }
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