/*
 Program name:Initials
 Description: This program asks for 3 inputs (first, middle and last name) in order to grab the index of (0) from all three inputs to create initials.
 Author: Christian Lopez
 Date: 02/16/2020
 Instructor: Dr. Gurka
 Section: T/R 4:00pm to 6:00pm
 */

import java.util.*;

public class Initials {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter your first name here: ");
      String firstName = keyboard.nextLine();
      System.out.println("Enter your middle name here: ");
      String middleName = keyboard.nextLine();
      System.out.println("Enter in your last name here: ");
      String lastName = keyboard.nextLine();
      char firstInitial = firstName.charAt(0);
      char middleInitial = middleName.charAt(0);
      char lastInitial = lastName.charAt(0);
      System.out.println("Your name is: " + firstName + " " + middleName + " " + lastName);
      System.out.println("Your initials are: " + firstInitial + ". " + middleInitial + ". " + lastInitial + ".");
   }
}
