import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
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
    }

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
}
