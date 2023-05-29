/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 11 - PopulationsDriver class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Key;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PopulationsDriver {

    private static final String FILE_NAME = "population.csv";
    private TreeMap<String, Integer> pops;

    public PopulationsDriver() throws FileNotFoundException {
        pops = new TreeMap<>();
        loadData();
    }

    // TODOd: finish the implementation of the method
    // this method should read all of the population data from "populations.csv into the hashtable "pops"
    public void loadData() throws FileNotFoundException {
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
    public int getPopulation(String state){
        return pops.get(state);
    }

    // TODOd: build a string with all of the state populations (one state per line)
    public String toString() {
        String str = "";

        // TODOd: first use keySet to get a Set reference of the keys
        // TODOd: then get an iterator from the set of keys
        Set<String> keys = pops.keySet();
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String key = it.next();
            str += key + "," + pops.get(key) + "\n";
        }
        // TODOd: iterate over the keys and build a string with the (state, pop) pairs


        // return the generated string
        return str;
    }

    public static void main(String[] args) throws FileNotFoundException {
        PopulationsDriver pd = new PopulationsDriver();
        System.out.println("Population of CO = " + pd.getPopulation("CO"));
        System.out.println(pd);
    }
}
