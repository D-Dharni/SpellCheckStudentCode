import java.util.ArrayList;

/*
    * A public class that represents a character node inside the TST structure.
     */
public class Node {

    // Character stored at this node
    private char c;

    // Nodes for the surrounding characters for TST implementation
    private Node left;

    private Node right;

    private Node middle;

    // Variable for is an end of a word
    private boolean isTerminal;

    // Array with all the children for trie implementation
    private Node[] children;

    public Node() {
        children = new Node[256];
        isTerminal = false;
    }

    // Getters and Setters for all Instance Variables

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isThereChild (char character) {
        return children[character] != null;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getMiddle() {
        return middle;
    }

    public void setMiddle(Node middle) {
        this.middle = middle;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }
}
