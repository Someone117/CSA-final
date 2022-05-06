import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    //Creating a scanner object to take in words from users
    public Scanner scan = new Scanner(System.in);
    
    //creaing an ArrayList and printing the words out on display from the possible words file
    public static void main(String[] args) {
        try {
            Word.fromFile("CSA-final/res/possible words.csv");
        } catch (IOException e) { e.printStackTrace(); }
        Word[] w = Word.getAllWords();
        System.out.println(Arrays.toString(w));
    }
    
    
    
}
