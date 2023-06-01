/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 16 - Insertion Sort (solved)
 */

import java.util.Arrays;

public class InsertionSort {

    // TODOd: implement the insertion sort algorithm
    public static void insertionSort(int data[]) {
        for (int i = 1; i < data.length; i++) {
            int j = i;
            int k = i - 1;
            while (k >= 0) {
                if (data[j] < data[k]) {
                    int temp = data[j];
                    data[j] = data[k];
                    data[k] = temp;
                    j = k;
                    k--;
                } else
                    break;
            }
        }
    }

    public static void main(String[] args) {

        int data[] = { 13, 12, 84, 79, 10, 77, 56, 1, 34, 27, 3 };
        System.out.println(Arrays.toString(data));
        insertionSort(data);
        System.out.println(Arrays.toString(data));
    }
}
