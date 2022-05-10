import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Wordle wordle = new Wordle();
        String[] times = {"first","second","third","fourth","fifth","sixth","seventh","eight","ninth","tenth","eleventh","twelve","thirteenth","fourteenth","fifteenth","sixteenth","seventeenth","eighteenth","nineteenth","twentieth","twenty-first"};
        String theWord = "trace";

        int count = 1;
        int end = 6;

        System.out.println("How many wordles are you doing? (Use this program many times in tandem)");
        int num = Integer.parseInt(scan.nextLine().toLowerCase().trim());
        switch (num) {
            case 16 -> end=21;
            case 2 -> end=7;
            case 8 -> end =13;
            case 4 -> end=9;
        }

        System.out.println("OK, doing " + end + " guesses");

        while(!theWord.equals("") && count <= end) {

            System.out.println("Please enter the " + times[count-1] + " word; '" + theWord + "' is recommended, type exit if you are done");

            String[] w1 = scan.nextLine().trim().toLowerCase(Locale.ROOT).split("");

            if(Arrays.equals(w1, new String[]{"e", "x", "i", "t"})) {
                System.out.println("Great, '" + theWord + "' was the word!");
                return;
            }

            System.out.println("Record the black, yellow and green with: BGR, ex: ADIEU might be responded to with: YYBYB");

            String[] r1 = scan.nextLine().trim().toLowerCase(Locale.ROOT).split("");

            if (r1.length != 5) throw new RuntimeException("YOU NEED 5 letters");

            for (int i = 0; i < 5; i++) {
                if (r1[i].equals("b")) {
                    wordle.addBlack(w1[i].charAt(0));
                } else if (r1[i].equals("y")) {
                    wordle.addYellow(i, w1[i].charAt(0));
                } else {
                    wordle.addGreen(i, w1[i].charAt(0));
                }
            }

            theWord = wordle.update();
            count++;
            if(wordle.getNumPossible() == 1) {
                System.out.println("Great, '" + theWord + "' was the word!");
                return;
            }
            if(count == 2) theWord = "pinot"; // trace and pinot give a ~ 59% chance to get it on the third try, often giving less than 10 words left for the third guess
        }
    }
}
