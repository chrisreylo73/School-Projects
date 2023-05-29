/*
 Program name:Numbers
 Description: This program asks for two differnt inputs (numbers) in order to find the purduct and sum of those inputs.
 Author: Christian Lopez
 Date: 02/16/2020
 Instructor: Dr. Gurka
 Section: T/R 4:00pm to 6:00pm
 */

import java.util.*;

public class Numbers {
     public static void main(String[] args) {
          Scanner keyboard = new Scanner(System.in);
          System.out.println("Enter your first number here: ");
          int number1 = keyboard.nextInt();
          System.out.println("Enter your second number here: ");
          int number2 = keyboard.nextInt();
          System.out.println("Your numbers are: " + number1 + " and " + number2 + ".");
          int sum = number1 + number2;
          System.out.println("Sum = " + sum);
          int product = number1 * number2;
          System.out.println("Product = " + product);
     }
}
