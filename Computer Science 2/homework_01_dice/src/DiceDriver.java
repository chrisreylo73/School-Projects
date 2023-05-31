/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 01 - DiceDriver
 */

public class DiceDriver {

    public static void main(String[] args) {
        Dice d = new Dice();
        System.out.println(d);
        for (int i = 0; i < 10; i++) {
            d.roll();
            System.out.println(d);
        }
    }
}
