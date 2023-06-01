/*
 Program Name: CS1Calculator
 Description: It preforms simple math problems by the 
 user inputting two numbers and continues solving math 
 problems until prompted to stop. Then a report is printed out 
 counting the number of math proplems solved and 
 the number of each type of math problem solved.
 Author: Christian Lopez
 Date: 02/26/2020
 Instructor: Dr. Gurka
 Section: T/R 4:00pm to 6:00pm
 */

import java.util.Scanner; //Getting the Scanner class

public class CS1Calculator {
   String command;
   static int answer = 0;// Allows counters to be used by all methods
   static int sCounter = 0;
   static int mCounter = 0;
   static int dCounter = 0;
   static int aCounter = 0;
   Scanner keyboard = new Scanner(System.in);

   public CS1Calculator() // Constructor Method:
   {
      sCounter = 0;// Initializes counter for each math operation
      mCounter = 0;
      dCounter = 0;
      aCounter = 0;
      command = "y";
   }

   public static void printIntro() // Print Intro Method: Explains Program to user
   {
      System.out.println(
            "Select the problem type you would like to calculate by entering the first letter of the operation.\n(A)ddition\n(S)ubtraction\n(M)ultiplication\n(D)ivision");
      System.out.println("Operation?");
   }

   public static void calculate() // Calculate Method: Primary method with a loop until the user is done
   {
      Scanner keyboard = new Scanner(System.in);
      String command = keyboard.nextLine();
      command = command.toUpperCase();
      do // Do while loop
      {
         command = command.toUpperCase(); // Changes all inputs to uppercase
         if (command.equals("A")) // If the user types A do addition
         {
            aCounter++; // Adds 1 to counter for the selected math operation
            System.out.println("You selected Addition.");
            System.out.println("Enter your first number: ");
            int firstNumber = Integer.parseInt(keyboard.nextLine());// Asks user to enter in integer and converts
                                                                    // integer to string
            System.out.println("Enter your second number: ");
            int secondNumber = Integer.parseInt(keyboard.nextLine());
            answer = firstNumber + secondNumber; // Takes both inputs and does the selected math operation.
            System.out.println("Your answer is " + answer);// Prints out answer
         } else if (command.equals("S")) // If the user types S do subtraction
         {
            sCounter++; // Adds 1 to counter for the selected math operation
            System.out.println("You selected Subtraction.");
            System.out.println("Enter your first number: ");
            int firstNumber = Integer.parseInt(keyboard.nextLine());
            System.out.println("Enter your second number: ");
            int secondNumber = Integer.parseInt(keyboard.nextLine());
            answer = firstNumber - secondNumber; // Takes both inputs and does the selected math operation.
            System.out.println("Your answer is " + answer);
         } else if (command.equals("D")) // If the user types D do division
         {
            dCounter++; // Adds 1 to counter for the selected math operation
            System.out.println("You selected Division.");
            System.out.println("Enter your first number: ");
            int firstNumber = Integer.parseInt(keyboard.nextLine());
            System.out.println("Enter your second number: ");
            int secondNumber = Integer.parseInt(keyboard.nextLine());
            answer = firstNumber / secondNumber; // Takes both inputs and does the selected math operation.
            System.out.println("Your answer is " + answer);
         } else if (command.equals("M")) // If the user types M do multiplication
         {
            mCounter++; // Adds 1 to counter for the selected math operation
            System.out.println("You selected Multiplication.");
            System.out.println("Enter your first number: ");
            int firstNumber = Integer.parseInt(keyboard.nextLine());
            System.out.println("Enter your second number: ");
            int secondNumber = Integer.parseInt(keyboard.nextLine());
            answer = firstNumber * secondNumber; // Takes both inputs and does the selected math operation.
            System.out.println("Your answer is " + answer);
         }

         System.out.println("Would you like to do another problem?(y/n)");// Asks user if they want to continue
         command = keyboard.nextLine();
         command = command.toUpperCase();

         if (command.equals("Y"))// If they type Y they will repeat the loop
         {
            System.out.println(
                  "Select the problem type you would like to calculate by entering the first letter of the operation.\n(A)ddition\n(S)ubtraction\n(M)ultiplication\n(D)ivision\n");
            System.out.println("Operation?");
            command = keyboard.nextLine();
         }
      } while (!(command.equals("N")));// If they type N they will end the loop
      keyboard.close();
   }

   public static void printReport() // Print Report Method: Outputs total of each problem done and overall total
                                    // problem
   {
      int tCounter = aCounter + sCounter + dCounter + mCounter;
      System.out.println("Calculator Report");
      System.out.println("Addition problems: " + aCounter);
      System.out.println("Subtraction problems: " + sCounter);
      System.out.println("Division problems: " + dCounter);
      System.out.println("Multiplication problems: " + mCounter);
      System.out.println("Total problems: " + tCounter);
   }

   public static void main(String[] args) // Main Method: Calls constructor, printIntro, calculate, print report
   {
      printIntro();
      calculate();
      printReport();
   }
}