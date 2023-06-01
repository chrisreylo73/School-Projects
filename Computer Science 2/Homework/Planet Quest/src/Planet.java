/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 02 - Planet Class
 */

public class Planet {

    private int x, y;

    public Planet() {
        x = y = 0;
    }

    public Planet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Planet other) {
        return Math.sqrt( Math.pow(getX() - other.getX(), 2.) + Math.pow(getY() - other.getY(), 2.));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
