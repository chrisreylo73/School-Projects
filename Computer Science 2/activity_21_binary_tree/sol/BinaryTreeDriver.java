/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 21 - BinaryTreeDriver class
 */

public class BinaryTreeDriver {

    // TODO: create a binary tree and add the data elements to reproduce the tree described in the lecture about trees; don't forget to print your tree at the end
    public static void main(String[] args) {
        BinaryTree<String> btree = new BinaryTree<>();
        btree.add("Janet");
        btree.add("Alex");
        btree.add("Brenna");
        btree.add("Anthony");
        btree.add("Carla");
        btree.add("Paul");
        btree.add("Kristi");
        btree.add("Xavier");
        System.out.println(btree);

        // TODO: search for a name
        if (btree.search("Carlas"))
            System.out.println("Found!");
        else
            System.out.println("Not found!");
    }
}
