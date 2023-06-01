/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Homework 06 - AdaQueue Class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AdaQueue {

    public static final String INPUT_FILE_NAME = "input.txt";
    public static final String EMPTY_QUEUE_MSG = "No job for Ada?";
    public static final int POP        = 0;
    public static final int POP_BACK   = 1;
    public static final int REVERSE    = 3;
    public static final int PUSH       = 4;
    public static final int PUSH_FRONT = 5;

    public static void main(String[] args) throws FileNotFoundException {
        Queue<Integer> ada = new DynamicQueueLinkedList<>();
        Scanner in = new Scanner(new FileInputStream(INPUT_FILE_NAME));
        int inputs = in.nextInt();
        int op  = 0;
        int arg = 0;
        for (int i = 0; i < inputs; i++) {
            op = in.nextInt();
            if (op == PUSH || op == PUSH_FRONT)
                arg = in.nextInt();
            switch (op) {
                case POP:
                    try {
                        System.out.println(ada.pop());
                    }
                    catch(NoSuchElementException ex) {
                        System.out.println(EMPTY_QUEUE_MSG);
                    }
                    break;
                case POP_BACK:
                    try {
                        ada.popFromBack();
                    }
                    catch(NoSuchElementException ex) {
                        System.out.println(EMPTY_QUEUE_MSG);
                    }
                    break;
                case REVERSE:
                    ada.reverse();
                    break;
                case PUSH:
                    ada.push(arg);
                    break;
                case PUSH_FRONT:
                    ada.pushToFront(arg);
            }
        }
        in.close();
    }
}
