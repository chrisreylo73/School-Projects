/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 01 - BSheep
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BSheep {

    static final int MIN_NUM_SHEEP = 2;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("sheep.txt"));
        int nSheep = sc.nextInt();
        if (nSheep < MIN_NUM_SHEEP)
            System.out.println("Invalid input! We need at least " + MIN_NUM_SHEEP + " sheep to build a fence!");
        else {
//            System.out.println(nSheep);
            int xMin, yMin, xMax, yMax;

            // 1st sheep coordinates (used to set min and max values)
            xMin = xMax = sc.nextInt();
            yMin = yMax = sc.nextInt();

            for (int i = 1; i < nSheep; i++) {
                try {
                    int x = sc.nextInt();
                    if (x < xMin)
                        xMin = x;
                    else if (x > xMax)
                        xMax = x;
                    int y = sc.nextInt();
                    if (y < yMin)
                        yMin = y;
                    else if (y > yMax)
                        yMax = y;
                }
                catch (Exception ex) {
                    System.out.println("Error, check your input file!");
                    System.exit(1);
                }
            }

            // print the fence coordinates
            System.out.println("(" + xMin + ", " + yMin + ")");
            System.out.println("(" + xMax + ", " + yMin + ")");
            System.out.println("(" + xMax + ", " + yMax + ")");
            System.out.println("(" + xMin + ", " + yMax + ")");
        }
    }
} // end of class definition
