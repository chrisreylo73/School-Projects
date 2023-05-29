/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - BinNode class
 */

public class BinNode {

    private Player player;
    private BinNode left, right;

    public BinNode() {
        player = null;
        left = right = null;
    }

    public BinNode(final Player player) {
        this.player = player;
        left = right = null;
    }

    public Player getPlayer() {
        return player;
    }

    public BinNode getLeft() {
        return left;
    }

    public BinNode getRight() {
        return right;
    }

    public void setPlayer(final Player data) {
        this.player = player;
    }

    public void setLeft(BinNode left) {
        this.left = left;
    }

    public void setRight(BinNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return player.toString();
    }
}