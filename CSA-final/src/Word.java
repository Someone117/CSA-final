import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Word {
    // All possible wordle words
    private static Word[] allWords;

    // the word as a string
    private final String word;
    //the characters in the word, ie "green" is {'g','r','e','e','n'}
    private final char[] chars;

    /**
     * Instantiates a new word given the word as a String
     * @param w the word as a String
     */
    public Word(String w) {
        word = w;
        chars = w.toCharArray();
    }

    // sets up the allWords list from the file
    static {
        try {
            fromFile("CSA-final/res/possible words.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    /**
     * Sets the allWords to a list of words
     * @param fileName the name of the file, with the path
     * @throws IOException if the file is not found (including the path)
     */
    public static void fromFile(String fileName) throws IOException {
        Scanner scanner = new Scanner(new File(fileName));
        ArrayList<Word> wordsList = new ArrayList<>();
        while(scanner.hasNextLine())
        {
            wordsList.add(new Word(scanner.nextLine()));
        }
        allWords = wordsList.toArray(new Word[0]);
    }

    @Override
    public String toString() {
        return word;
    }

    public static Word[] getAllWords() {
        return allWords;
    }

    public char[] getChars() {
        return chars;
    }

}
