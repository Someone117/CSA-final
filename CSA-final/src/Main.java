import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Word.fromFile("CSA-final/res/possible words.csv");
        } catch (IOException e) { e.printStackTrace(); }
        Word[] w = Word.getAllWords();
        System.out.println(Arrays.toString(w));
    }
}