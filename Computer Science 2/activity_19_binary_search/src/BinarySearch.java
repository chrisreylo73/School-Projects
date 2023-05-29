/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 19 - BinarySearch
 */

import java.util.*;

public class BinarySearch {

    // TODO: implement an non-recursive version of a binary search
    static boolean bsearch(int data[], int el) {
        int begining = 0;
        int middle = 0;
        int last = data.length - 1;
        while (begining <= last){
            middle = (begining + last) /2;
            if(data[middle] < el){
                begining = middle + 1;

            }
            else if(data[middle] > el){
                last = middle - 1;
            }
            else {
                 return true;
            }
        }
        return false;
    }


    // TODO: implement a recursive version of a binary search
    static boolean bsearch(int data[], int start, int end, int el) {

        // base case #1 (parameter validation)


        // get the middle element

        // is middle the element we are searching for?


        // base case #2


        // is the element greater than middle -> go right then

        // if not, go left

        return false;
    }

    public static void main(String[] args) {
        int data[] = new int[11];
        Random r = new Random();
        for (int i = 0; i < 11; i++)
            data[i] = r.nextInt(11);
        Arrays.sort(data); // in-place sort available from Arrays class
        System.out.println(Arrays.toString(data));
        int el = 7;
//        if (bsearch(data, el))
        if (bsearch(data, 0, data.length - 1, 27))
            System.out.println("Found!");
        else
            System.out.println("Not found!");
    }
}
