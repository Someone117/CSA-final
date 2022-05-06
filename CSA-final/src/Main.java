import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    //Creating a scanner object to take in words from users
    private static Scanner scan = new Scanner(System.in);
    
    //creaing an ArrayList and printing the words out on display from the possible words file
    public static void main(String[] args) {
        try {
            Word.fromFile("CSA-final/res/possible words.csv");
        } catch (IOException e) { e.printStackTrace(); }

        Wordle wordle = new Wordle();

        System.out.println("Please enter the first word ADIEU is recomended");

        String word = scan.nextLine();
        System.out.println(word);
        System.out.println("Record the black, yellow and green with: BGR, ex: ADIEU might be responded to with: YYBYB");

        String response1 = scan.nextLine();
        System.out.println(response1);

        String[] r1 = response1.split("");

        if(r1.length != 5) throw new RuntimeException("YOU NEED 5 letters");

        for(int i = 0; i < r1.length; i++) {

        }

    }
    
    
    
}
