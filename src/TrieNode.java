public class TrieNode {
    private static final int ALPHABET = 256;

    // Variable for is an end of a word
    private boolean isTerminal;

    // Array with all the children for trie implementation
    private TrieNode[] children;

    public TrieNode() {
        children = null;
        isTerminal = false;
    }

    // Getters and Setters for all Instance Variables

    public TrieNode getChild(char character) {
        if (children == null) {
            return null;
        }
        return children[character];
    }

    public void setChildren(char character, TrieNode node) {
        if(children == null) {
            children = new TrieNode[ALPHABET];
        }
        children[character] = node;
    }

    public boolean isThereChild (char character) {
        return children != null && children[character] != null;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }
}
