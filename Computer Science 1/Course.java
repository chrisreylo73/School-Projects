import java.io.*;
import java.util.Scanner;

public class Course {
   private String zeroReport;
   private double studentOneAvg;
   private double studentTwoAvg;
   private double studentThreeAvg;
   private double studentFourAvg;
   private double studentFiveAvg;
   private double averageHello;
   private double averageNumbers;
   private double averageArrays;
   private double averageAirplane;
   private double averageStrings;
   private String[] gradeLetter = new String[5];
   private String professorName;
   private String courseName;
   private int STUDENT_COUNT = 5;
   private int ASSIGN_COUNT = 5;
   private Assignment[][] courseMatrix = new Assignment[STUDENT_COUNT][ASSIGN_COUNT];
   private File inputFileName = new File("c:\\Java Files\\CourseInfo.txt");
   private Scanner inputFile = new Scanner(inputFileName);
   private FileWriter outputFileName = new FileWriter("c:\\Java Files\\CourseReport.txt");
   private PrintWriter outputFile = new PrintWriter(outputFileName);
   private String inputLine;
   private int counter;

   public Course() throws IOException {
      counter = 0;
      professorName = "Dr. Martinez";
      courseName = "Introduction to Thinking";
   }

   public void inputData() {
      inputLine = inputFile.nextLine();
      inputLine = inputFile.nextLine();
      for (int student = 0; student < STUDENT_COUNT; student++) {
         for (int assign = 0; assign < ASSIGN_COUNT; assign++) {
            String tempStudentName = inputFile.next();
            String tempAssignName = inputFile.next();
            int tempGrade = inputFile.nextInt();
            Assignment tempAssign = new Assignment(tempStudentName, tempAssignName, tempGrade);
            courseMatrix[student][assign] = tempAssign;
         }
      }
   }

   public void createReport() {
      outputFile.println(courseName + " taught by " + professorName);
      outputFile.println("Report created by Christian Lopez\n");
      for (int student = 0; student < 5; student++) {
         int assign = 0;
         outputFile
               .print("Student: " + courseMatrix[student][assign].getStudentName() + "\nAssignments: \n" + "       ");
         for (assign = 0; assign < 5; assign++) {
            outputFile.print(
                  courseMatrix[student][assign].getAssignName() + "-" + courseMatrix[student][assign].getGrade() + "%");
            if (!(assign == 4)) {
               outputFile.print(", ");
            } else {
               outputFile.println("\n");
            }
         }
      }
      outputFile.println(zeroReport);

      outputFile.println("\nThe class average on each assignment:");

      outputFile.println("       " + courseMatrix[0][0].getAssignName() + ": " + averageHello + "%");
      outputFile.println("       " + courseMatrix[0][1].getAssignName() + ": " + averageNumbers + "%");
      outputFile.println("       " + courseMatrix[0][2].getAssignName() + ": " + averageArrays + "%");
      outputFile.println("       " + courseMatrix[0][3].getAssignName() + ": " + averageAirplane + "%");
      outputFile.println("       " + courseMatrix[0][4].getAssignName() + ": " + averageStrings + "%");

      outputFile.println("\nStudent Grades: ");
      outputFile
            .println("       " + courseMatrix[0][0].getStudentName() + ", " + studentOneAvg + "%, " + gradeLetter[0]);
      outputFile
            .println("       " + courseMatrix[1][0].getStudentName() + ", " + studentTwoAvg + "%, " + gradeLetter[1]);
      outputFile
            .println("       " + courseMatrix[2][0].getStudentName() + ", " + studentThreeAvg + "%, " + gradeLetter[2]);
      outputFile
            .println("       " + courseMatrix[3][0].getStudentName() + ", " + studentFourAvg + "%, " + gradeLetter[3]);
      outputFile
            .println("       " + courseMatrix[4][0].getStudentName() + ", " + studentFiveAvg + "%, " + gradeLetter[4]);

      inputFile.close();
      outputFile.close();
   }

   public void reportAssignmentAverages() {
      double totalHello = 0.0;
      double totalNumbers = 0.0;
      double totalArrays = 0.0;
      double totalAirplane = 0.0;
      double totalStrings = 0.0;
      for (int assign = 0; assign < courseMatrix[0].length; assign++) {
         for (int student = 0; student < courseMatrix.length; student++) {
            if (assign == 0) {
               totalHello = totalHello + courseMatrix[student][0].getGrade();
               averageHello = totalHello / STUDENT_COUNT;
            } else if (assign == 1) {
               totalNumbers = totalNumbers + courseMatrix[student][1].getGrade();
               averageNumbers = totalNumbers / STUDENT_COUNT;
            } else if (assign == 2) {
               totalArrays = totalArrays + courseMatrix[student][2].getGrade();
               averageArrays = totalArrays / STUDENT_COUNT;
            } else if (assign == 3) {
               totalAirplane = totalAirplane + courseMatrix[student][3].getGrade();
               averageAirplane = totalAirplane / STUDENT_COUNT;
            } else if (assign == 4) {
               totalStrings = totalStrings + courseMatrix[student][4].getGrade();
               averageStrings = totalStrings / STUDENT_COUNT;
            }
         }
      }

   }

   public String reportZeros() {

      for (int student = 0; student < STUDENT_COUNT; student++) {
         for (int assign = 0; assign < ASSIGN_COUNT; assign++) {
            if (courseMatrix[student][assign].getGrade() == 0) {
               counter++;
            }
         }
      }
      zeroReport = "There were " + counter + " grades of zero.";
      return zeroReport;
   }

   public void reportStudentGrades() {
      double studentOneTotal = 0.0;
      double studentTwoTotal = 0.0;
      double studentThreeTotal = 0.0;
      double studentFourTotal = 0.0;
      double studentFiveTotal = 0.0;
      for (int student = 0; student < courseMatrix.length; student++) {
         for (int assign = 0; assign < courseMatrix[0].length; assign++) {
            if (student == 0) {
               studentOneTotal = studentOneTotal + courseMatrix[0][assign].getGrade();
               studentOneAvg = studentOneTotal / ASSIGN_COUNT;
            } else if (student == 1) {
               studentTwoTotal = studentTwoTotal + courseMatrix[1][assign].getGrade();
               studentTwoAvg = studentTwoTotal / ASSIGN_COUNT;
            } else if (student == 2) {
               studentThreeTotal = studentThreeTotal + courseMatrix[2][assign].getGrade();
               studentThreeAvg = studentThreeTotal / ASSIGN_COUNT;
            } else if (student == 3) {
               studentFourTotal = studentFourTotal + courseMatrix[3][assign].getGrade();
               studentFourAvg = studentFourTotal / ASSIGN_COUNT;
            } else if (student == 4) {
               studentFiveTotal = studentFiveTotal + courseMatrix[4][assign].getGrade();
               studentFiveAvg = studentFiveTotal / ASSIGN_COUNT;
            }

         }
      }
   }

   public void letterGrade() {
      double[] averageStudentGrades = { studentOneAvg, studentTwoAvg, studentThreeAvg, studentFourAvg, studentFiveAvg };
      for (int i = 0; i < averageStudentGrades.length; i++) {
         if (averageStudentGrades[i] >= 90 && averageStudentGrades[i] <= 100) {
            gradeLetter[i] = "A";
         } else if (averageStudentGrades[i] >= 80 && averageStudentGrades[i] <= 89) {
            gradeLetter[i] = "B";
         } else if (averageStudentGrades[i] >= 70 && averageStudentGrades[i] <= 79) {
            gradeLetter[i] = "C";
         } else if (averageStudentGrades[i] >= 60 && averageStudentGrades[i] <= 69) {
            gradeLetter[i] = "D";
         } else {
            gradeLetter[i] = "F";
         }
      }

   }

}