/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Activity 12 - QueueDriver Class
 */

public class QueueDriver {

    public static void main(String[] args) {
//        Queue<String> queue = new StaticQueueArray<>();
//        Queue<String> queue = new DynamicQueueArray<>();
        Queue<String> queue = new DynamicQueueLinkedList<>();
        System.out.println(queue);
        queue.push("Bob");
        System.out.println(queue);
        queue.push("Helen");
        System.out.println(queue);
        queue.push("Maria");
        System.out.println(queue);
        queue.push("Thyago");
        queue.push("Lisboa");
        queue.push("Mota");
        System.out.println("Front of the stack is: " +  queue.peek());

        String data = queue.pop();
        System.out.println(data + " was popped out from the queue!");
        System.out.println(queue);

        data = queue.pop();
        System.out.println(data + " was popped out from the queue!");
        System.out.println(queue);

        data = queue.pop();
        System.out.println(data + " was popped out from the queue!");
        System.out.println(queue);
    }
}
