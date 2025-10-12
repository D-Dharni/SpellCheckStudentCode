public class Trie {
    // Instance Variables
    private TrieNode root;

    // Class Implementation
    public Trie() {
        root = new TrieNode();
    }

    // Function to insert the word into trie structure
    public void insertWord (String word) {
        // Base Case
        if (word == null || word.isEmpty()) {
            return;
        }

        // Start at the root node of the trie
        TrieNode current = root;

        // Loop through each character in the array
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            // Check if node has child and if not create a new node for that character
            if (!current.isThereChild(character)) {
                TrieNode newNode = new TrieNode();
                current.setChildren(character, newNode);
            }
            // Save the child to move to the next node
            current = current.getChild(character);
        }

        // Mark the end of the word
        current.setTerminal(true);
    }

    public boolean checkWord (String word) {
        // Base case
        if (word == null || word.isEmpty()) {
            return false;
        }

        // Save the current node
        TrieNode current = root;

        // Loop through each character in the array
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            // Return false if the child isn't valid
            if (!current.isThereChild(character)) {
                return false;
            }
            // Save current to keep looping
            current = current.getChild(character);
        }

        // Return whether end is the finishing
        return current.isTerminal();
    }
}
