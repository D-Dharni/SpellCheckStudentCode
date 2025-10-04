import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Deven Dharni
 * */




public class SpellCheck {
    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {

        return null;
    }

    /*
    * A private class that represents a character node inside the TST structure.
    * Doesn't have getters and setters because the class is only used privately
    in the code.
    * Since no other class can access it would be fine to directly
    access the variables.
     */

    private static class Node {
        // Character stored at this node
        char c;

        // Nodes for the surrounding characters
        Node left;

        Node right;

        Node middle;

        // Variable for is an end of a word
        boolean isTerminal;
    }

    /*
    A private class that handles inserting
    and checking for existence of words.
     */

    private static class TST {
        // Make a node instance variable
        private Node root;

        // Method to insert word into TST
        public void insertWord(String word) {
            // First make sure that the word is valid
            if (word == null) {
                return;
            }

            // Use recursive helper function
            root = insertWordHelper(word, root, 0);
        }

        // Private helper method
        private Node insertWordHelper(String word, Node currentNode, int characterIndex) {
            // Get the current word from the character
            char currentCharacter = word.charAt(characterIndex);

            // If there is no node yet then create one
            if (currentNode == null) {
                currentNode = new Node();
                currentNode.c = currentCharacter;
            }

            // Case 1: currentCharacter comes before this node's char
            if (currentCharacter > currentNode.c) {
                // Recursively loop through the new tree
                currentNode.left = insertWordHelper(word, currentNode.left, characterIndex);
            }

            // Case 2: currentCharacter comes after this node's char
            else if (currentCharacter < currentNode.c) {
                // Recursively loop through the new tree
                currentNode.right = insertWordHelper(word, currentNode.right, characterIndex);
            }

            // Case 3: The current node matches the character
            else {
                // If there are more characters keep going down middle
                if (characterIndex < word.length() - 1) {
                    currentNode.middle = insertWordHelper(word, currentNode.middle, characterIndex + 1);
                }
                // Otherwise mark it as the terminal end
                else {
                    currentNode.isTerminal = true;
                }
            }
            // Return the final node when done so it gets linked
            return currentNode;
        }

        // Method to check if word is in TST
        public boolean checkWord(String word) {
            // Check if the word is null
            if (word == null) {
                return false;
            }

            // Call the recursive helper function
            Node node = checkWordHelper(word, root, 0);

            // Return to make sure that the node isn't null and that it is the final node
            return node.isTerminal;
        }

        private Node checkWordHelper(String word, Node currentNode, int characterIndex) {
            // Base case if the current node is null
            if (currentNode == null) {
                return null;
            }

            char currentCharacter = word.charAt(characterIndex);

            // Case 1: currentCharacter is before current node
            if (currentCharacter < currentNode.c) {
                return checkWordHelper(word, currentNode.left, characterIndex);
            }

            // Case 2: currentCharacter is after current node
            else if (currentCharacter > currentNode.c) {
                return checkWordHelper(word, currentNode.right, characterIndex);
            }

            // Case 3: currentCharacter = currentNode
            else {
                // First check if it is the last node in the word
                if (characterIndex == word.length() - 1) {
                    return currentNode;
                }
                // Keep going down middle
                else {
                    return checkWordHelper(word, currentNode.middle, characterIndex + 1);
                }
            }
        }
    }

    /*
    // PART 1: Setting up Framework

        // Create array of arrayLists - shelves for the library

        ArrayList<String>[] library = new ArrayList[150000];

        // Loop through the array and initialize each arrayList

        for (int i = 0; i < library.length; i++) {
            library[i] = new ArrayList<>();
        }

        // Loop through each word in dictionary
        for (String word: dictionary) {
            // Find the index that the word should go in for the dictionary
            int index = formula (word, library.length);

            // Inside the correct shelf add the word
            library[index].add(word);
        }

        // PART 2: Spell Checking

        ArrayList<String> misspelledWords = new ArrayList<>();

        // Loop through each word in the text
        for (String word: text) {
            // Calculate the value using formula
            int index = formula(word, library.length);

            // Variable for if it's in
            boolean spelledCorrectly= false;

            for (String shelfWord: library[index]) {
                if (shelfWord.equals(word)) {
                    spelledCorrectly = true;

                    // Break because you don't want extra loops
                    break;
                }
            }

            // Check if there is a duplicate
            if (!spelledCorrectly) {
                boolean isDuplicate = false;

                // Checking process
                for (String badlySpelledWord: misspelledWords) {
                    // Set isDuplicate to true and exit loop if duplicate
                    if (badlySpelledWord.equals(word)) {
                        isDuplicate = true;
                        break;

                    }
                }

                // Add the word to the misspelled if there is no duplicate
                if (!isDuplicate) {
                    misspelledWords.add(word);
                }
            }
        }

        // Return the arrayList converted to an array
        return misspelledWords.toArray(new String[0]);

        public static int formula (String word, int size) {
        // Create variable to keep track
        long value = 0;

        // Formula for calculating unique value for each word
        for (int i = 0; i < word.length(); i++) {
            // Each character has a unique weight because of the 29 + ASCII value

            // Every time modulo it to bring it back in range to prevent overflow
            value = ((value * 29) + word.charAt(i)) % size;
        }

        // Return the integer version of the value
        return (int) value;
    }

     */

}
