/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Prg 02 - VersioningSystem Class
 */

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;

public class VersioningSystem {

    private ListOfStackOfVersionedObjects list;

    public VersioningSystem() {
        list = new ListOfStackOfVersionedObjects();
    }

    // TODOd: searches the list of StackOfVersionedObject for a stack with the given
    // key; 0, puts the given object on the stack, showing “the given key is
    // invalid” if an exception is thrown; if a stack cannot be found, this method
    // creates a stack and adds it to the list before calling put on it
    public void put(final String key, String object) {
        if (this.list.isEmpty() && this.list.get(key) == null) {
            StackOfVersionedObjects newStack = new StackOfVersionedObjects(key, object);
            this.list.append(newStack);
        } else if (!this.list.isEmpty() && this.list.get(key) == null) {
            StackOfVersionedObjects newStack = new StackOfVersionedObjects(key, object);
            this.list.append(newStack);
        } else if (this.list.get(key).isEmpty()) {
            System.out.println("the given key is invalid");
        }

        else if (list.get(key).getKey().equals(key) || this.list.isEmpty()) {
            this.list.get(key).put(object);
        }
    }

    // TODOd: searches the list of StackOfVersionedObject for a stack with the given
    // key; if one is found, displays the latest version of the object, showing “the
    // given key is invalid” if an exception is thrown; if a stack cannot be found,
    // this method should display a message saying that “the given key is invalid”
    public void get(final String key) {
        if (this.list.isEmpty() || this.list.get(key) == null) {
            System.out.println("the given key is invalid");
        } else if (list.get(key).getKey().equals(key) /* || this.list.isEmpty() */) {
            System.out.println(list.get(key).get());
        }
    }

    // TODOd: searches the list of StackOfVersionedObject for a stack with the given
    // key; if one is found, removes the latest version of the object, showing “the
    // given key is invalid” if an exception is thrown; if a stack cannot be found,
    // this method should display a message saying that “the given key is invalid”
    public void delete(final String key) {
        if (this.list.isEmpty() || this.list.get(key) == null) {
            System.out.println("the given key is invalid");
        } else if (list.get(key).getKey().equals(key) /* || this.list.isEmpty() */) {
            list.get(key).delete();
        }
    }

    // TODOd: lists all of the (non-empty) StackOfVersionedObject created
    public void list() {
        System.out.println(this.list);
    }

    public static void main(String[] args) {
        VersioningSystem vs = new VersioningSystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Options: [list | put | get | delete | exit]");
            System.out.print("? ");
            String option = sc.nextLine();
            if (option.equals("list"))
                vs.list();
            else if (option.equals("put")) {
                System.out.println("key? ");
                String key = sc.nextLine();
                System.out.println("object? ");
                String object = sc.nextLine();
                vs.put(key, object);
            } else if (option.equals("get")) {
                System.out.println("key? ");
                String key = sc.nextLine();
                vs.get(key);
            } else if (option.equals("delete")) {
                System.out.println("key? ");
                String key = sc.nextLine();
                vs.delete(key);
            } else
                break;
        }
    }
}