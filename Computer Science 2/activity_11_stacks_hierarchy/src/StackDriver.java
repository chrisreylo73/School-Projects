/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Activity 11 - StackDriver Class
 */

public class StackDriver {

    public static void main(String[] args) {
//        Stack<String> stack = new StaticStackArray<>();
//        Stack<String> stack = new DynamicStackArray<>();
        Stack<String> stack = new DynamicStackLinkedList<>();
        System.out.println(stack);
        stack.push("Bob");
        System.out.println(stack);
        stack.push("Helen");
        System.out.println(stack);
        stack.push("Maria");
        System.out.println(stack);
        System.out.println("Top of the stack is: " +  stack.peek());
        String data = stack.pop();
        System.out.println(data + " was popped out from the stack!");
        System.out.println(stack);
        data = stack.pop();
        System.out.println(data + " was popped out from the stack!");
        System.out.println(stack);
        data = stack.pop();
        System.out.println(data + " was popped out from the stack!");
        System.out.println(stack);
    }
}
