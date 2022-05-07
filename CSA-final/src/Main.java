import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    
    //Creating a scanner object to take in words from users
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            Word.fromFile("CSA-final/res/possible words.csv");
        } catch (IOException e) { e.printStackTrace(); }

        Wordle wordle = new Wordle();

        //System.out.println("Please enter the second word; PINOT is recomended");

        while(true) {
            System.out.println("Please enter the first word; TRACE is recomended");

            String[] w1 = scan.nextLine().trim().toLowerCase(Locale.ROOT).split("");

            System.out.println("Record the black, yellow and green with: BGR, ex: ADIEU might be responded to with: YYBYB");

            String[] r1 = scan.nextLine().trim().toLowerCase(Locale.ROOT).split("");

            if(r1.length != 5) throw new RuntimeException("YOU NEED 5 letters");

            int g = 0;

            for(int i = 0; i < r1.length; i++) {
                if(r1[i].equals("b")) {
                    wordle.addExclude(w1[i].charAt(0));
                } else if(r1[i].equals("y")) {
                    wordle.add(w1[i].charAt(0));
                } else {
                    wordle.addIndex(i, w1[i].charAt(0));
                    g++;
                }
            }
            if(g == 5) return;

            String guess = wordle.update();

            System.out.println(guess);
        }


    }
    
    
    
}
