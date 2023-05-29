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
   private double extractNum1;
   private double extractNum2;
   private double extractNum3;
   private double extractNum4;
   private File inputFileName = new File("c:\\Java Files\\Project 04 - input.txt");
   private Scanner inputFile = new Scanner(inputFileName);
   FileWriter outputFileName = new FileWriter("c:\\Java Files\\Project 04 - output.txt");
   PrintWriter outputFile = new PrintWriter(outputFileName);

   public Filez() throws IOException
   {
      extractNum1 = 0;
      extractNum2 = 0;
      extractNum3 = 0;
      extractNum4 = 0;
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

   public int reading() // throws IOException
   {
      inputLine = inputFile.nextLine();
      inputLine = inputFile.nextLine();
      comma1 = inputLine.indexOf(",") + 1;
      comma2 = inputLine.substring(comma1).indexOf(",") + comma1 + 1;
      comma3 = inputLine.substring(comma2).indexOf(",") + comma2 + 1;
      qtr = inputLine.substring(0, (comma1 - 1));
      areaTitle = inputLine.substring(comma1, (comma2 - 1));
      ownTitle = inputLine.substring(comma2, (comma3 - 1));
      qtryWages = inputLine.substring(comma3);
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
            rowCounter++;
            fedCounterQ1++;
            fedWagesTotalQ1 = fedWagesTotalQ1 + qtryWagesD;
            // System.out.println(inputLine);
         } else if (areaTitle.contains("Statewide") && (ownTitle.equals("State Government")) && qtr.equals("1")) {
            qtryWagesD = Double.parseDouble(qtryWages);
            rowCounter++;
            stateCounterQ1++;
            stateWagesTotalQ1++;
            stateWagesTotalQ1 = stateWagesTotalQ1 + qtryWagesD;
            // System.out.println(inputLine);
         } else if (areaTitle.contains("Statewide") && (ownTitle.equals("State Government")) && qtr.equals("2")) {
            qtryWagesD = Double.parseDouble(qtryWages);
            rowCounter++;
            stateCounterQ1++;
            stateWagesTotalQ2++;
            stateWagesTotalQ2 = stateWagesTotalQ2 + qtryWagesD;
            // System.out.println(inputLine);
         } else if (areaTitle.contains("Statewide") && (ownTitle.equals("Federal Government")) && qtr.equals("2")) {
            qtryWagesD = Double.parseDouble(qtryWages);
            rowCounter++;
            fedCounterQ2++;
            fedWagesTotalQ2 = fedWagesTotalQ2 + qtryWagesD;
            // System.out.println(inputLine);
         } else {
            break;
         }
         inputLine = inputFile.nextLine();

      }
      return rowCounter;
   }

   public void reading_2() {
      // System.out.println(inputLine);
      comma1 = inputLine.indexOf(",") + 1;
      comma2 = inputLine.substring(comma1).indexOf(",") + comma1 + 1;
      comma3 = inputLine.substring(comma2).indexOf(",") + comma2 + 1;
      qtr = inputLine.substring(0, (comma1 - 1));
      areaTitle = inputLine.substring(comma1, (comma2 - 1));
      ownTitle = inputLine.substring(comma2, (comma3 - 1));
      qtryWages = inputLine.substring(comma3);

      while (areaTitle.contains("U.S. TOTAL")) {
         System.out.println(inputLine);
         comma1 = inputLine.indexOf(",") + 1;
         comma2 = inputLine.substring(comma1).indexOf(",") + comma1 + 1;
         comma3 = inputLine.substring(comma2).indexOf(",") + comma2 + 1;
         qtr = inputLine.substring(0, (comma1 - 1));
         areaTitle = inputLine.substring(comma1, (comma2 - 1));
         ownTitle = inputLine.substring(comma2, (comma3 - 1));
         qtryWages = inputLine.substring(comma3);
         System.out.println(qtr + "  " + areaTitle + "  " + ownTitle + "  " + qtryWages);
         if (ownTitle.equals("Federal Government") && qtr.equals("1")) {
            extractNum1 = Double.parseDouble(qtryWages);
            System.out.println(qtryWages);
         } else if (ownTitle.equals("State Government") && qtr.equals("1")) {
            extractNum2 = Double.parseDouble(qtryWages);
         } else if (ownTitle.equals("State Government") && qtr.equals("2")) {
            extractNum3 = Double.parseDouble(qtryWages);
         } else if (ownTitle.equals("Federal Government") && qtr.equals("2")) {
            extractNum4 = Double.parseDouble(qtryWages);
         }

         inputLine = inputFile.nextLine();
      }
   }

   public void printInfo() {
      System.out.println(fedWagesTotalQ1);
      System.out.println(fedWagesTotalQ2);
      System.out.println(stateWagesTotalQ1);
      System.out.println(stateWagesTotalQ2);
      System.out.println(extractNum1);
      System.out.println(extractNum2);
      System.out.println(extractNum3);
      System.out.println(extractNum4);
   }

   public static void main(String[] args) throws IOException {
      Files run = new Files();
      run.reading();
      run.reading_2();
      run.printInfo();

   }

}