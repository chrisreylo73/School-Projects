/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - PlayersGenerator class
 * Name(s):
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class PlayersGenerator {

    private static final String FILE_NAME = "players.csv";
    private static final String[] PLAYERS = {"GandulaMaster", "DnknDonuts", "EdgarAllenPoo", "AllGoodNamesRGone", "Avocadorable", "FrostedCupcake", "Unnecessary", "PuppiesnKittens", "TheKidsCallMeBoss", "ToastCrunch", "IsaacAsiMove", "IRobot"};
    private static final int MAX_SCORES = 1000;

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(FILE_NAME));
        Random r = new Random();
        for (int i = 0; i < PLAYERS.length; i++) {
            String name = PLAYERS[i];
            int games = r.nextInt(Game.values().length) + 1;
            for (int j = 0; j < games; j++) {
                int score = r.nextInt(MAX_SCORES) + 1;
                out.println(name + "," + j + "," + score);
            }
        }
        out.close();
    }

}
