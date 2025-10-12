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
        // Create TST and upload the words into it using insert
        TST dictionaryOfWords = new TST();

//        // OR use Trie Structure
//        Trie dictionaryOfWords = new Trie();

        for (String word: dictionary) {
            dictionaryOfWords.insertWord(word);
        }

        // Build TST for misspelled words
        TST misspelledWords = new TST();

        // OR use Trie Structure
//        Trie misspelledWords = new Trie();
        ArrayList<String> misspelledList = new ArrayList<>();

        // Loop through text
        for (String word: text) {
            // Check if both the dictionary and misspelled words doesn't have it for duplicates
            if (!dictionaryOfWords.checkWord(word) && !misspelledWords.checkWord(word)) {
                // Add to TST and just the list
                misspelledWords.insertWord(word);
                misspelledList.add(word);
            }
        }

        // Return the list as an array
        return misspelledList.toArray(new String[0]);
    }
}
