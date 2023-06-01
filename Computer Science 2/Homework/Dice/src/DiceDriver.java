
/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 01 - DiceDriver
 */
import java.util.*;

public class DiceDriver {

    public static void main(String[] args) {
        Dice d = new Dice();
        Stack<String> tempStack = new Stack<String>();
        Hashtable tempHT = new Hashtable();
        Queue<String> tempQueue = new LinkedList<String>();
        tempQueue.add("Hello");
        tempQueue.add("World");
        tempQueue.add("My");
        tempQueue.add("Name");
        tempQueue.add("Is");
        tempQueue.add("Rey");
        int tempsize = tempQueue.size();
        for (int i = 0; i < tempsize; i++) {
            System.out.println(tempQueue.remove());
        }
        System.out.println("The siz is now " + tempQueue.size());

        String[] names = { "Rey", "Chris", "Big Mike", "Mike" };
        String[] size = { "small", "large", "large", "medium" };
        for (int i = 0; i < names.length; i++) {
            tempHT.put(names[i], size[i]);
        }
        for (int i = 0; i < tempHT.size(); i++) {
            System.out.println(tempHT.get(names[i]));
        }

        /*
         * tempHT.put("Rey","small");
         * tempHT.put("Chris","big");
         * tempHT.put("Big Mike","extra big");
         * tempHT.put("Little Mike","medium");
         */
        System.out.println(tempHT.toString());
        System.out.println(tempHT.isEmpty());

        tempStack.push("POPPER");
        tempStack.push("CORNER");
        tempStack.push("NOW");
        System.out.println(tempStack.size());
        System.out.println(tempStack.pop());
        System.out.println(tempStack.peek());
        LinkedList<String> sample = new LinkedList<String>();
        sample.add("Rey");
        sample.add("lopez");
        sample.add("was");
        sample.add("here");
        sample.pop();
        int i = 0;
        while (i < sample.size()) {
            System.out.println(sample.get(i));
            i++;
        }
        String temp = "";
        ListIterator<String> iterator = sample.listIterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            System.out.println(temp);

        }
        // System.out.println(sample.getFirst());
        System.out.println(d);
        for (i = 0; i < 10; i++) {
            d.roll();
            System.out.println(d);

        }
    }
}
