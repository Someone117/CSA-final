import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    //Creating a scanner object to take in words from users
    public Scanner scan = new Scanner(System.in);
    
    //creaing an ArrayList and printing the words out on display from the possible words file
    public static void main(String[] args) {
        Word[] w = Word.fromFile("possible words.csv");
        System.out.println(Arrays.toString(w));
    }
    
    
    
}
