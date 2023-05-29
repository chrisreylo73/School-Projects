/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Prg01 - MoleculeDriver Class
 */

public class MoleculeDriver {

    public static void main(String[] args) {

        // creating "Carbon Dioxide: CO_2"
        Element C = new Element("C", "carbon");
        Element O = new Element("O", "oxygen");
        Molecule co2 = new Molecule("Carbon Dioxide");
        co2.add(O, 2);
        co2.add(C);
        System.out.println(co2);

        // creating "Caffeine: C_8H_10N_4O_2"
        Element N = new Element("N", "nitrogen");
        Element H = new Element("H", "hydrogen");
        Molecule caffeine = new Molecule("Caffeine");
        caffeine.add(N, 4);
        caffeine.add(O, 2);
        caffeine.add(H, 10);
        caffeine.add(C, 8);
        System.out.println(caffeine);

        // TODO: create your favorite molecule
        /*H = new Element("H", "hydrogen");
        O = new Element("O", "oxygen");
        Molecule h2o = new Molecule("Water");
        h2o.add(O);
        h2o.add(H, 2);
        System.out.println(h2o);*/

    }

}
