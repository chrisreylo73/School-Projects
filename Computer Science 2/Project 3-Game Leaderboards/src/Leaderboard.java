
/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - Leaderboard class
 * Name(s):
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class Leaderboard {

    private static final String FILE_NAME = "../players.csv";
    private BinaryTree boards[];

    // TODO: finish the implementation of the method
    public Leaderboard() throws FileNotFoundException {

        // TODOd: initialize one BinaryTree for each game (must use "boards" instance
        // variable)
        boards = new BinaryTree[Game.values().length];
        for (int i = 0; i < 3; i++) {
            boards[i] = new BinaryTree();
        }
        // TODOd: add all players in "players.csv" to the right BinaryTree based on the
        // games that they are playing
        Scanner in = new Scanner(new FileInputStream(FILE_NAME));
        while (in.hasNextLine()) {
            String[] playerAttributes = in.nextLine().split(",");
            Player current = new Player(playerAttributes[0], Integer.parseInt(playerAttributes[2]));
            if (Integer.parseInt(playerAttributes[1]) == 0)
                boards[0].add(current);
            else if (Integer.parseInt(playerAttributes[1]) == 1)
                boards[1].add(current);
            else
                boards[2].add(current);
        }
        in.close();

    }

    // TODOd: add the player with the given name and score to the correct binary
    // tree depending on the informed game parameter (to simplify, assume that the
    // given player is NOT currently in the binary tree)
    public void add(final String name, final Game game, int score) {
        Player current = new Player(name, score);
        if (game.getValue() == 0)
            boards[0].add(current);
        else if (game.getValue() == 1)
            boards[1].add(current);
        else
            boards[2].add(current);

    }

    // TODOd: display the BinaryTree associated with the given game
    public void list(final Game game) {
        if (game.getValue() == 1)
            System.out.println(game.name() + " Leaderboard: ");
        else if (game.getValue() == 0)
            System.out.println(game.name() + " Leaderboard: ");
        else
            System.out.println(game.name() + " Leaderboard: ");

        System.out.println(boards[game.getValue()]);
    }

    // TODO: save all binary trees into "players.csv"
    public void save() throws FileNotFoundException {
        PrintStream output = new PrintStream(FILE_NAME);
        for (int i = 0; i < Game.values().length; i++)
            output.println(boards[i]);
        output.close();
        System.out.println("done!");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Leaderboard lb = new Leaderboard();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Options: [list | add | save | exit]");
            System.out.print("? ");
            String option = sc.nextLine();
            if (option.equals("list")) {
                System.out.println("game? ");
                Game game = Game.values()[Integer.parseInt(sc.nextLine())];
                lb.list(game);
            } else if (option.equals("add")) {
                System.out.println("name? ");
                String name = sc.nextLine();
                System.out.println("game? ");
                Game game = Game.values()[Integer.parseInt(sc.nextLine())];
                System.out.println("score? ");
                int score = Integer.parseInt(sc.nextLine());
                lb.add(name, game, score);
            } else if (option.equals("save"))
                lb.save();
            else
                break;
        }
    }
}
