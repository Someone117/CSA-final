import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Word {
    private final String word;
    public Word(String w) {
        word = w;
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

    public boolean wordleGetOutOfOrder(String s) {
        String[] parts = s.split("-");
        for (String part : parts) {
            if (notPartOf(part)) {
                return false;
            }
        }
        return true;
    }
    public boolean wordleGetInOrder(String s) {
        String[] parts = s.split("-");
        for (int i = 0; i < parts.length; i++) {
            if (!word.subSequence(i,i+parts[i].length()).equals(parts[i]) && !parts[i].equals("")) {
                return false;
            }
        }
        return true;
    }

    public static Word[] fromFile(String fileName) { //TODO: no work
        Word[] words = new Word[0];
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int length = (int) br.lines().count();
            words = new Word[length];
            int i = 0;
            System.out.println(br.readLine());
            while ((line = br.readLine()) != null) {
                words[i] = new Word(line);
                i++;
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        return words;
    }

    @Override
    public String toString() {
        return word;
    }
}
