/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 15 - Selection Sort (solved)
 */

import java.util.Arrays;
import java.util.Random;

public class SelectionSortSolved {

    // TODOd: implement the selection sort algorithm
    public static void selectionSort(int data[]) {
        int i = 0;
        for (int j = 0; j < data.length; j++) {
            int min = j;
            for (int k = j + 1; k < data.length; k++)
                if (data[k] < data[min]){
                    System.out.println("hi");
                    min = k;
                }

            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
            i++;
        }
    }

    public static void main(String[] args) {

        int data[] = {4,3,2,1};
        System.out.println(Arrays.toString(data));
        selectionSort(data);
        System.out.println(Arrays.toString(data));
    }
}
