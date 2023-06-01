
/*
 Program name: Pace
 Description: This program asks for the user to imput the name of food and the amount of calories in that food. 
 Then the program calculates the amount of time the user should walk.  
 Author: Christian Lopez
 Date: 02/16/2020
 Instructor: Dr. Gurka
 Section: T/R 4:00pm to 6:00pm
 */
import java.util.*;

public class Pace {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter name of food here: ");
      String foodName = keyboard.nextLine();
      System.out.println("Enter the number of calories of the food: ");
      int numberOfCalories = keyboard.nextInt();
      int minToWalk = (int) (numberOfCalories / 5.4);
      System.out.println("Food: " + foodName);
      System.out.println("Calories:" + numberOfCalories);
      System.out.println("Minutes to walk: " + minToWalk);
      keyboard.close();
   }
}