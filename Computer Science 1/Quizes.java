
/*
 Program Name: Quizzes
 Description: The program calculates the average quiz grade of 5 quizes. 
 Then it prints out a report relaying the grade letter, 
 each grade per quiz, average grade overall and the percentage for that grade. 
 Author: Christian Lopez
 Date: 03/11/2020
 Instructor: Dr. Gurka
 Section: T/R 4:00pm to 6:00pm
 */
import java.util.Scanner;

public class Quizzes {
   private double average;
   private String gradeLetter;
   private String username;
   private double total;
   private int command;
   private int[] grade;
   private double percent;

   public Quizzes() {
      Scanner sc = new Scanner(System.in);
      gradeLetter = null;
      username = null;
      total = 0;
      percent = 0;
      grade = new int[5];
   }

   public void printIntro() {
      System.out.println("This program calculates the average grade of all your quiz grades");
      System.out.println("Please Enter your username below ");
   }

   public int[] calculate() {
      Scanner sc = new Scanner(System.in);
      username = sc.nextLine();
      System.out.println(username + " please enter in your 5 quiz grades (25 point scale) below");
      for (int i = 0; i < 5; i++) {
         command = sc.nextInt();
         grade[i] = command;
         total = total + command;
      }
      return grade;
   }

   public String gradeLetter() {
      average = total / grade.length;
      percent = (average / 25) * 100;
      if (percent >= 90 && percent <= 100) {
         gradeLetter = "A";
      } else if (percent >= 80 && percent <= 89) {
         gradeLetter = "B";
      } else if (percent >= 70 && percent <= 79) {
         gradeLetter = "C";
      } else if (percent >= 60 && percent <= 69) {
         gradeLetter = "D";
      } else {
         gradeLetter = "F";
      }
      return gradeLetter;
   }

   public void printReport() {
      System.out.println("Quiz Report for " + username);
      System.out.println("");
      System.out.println("Quiz #1: " + grade[0]);
      System.out.println("Quiz #2: " + grade[1]);
      System.out.println("Quiz #3: " + grade[2]);
      System.out.println("Quiz #4: " + grade[3]);
      System.out.println("Quiz #5: " + grade[4]);
      System.out.println("");
      System.out.println("Quiz Average: " + average + " = " + percent + "%");
      System.out.println("Quiz Grade: " + gradeLetter);
   }

   public static void main(String[] args) 
      Quizzes run = new Quizzes();
      run.printIntro();
      run.calculate();
      run.gradeLetter();
      run.printReport();
   }
}