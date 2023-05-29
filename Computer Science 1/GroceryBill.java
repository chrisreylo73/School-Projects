
/*
 Program Name: Grocery Bill
 Description: The program calculates your grocery bill including tax and sale prices.
 Author: Christian Lopez
 Date: 03/11/2020
 Instructor: Dr. Gurka
 Section: T/R 4:00pm to 6:00pm
 */
import java.util.Scanner; //Getting the Scanner class
import java.util.ArrayList;

public class GroceryBill {
   private ArrayList<String> productList = new ArrayList<String>();
   private ArrayList<Double> priceList = new ArrayList<Double>();
   private ArrayList<Double> salesList = new ArrayList<Double>();
   private double total;
   private double finalBill;
   private String purchases;
   private String command;
   private String answer;
   private Scanner sc = new Scanner(System.in);
   private int counter;
   private double tax;

   public GroceryBill() {
      Scanner sc = new Scanner(System.in);
      purchases = null;
      total = 0;
      finalBill = 0;
      command = "YES";
      answer = null;
      counter = 0;
      tax = 0;
   }

   public void printIntro() {
      System.out.println("This program calculates your grocery bill");
   }

   public ArrayList<String> groceryList() {
      while (command.equals("YES")) {
         System.out.println("Please enter your item name below");
         productList.add(sc.nextLine());
         System.out.println("Please enter the price of the item");
         priceList.add(Double.parseDouble(sc.nextLine()));
         System.out.println("Is the item on sale?");
         answer = sc.nextLine();
         answer = answer.toUpperCase();
         if (answer.equals("YES")) {

            salesList.add(priceList.get(counter) * 0.8);
         } else if (answer.equals("NO")) {
            salesList.add(0.0);
         }

         System.out.println("Would you like to enter another item?");
         command = sc.nextLine();
         command = command.toUpperCase();
         counter++;
      }
      return productList;
   }

   public void printReport() {
      System.out.println("Grocery Bill");
      System.out.println("");
      System.out.println("Purchases");
      for (int counter = 0; counter < productList.size(); counter++) {
         if (salesList.get(counter) == 0) {
            System.out.printf(productList.get(counter) + ": $%.2f\n", priceList.get(counter));
            total = total + priceList.get(counter);
         } else {
            System.out.printf(productList.get(counter) + ": $%.2f" + "   SALE: $%.2f\n", priceList.get(counter),
                  salesList.get(counter));
            total = total + salesList.get(counter);
         }
      }
      tax = total * 0.07;
      finalBill = tax + total;
      System.out.println("");
      System.out.printf("Total: $%.2f\n", total);
      System.out.printf("Tax (7%%): $%.2f\n", tax);
      System.out.printf("Final Bill: $%.2f\n", finalBill);
   }

   public static void main(String[] args) // Main Method: Calls constructor, printIntro, calculate, print report
   {
      GroceryBill run = new GroceryBill();
      run.printIntro();
      run.groceryList();
      run.printReport();
   }

}
