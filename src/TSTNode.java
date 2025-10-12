/*
    * A public class that represents a character node inside the TST structure.
     */
public class TSTNode {
    // Character stored at this node
    private char c;

    // Nodes for the surrounding characters for TST implementation
    private TSTNode left;

    private TSTNode right;

    private TSTNode middle;

    // Variable for is an end of a word
    private boolean isTerminal;

    // Getters and Setters for all Instance Variables
    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public TSTNode getLeft() {
        return left;
    }

    public void setLeft(TSTNode left) {
        this.left = left;
    }

    public TSTNode getRight() {
        return right;
    }

    public void setRight(TSTNode right) {
        this.right = right;
    }

    public TSTNode getMiddle() {
        return middle;
    }

    public void setMiddle(TSTNode middle) {
        this.middle = middle;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }
}
