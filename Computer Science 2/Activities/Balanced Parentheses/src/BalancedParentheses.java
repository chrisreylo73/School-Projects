/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 09 - BalancedParentheses
 */

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;

public class BalancedParentheses {

    // TODO: implement isBalanced using a stack
    public static boolean isBalanced(String exp) {
        Stack<String> stack = new DynamicStackLinkedList<>();
        String el[] = exp.split(" ");
        System.out.println(Arrays.toString(el));
        for(String e : el) {
            System.out.println(e);
            if(e.equals("("))
                stack.push(e);
            else if (e.equals(")")) {
                try {
                    stack.pop();
                } catch (EmptyStackException ex) {
                    return false;
                }
            }
        }return stack.isEmpty(); // placeholder
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("? ");
        String exp = in.nextLine();
        System.out.print("The parentheses in expression \"" + exp + "\" are ");
        if (isBalanced(exp))
            System.out.println("balanced!");
        else
            System.out.println("not balanced!");
    }
}
