/*
    A public class that handles inserting
    and checking for existence of words.
     */

public class TST {
    // Make a node for instance variable
    private TSTNode root;

    // Default
    public TST () {
        root = new TSTNode();
    }

    // Method to insert word into TST
    public void insertWord(String word) {
        // First make sure that the word is valid
        if (word == null || word.isEmpty()) {
            return;
        }

        // Use recursive helper function
        root = insertWordHelper(word, root, 0);
    }

    // Private helper method
    private TSTNode insertWordHelper(String word, TSTNode currentNode, int characterIndex) {
        // Get the current word from the character
        char currentCharacter = word.charAt(characterIndex);

        // If there is no node yet then create one
        if (currentNode == null) {
            currentNode = new TSTNode();
            currentNode.setC(currentCharacter);
        }

        // Case 1: currentCharacter comes before this node's char
        if (currentCharacter < currentNode.getC()) {
            // Recursively loop through the new tree
            currentNode.setLeft(insertWordHelper(word, currentNode.getLeft(), characterIndex));
        }

        // Case 2: currentCharacter comes after this node's char
        else if (currentCharacter > currentNode.getC()) {
            // Recursively loop through the new tree
            currentNode.setRight(insertWordHelper(word, currentNode.getRight(), characterIndex));
        }

        // Case 3: The current node matches the character or its the first node
        else {
            // If there are more characters keep going down middle
            if (characterIndex < word.length() - 1) {
                currentNode.setMiddle(insertWordHelper(word, currentNode.getMiddle(), characterIndex + 1));
            }
            // Otherwise mark it as the terminal end
            else {
                currentNode.setTerminal(true);
            }
        }
        // Return the final node when done so it gets linked
        return currentNode;
    }

    // Method to check if word is in TST
    public boolean checkWord(String word) {
        // Check if the word is null
        if (word == null || word.isEmpty()) {
            return false;
        }

        // Call the recursive helper function
        TSTNode node = checkWordHelper(word, root, 0);

        // Return the is terminal and the null because of base case
        return node != null && node.isTerminal();
    }

    private TSTNode checkWordHelper(String word, TSTNode currentNode, int characterIndex) {
        // Base case if the current node is null
        if (currentNode == null) {
            return null;
        }

        char currentCharacter = word.charAt(characterIndex);

        // Case 1: currentCharacter is before current node
        if (currentCharacter < currentNode.getC()) {
            return checkWordHelper(word, currentNode.getLeft(), characterIndex);
        }

        // Case 2: currentCharacter is after current node
        else if (currentCharacter > currentNode.getC()) {
            return checkWordHelper(word, currentNode.getRight(), characterIndex);
        }

        // Case 3: currentCharacter = currentNode
        else {
            // First check if it is the last node in the word
            if (characterIndex == word.length() - 1) {
                return currentNode;
            }
            // Keep going down middle
            else {
                return checkWordHelper(word, currentNode.getMiddle(), characterIndex + 1);
            }
        }
    }
}
