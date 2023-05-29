/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 10 - PopulationsDriver class
 */

import java.io.FileInputStream;
/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 10 - PopulationsDriver class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PopulationsDriver {

    private static final String FILE_NAME = "population.csv";
    private Hashtable<String, Integer> pops;

    public PopulationsDriver(){
        pops = new Hashtable<>();
        loadData();
    }

    // TODOd: finish the implementation of the method
    // this method should read all of the population data from "populations.csv into the hashtable "pops"
    public void loadData() {
        try {
            Scanner in = new Scanner(new FileInputStream(FILE_NAME));
            while (in.hasNextLine()) {
                String nextLine[] = in.nextLine().split(",");
                pops.put(nextLine[0], Integer.parseInt(nextLine[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // TODOd: return the state population by querying the hashtable "pops"
    public int getPopulation(String state) {
        return pops.get(state);
    }

    public static void main(String[] args) {
        PopulationsDriver pd = new PopulationsDriver();
        System.out.println("Population of CO = " + pd.getPopulation("CO"));
        //System.out.println(pd);
    }
}