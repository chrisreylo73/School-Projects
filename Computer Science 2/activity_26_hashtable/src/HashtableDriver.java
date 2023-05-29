/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 26 - HashtableDriver class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashtableDriver {

    private static final String FILE_NAME = "students.csv";

    // TODO: there are 2 students #5568; which one do you think should be saved in
    // the hashtable?
    public static void main(String[] args) throws FileNotFoundException {
        Hashtable<Integer, Student> ht = new Hashtable<>();
        Scanner in = new Scanner(new FileInputStream(FILE_NAME));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String data[] = line.split(",");
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            Student student = new Student(id, name);
            ht.put(id, student);
        }
        in.close();
        System.out.println(ht);
    }
}
