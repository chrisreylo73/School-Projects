/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 03 - MontyHall Class
 */

import java.util.Random;
import java.util.Scanner;

public class MontyHall {

    public static final int NUMBER_DOORS = 3;

    public static void main(String[] args) {

        // doors is a static array of true/false values (true means a car is behind the door)
        boolean doors[] = new boolean[NUMBER_DOORS];

        // TODO: randomly set a car behind one of the doors
        // must save the door index in a variable named "prize"



        // ask the user to choose a door
        Scanner sc = new Scanner(System.in);
        System.out.println("Which door [0-2]? ");
        int choice = sc.nextInt();

        // TODO: randomly pick a door to reveal that is different than the user's choice and has a goat
        // must save revealed door index in a variable named "revealed"
        

        // show all the doors
        String s = "";
        for (int i = 0; i < NUMBER_DOORS; i++) {
            s += "[";
            if (i == revealed)
                s+= "Goat";
            s += "] ";
        }
        System.out.println(s);

        // ask if the user wants to pick a different door
        System.out.println("Which door [0-2]? ");
        choice = sc.nextInt();

        // show all the doors
        s = "";
        for (int i = 0; i < NUMBER_DOORS; i++) {
            s += "[";
            if (i == revealed)
                s+= "Goat";
            if (i == choice) {
                if (doors[i])
                    s += "Car";
                else
                    s += "Goat";
            }
            s += "] ";
        }
        System.out.println(s);
    }
}
