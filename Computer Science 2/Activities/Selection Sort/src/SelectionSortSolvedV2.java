/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 15 - Selection Sort (solved)
 */

import java.util.Arrays;

public class SelectionSortSolvedV2 {

    private static final int ASC = 0;
    private static final int DSC = 1;

    // TODOd: implement the selection sort algorithm
    public static void selectionSort(int data[], int order) {
        int i = 0;
        for (int j = 0; j < data.length; j++) {
            int minMax = j;
            for (int k = j + 1; k < data.length; k++)
                if (order == ASC) {
                    if (data[k] < data[minMax])
                        minMax = k;
                }
                else {
                    if (data[k] > data[minMax])
                        minMax = k;
                }
            int temp = data[i];
            data[i] = data[minMax];
            data[minMax] = temp;
            i++;
        }
    }

    public static void main(String[] args) {

        int data[] = {13, 12, 84, 79, 10, 77, 56, 1, 34, 27, 3};
        System.out.println(Arrays.toString(data));
        selectionSort(data, DSC);
        System.out.println(Arrays.toString(data));
    }
}
