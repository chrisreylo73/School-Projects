/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 02 - PlanetQuestDriver Class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlanetQuestDriver {

    public static final String FILE_NAME = "planets.txt";

    public static void main(String[] args) throws FileNotFoundException {

        PlanetQuest pq = new PlanetQuest();

        // read all planets from the input file
        Scanner in = new Scanner(new FileInputStream(FILE_NAME));
        int nPlanets = in.nextInt();
        for (int i = 0; i < nPlanets; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Planet planet = new Planet(x, y);
            pq.addPlanet(planet);
        }
        in.close();

        // print planet quest
        System.out.println(pq);
    }
}
