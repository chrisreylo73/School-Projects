import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class RouterAlgorithm_two {
   private String fileName = "topo.txt";
   private File inputFileName = new File(fileName);
   private Scanner inputFile = new Scanner(inputFileName);
   private String[] routerArray;
   private int[][] linkPairs;
   private double infinity = Double.POSITIVE_INFINITY;
   private int inf = (int) infinity;
   private Scanner sc = new Scanner(System.in);
   private String line;
   private int numRouters;
   private int[][] matrix;
   private int countRows;
   private ArrayList<String> nPrime = new ArrayList<String>();
   private ArrayList<String> yPrime;
   private int[] distanceCost;
   private int[] previousRouters;
   private ArrayList<Integer> routerNumbers = new ArrayList<Integer>();

   public RouterAlgorithm_two() throws IOException {
      this.intro();
      // this.rowCounter();
      this.extraction();
   }

   public void intro() {
      this.rowCounter();
      System.out.println("Enter in the total number of routers (MUST BE >= 2): ");
      numRouters = sc.nextInt();

      while (numRouters < 2) {
         System.out.println("Entered value must be greater than or equal to 2.");
         System.out.println("Enter in the total number of routers (MUST BE >= 2): ");
         numRouters = sc.nextInt();
      }

      // Adds all Router value numbers to a list
      for (int i = 0; i < numRouters; i++) {
         routerNumbers.add(i);
      }

      linkPairs = new int[countRows][];
      routerArray = new String[countRows];
   }

   public void rowCounter() {
      this.countRows = 0;
      while (inputFile.hasNextLine()) {
         countRows++;
         inputFile.nextLine();
      }
      System.out.println(countRows);
      try {
         inputFile = new Scanner(inputFileName);
      } catch (IOException e) {
      }
   }

   public void errorResponse() {
      Scanner tempSc = new Scanner(System.in);
      System.out.println("The file " + fileName + " had some errors.");
      System.out.println("Please enter new file name. ");
      try {
         this.fileName = tempSc.nextLine();
         this.inputFileName = new File(this.fileName);
         this.inputFile = new Scanner(this.inputFileName);
         this.intro();
         this.extraction();
      } catch (IOException e) {
         System.out.println("The file you entered cannot be located. Please try again.");
         this.errorResponse();
      }
   }

   public void extraction() {
      int i = 0;
      line = inputFile.nextLine();
      boolean fileComplete = false;

      while (fileComplete == false) {
         if (!inputFile.hasNextLine()) {
            fileComplete = true;
         }

         /* Splits each line of topo.txt file */
         String[] link = new String[3];
         link = line.split("\t");

         /* Extracts the first 2 feilds of each line (The router numbers) */
         int[] tempLink = { Integer.parseInt(link[0]), Integer.parseInt(link[1]), Integer.parseInt(link[2]) };
         linkPairs[i] = tempLink;

         /* Extracts the 3rd feild of each line (The cost of each link) */

         if (linkPairs[i][2] < 0 || linkPairs[i][0] > numRouters || linkPairs[i][1] > numRouters || linkPairs[i][0] < 0
               || linkPairs[i][1] < 0) {
            inputFile.close();
            System.out.println("Error at row " + (i + 1) + " " + linkPairs[i][0] + "," + linkPairs[i][1] + " Cost = "
                  + linkPairs[i][2]);
            this.errorResponse();
            break;
         }
         System.out.println(linkPairs[i][0] + "," + linkPairs[i][1] + " Cost = " + linkPairs[i][2]);
         i++;
         if (inputFile.hasNextLine()) {
            line = inputFile.nextLine();
         }

      }
   }

   public void costMatrix() {
      matrix = new int[numRouters][numRouters];
      for (int x = 0; x < numRouters; x++) {
         for (int y = 0; y < numRouters; y++) {
            matrix[x][y] = 100;
         }
      }

      for (int x = 0; x < numRouters; x++) {
         for (int y = 0; y < numRouters; y++) {
            for (int i = 0; i < countRows; i++) {
               if (x == y) {// Works.
                  matrix[x][y] = 0;
               } else if (linkPairs[i][0] == x && linkPairs[i][1] == y) {
                  matrix[x][y] = linkPairs[i][2];
               } else if (linkPairs[i][0] == y && linkPairs[i][1] == x) {
                  matrix[x][y] = linkPairs[i][2];
               }

            }
         }
      }

      System.out.print("\n    ");
      for (int i = 0; i < numRouters; i++) {
         System.out.print("V" + i + " ");
      }
      System.out.println();

      for (int x = 0; x < numRouters; x++) {
         System.out.print("V" + x + ": ");
         for (int y = 0; y < numRouters; y++) {
            System.out.print(matrix[x][y] + ", ");
         }
         System.out.println();
      }
   }

   public void dijsktraAlgorithm() {
      // Init
      distanceCost = new int[numRouters];
      previousRouters = new int[numRouters];
      for (int i = 0; i < numRouters; i++) {
         // System.out.print(matrix[i][0]);
         distanceCost[i] = matrix[i][0];
         if (matrix[i][0] == -1) {
            previousRouters[i] = -1;
         } else {
            previousRouters[i] = 0;
         }
         System.out.println(distanceCost[i]);
      }

      for (int x = 0; x < numRouters; x++) {
         // yPrime = new ArrayList<String>()
         for (int y = 0; y < numRouters; y++) {
            if (y == x) {
               System.out.println("Skipped");
            } else if ((matrix[x][y] + distanceCost[y]) < distanceCost[x]) {
               previousRouters[x] = y;
               distanceCost[x] = matrix[x][y] + distanceCost[y];
               System.out.println("Just updated previousRourters[" + x + "] to " + y + " and distance[" + x + "] to "
                     + matrix[x][y] + "+" + distanceCost[y] + "= " + (matrix[x][y] + distanceCost[y]));
            } else if (matrix[x][y] < distanceCost[y]) {
               previousRouters[y] = x;
               distanceCost[y] = matrix[x][y] + distanceCost[x];
               System.out.println("Second: Just updated previousRourters[" + y + "] to " + x + " and distance[" + y
                     + "] to " + matrix[x][y] + "+" + distanceCost[y] + "= " + distanceCost[y]);
            } else {
               System.out.println("Did nothing. distanceCost[" + y + "] = " + distanceCost[y]);
            }
         }
         nPrime.add("V" + x);

         System.out.println("N' = " + nPrime.toString());
         System.out.println("Di = " + Arrays.toString(distanceCost));
         System.out.println("Pi = " + Arrays.toString(previousRouters));

         System.out.println("End of iteration " + (x + 1) + "\n\n");

      }

      for (int i = 0; i < numRouters; i++) {
         System.out.println(
               "Distance from 0 to " + i + " is " + distanceCost[i] + " with last router = " + previousRouters[i]);
      }

   }

   public void forwardTable() {
      System.out.printf("%-20s%s", "Destination", "Link\n");
      for (int i = 1; i < numRouters; i++) {
         // int prevInteger = -1 ;
         int integer = previousRouters[i];
         int prevInteger = i;
         String links = "(V" + integer + ",V" + i + ")";
         while (integer >= 0) {
            if (integer == 0) {
               // prevInteger = integer;
               links = "(V" + integer + ",V" + prevInteger + ")" + "1st if" + links;
               break;
            } else {// links = ", V" + integer + links;
               prevInteger = integer;
               integer = previousRouters[integer];
               links = "(V" + integer + ",V" + prevInteger + ")" + links;
               integer = previousRouters[integer];
            }
         }
         System.out.printf("%-20s%s", "V" + i, links + "\n");
      }
   }

   public static void main(String[] args) throws IOException {
      RouterAlgorithm_two routerInstance = new RouterAlgorithm_two();
      routerInstance.costMatrix();
      routerInstance.dijsktraAlgorithm();
      routerInstance.forwardTable();
   }

}
