import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Word[] w = Word.fromFile("possible words.csv");
        System.out.println(Arrays.toString(w));
    }
}
