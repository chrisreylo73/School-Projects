/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - BinaryTree class
 */

import java.util.Arrays;
import java.util.Iterator;

public class BinaryTree implements Iterable<Player> {

    private BinNode root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // TODOd: add the given player to the binary tree based on the player's game score
    public void add(final Player player) {
        if(isEmpty()){
            root = new BinNode(player);
        }
        else {
            BinNode newNode = new BinNode(player);
            BinNode current = root;
            while (true) {
                if (player.compareTo(current.getPlayer()) < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft((newNode));
                        return;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    if (current.getRight() == null) {
                        current.setRight((newNode));
                        return;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
    }
    @Override
    public String toString() {
        Stack<BinNode> stack = new Stack<>();
        Iterator<Player> it = this.iterator();
        String outString = "";
        Player current = null;
        Player currentLowest = null;
        Player lastLowest = null;
        int lastLowestScore = 0;
        int counter = 0;
        while (it.hasNext()){
            counter ++;
            it.next();
        }
        /*System.out.println(counter);*/
        for(int i = 0  ; i < counter ; i++){
//            System.out.println("full run number " + i + "\n");
//            System.out.println("current is " + current + "\n");
//            System.out.println("current lowest is " + currentLowest + "\n");
//            System.out.println("lastLowest is " + lastLowest + "\n");
            Iterator<Player> itTwo = this.iterator();
            current = currentLowest = itTwo.next();
//            System.out.println("current is now " + current + "\n\n\n");
            for (int x = 0; x < counter ; x++){
                if (current.getScore() <= currentLowest.getScore() && current.getScore() > lastLowestScore ){
                    //System.out.println(current);
                    currentLowest = current;
                    current = itTwo.next();
                }
                else if(current.getScore() == currentLowest.getScore() && current.getScore() == stack.peek().getPlayer().getScore()){
                    if(itTwo.hasNext()) {
                        current = itTwo.next();
                        currentLowest = current;
                    }
                    else
                        break;
                }
                else{
                    current = itTwo.next();
                }
            }
            lastLowest = currentLowest;
            lastLowestScore = currentLowest.getScore();
            BinNode lowestBin = new BinNode(lastLowest);
            stack.push(lowestBin);
        }
        while(!stack.isEmpty()) {
            outString += stack.pop().getPlayer() + "\n";
        }
        return  outString;

    }


    // TODOd: return an iterator for the binary tree to be used to save the tree in persistent media.
    @Override
    public Iterator<Player> iterator() {
        return new Iterator<Player>() {
            private Stack<BinNode> stack = new Stack<>(root);

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Player next() {
                if (!stack.isEmpty()) {
                    BinNode current = stack.pop();
                    if (current.getRight() != null)
                        stack.push(current.getRight());
                    if (current.getLeft() != null)
                        stack.push(current.getLeft());
                    return current.getPlayer();
                }
                else
                    return null;
            }
        };
    }
}

/*
    // TODO: return a string representation of the binary tree showing all players (one per line) in descending order of scores
    @Override
    public String toString(){
        Iterator<Player> it = this.iterator();
        String str = "";
        if(!it.hasNext()){
            str += it.next() + "\n";
        }
        while (it.hasNext()){
           str +=  it.next() +"\n";
        }
        return str;
    }


    // TODO: return an iterator for the binary tree to be used to save the tree in persistent media.
    @Override
    public Iterator<Player> iterator(){
        return new Iterator<Player>() {
            private Stack<BinNode> stack = new Stack<BinNode>();

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Player next() {
                while (root != null) {
                    stack.push(root);
                    root = root.getLeft();
                }
                BinNode current = stack.peek();
                BinNode temp = current;
                if (temp.getRight() == null) {
                    temp = stack.pop();
                    while (!stack.isEmpty() && stack.peek().getRight() == temp) {
                        temp = stack.pop();
                    }
                }
                else {
                    temp = temp.getRight();
                    while (temp != null) {
                        stack.push(temp);
                        temp = temp.getLeft();
                    }
                }
                return current.getPlayer();
            }
        };
    }
}*/
