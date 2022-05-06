package main.java;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Word[] w = Word.fromFile("CSA/src/main/resources/possible words.csv");
        System.out.println(Arrays.toString(w));
    }

}