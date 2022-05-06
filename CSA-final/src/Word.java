import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Word {
    private static Word[] allWords;

    private final String word;
    private final char[] chars;
    public Word(String w) {
        word = w;
        chars = w.toCharArray();
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

    public boolean notPartOf(String s) {
        return !word.contains(s);
    }

    public boolean wordleGetInOrder(String s) {
        char[] parts = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(parts[i] != '-') {
                if(parts[i] != chars[i]) return false;
            }
        }
        return true;
    }

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

    public static void setAllWords(Word[] allWords) {
        Word.allWords = allWords;
    }

    public char[] getChars() {
        return chars;
    }

}
