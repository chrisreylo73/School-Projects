import java.util.Scanner; //Getting the Scanner class

public class Quizes {
   private double average;
   private String gradeLetter;
   private String username;
   private double total;
   private int command;
   private int[] grade;
   private double percent;

   public Quizes() {
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

   public static void main(String[] args) // Main Method: Calls constructor, printIntro, calculate, print report
   {
      Quizes run = new Quizes();
      run.printIntro();
      run.calculate();
      run.gradeLetter();
      run.printReport();
   }
}