
/*
Project #4, CS 1050
Description: This program processes through the data in a fail, gathers the desired information, 
calculates the average wages and finds the differences betteen the U.S total wages and the total wages of the desired data in each quarter.
One the calculations are complete the new information is then outputed into a new file.
Author: Christian Lopez
Date: 03/11/2020
Instructor: Dr. Gurka
Section: T/R 4:00pm to 6:00pm
New Vocabulary Word: Loquacious - tending to talk a great deal
Inspirational Quote: "Give me six hours to chop down a tree and I will spend the first four sharpening the axe" - Abraham Lincoln 
Feb 12, 1809 - Apr 15, 1865
*/
import java.io.*;
import java.util.Scanner;

public class Files {
   private String inputLine;
   private int rowCounter;
   private double stateWagesTotalQ1;
   private double stateWagesTotalQ2;
   private double fedWagesTotalQ1;
   private double fedWagesTotalQ2;
   private int fedCounterQ1;
   private int fedCounterQ2;
   private int stateCounterQ1;
   private int stateCounterQ2;
   private String qtr;
   private String areaTitle;
   private String ownTitle;
   private String qtryWages;
   private int comma1;
   private int comma2;
   private int comma3;
   private double qtryWagesD;
   private double fedExtractQ1;
   private double stateExtractQ1;
   private double fedExtractQ2;
   private double stateExtractQ2;
   private File inputFileName = new File("c:\\Java Files\\Project 04 - input.txt");
   private Scanner inputFile = new Scanner(inputFileName);
   FileWriter outputFileName = new FileWriter("c:\\Java Files\\Project 04 - output.txt");
   PrintWriter outputFile = new PrintWriter(outputFileName);

   public Files() throws IOException {
      fedExtractQ1 = 0;
      stateExtractQ1 = 0;
      fedExtractQ2 = 0;
      stateExtractQ2 = 0;
      rowCounter = 0;
      stateWagesTotalQ1 = 0;
      stateWagesTotalQ2 = 0;
      fedWagesTotalQ1 = 0;
      fedWagesTotalQ2 = 0;
      fedCounterQ1 = 0;
      fedCounterQ2 = 0;
      stateCounterQ1 = 0;
      stateCounterQ2 = 0;
      qtr = null;
      areaTitle = "";
      ownTitle = null;
      qtryWages = null;
      qtryWagesD = 0;
      comma1 = 0;
      comma2 = 0;
      comma3 = 0;
   }

   public int reading() {
      inputLine = inputFile.nextLine();
      inputLine = inputFile.nextLine();
      while (!inputLine.contains("U.S. TOTAL")) {
         comma1 = inputLine.indexOf(",") + 1;
         comma2 = inputLine.substring(comma1).indexOf(",") + comma1 + 1;
         comma3 = inputLine.substring(comma2).indexOf(",") + comma2 + 1;
         qtr = inputLine.substring(0, (comma1 - 1));
         areaTitle = inputLine.substring(comma1, (comma2 - 1));
         ownTitle = inputLine.substring(comma2, (comma3 - 1));
         qtryWages = inputLine.substring(comma3);
         if (areaTitle.contains("Statewide") && (ownTitle.equals("Federal Government")) && qtr.equals("1")) {
            qtryWagesD = Double.parseDouble(qtryWages);
            fedCounterQ1++;
            fedWagesTotalQ1 = fedWagesTotalQ1 + qtryWagesD;
         } else if (areaTitle.contains("Statewide") && (ownTitle.equals("State Government")) && qtr.equals("1")) {
            qtryWagesD = Double.parseDouble(qtryWages);
            stateCounterQ1++;
            stateWagesTotalQ1 = stateWagesTotalQ1 + qtryWagesD;
         } else if (areaTitle.contains("Statewide") && (ownTitle.equals("State Government")) && qtr.equals("2")) {
            qtryWagesD = Double.parseDouble(qtryWages);
            stateCounterQ2++;
            stateWagesTotalQ2 = stateWagesTotalQ2 + qtryWagesD;
         } else if (areaTitle.contains("Statewide") && (ownTitle.equals("Federal Government")) && qtr.equals("2")) {
            qtryWagesD = Double.parseDouble(qtryWages);
            fedCounterQ2++;
            fedWagesTotalQ2 = fedWagesTotalQ2 + qtryWagesD;
         }
         inputLine = inputFile.nextLine();

      }
      return rowCounter;
   }

   public void reading_2() {
      while (inputLine.contains("U.S. TOTAL")) {
         comma1 = inputLine.indexOf(",") + 1;
         comma2 = inputLine.substring(comma1).indexOf(",") + comma1 + 1;
         comma3 = inputLine.substring(comma2).indexOf(",") + comma2 + 1;
         qtr = inputLine.substring(0, (comma1 - 1));
         areaTitle = inputLine.substring(comma1, (comma2 - 1));
         ownTitle = inputLine.substring(comma2, (comma3 - 1));
         qtryWages = inputLine.substring(comma3);
         if (ownTitle.equals("Federal Government") && qtr.equals("1")) {
            fedExtractQ1 = Double.parseDouble(qtryWages);
         } else if (ownTitle.equals("State Government") && qtr.equals("1")) {
            stateExtractQ1 = Double.parseDouble(qtryWages);
         } else if (ownTitle.equals("State Government") && qtr.equals("2")) {
            stateExtractQ2 = Double.parseDouble(qtryWages);
         } else if (ownTitle.equals("Federal Government") && qtr.equals("2")) {
            fedExtractQ2 = Double.parseDouble(qtryWages);
         } else {
            break;
         }

         inputLine = inputFile.nextLine();
      }
   }

   public void printInfo() {
      outputFile.println(
            ",Federal Wages Total Q1," + "Federal Wages Total Q2," + "State Wages Total Q1," + "State Wages Total Q2");
      outputFile.println(
            "Totals:  ," + fedWagesTotalQ1 + "," + fedWagesTotalQ2 + "," + stateWagesTotalQ1 + "," + stateWagesTotalQ2);
      outputFile.println(
            "Extracted Totals:  ," + fedExtractQ1 + "," + fedExtractQ2 + "," + stateExtractQ1 + "," + stateExtractQ2);
      outputFile.println("Differences:  ," + (fedWagesTotalQ1 - fedExtractQ1) + "," + (fedWagesTotalQ2 - fedExtractQ2)
            + "," + (stateWagesTotalQ1 - stateExtractQ1) + "," + (stateWagesTotalQ2 - stateExtractQ2));
      if ((fedWagesTotalQ1 - fedExtractQ1) != 0) {
         outputFile.print(", ! ,");
      }
      if ((fedWagesTotalQ2 - fedExtractQ2) != 0) {
         outputFile.print(" ! ,");
      }
      if ((stateWagesTotalQ1 - stateExtractQ1) != 0) {
         outputFile.print(" ! ,");
      }
      if ((stateWagesTotalQ2 - stateExtractQ2) != 0) {
         outputFile.print(" ! ");
      }
      outputFile
            .println("\n\n\nAverages :  ," + (fedWagesTotalQ1 / fedCounterQ1) + "," + (fedWagesTotalQ2 / fedCounterQ2)
                  + "," + (stateWagesTotalQ1 / stateCounterQ1) + "," + (stateWagesTotalQ2 / stateCounterQ2));
      inputFile.close();
      outputFile.close();
   }

   public static void main(String[] args) throws IOException {
      Files run = new Files();
      run.reading();
      run.reading_2();
      run.printInfo();
   }
}