import java.util.ArrayList;
import java.util.Arrays;

public class Wordle {

    // the possible chars for a given index in the word
    private final ArrayList<Character>[] possibleChars = new ArrayList[5];
    // the possible words that could be the wordle
    private final ArrayList<Word> possible = new ArrayList<>();

    /**
     * Sets up a new Wordle object, initializing the possible characters and possible words
     */
    public Wordle() {
        for (int i = 0; i < possibleChars.length; i++) {
            possibleChars[i] = new ArrayList<>();
            char c;
            for(c = 'a'; c <= 'z'; ++c) {
                possibleChars[i].add(c);
            }
        }
        possible.addAll(Arrays.asList(Word.getAllWords()));
    }

    /**
     * Removes a character that appears as black in the wordle
     * @param c the character that is black
     */
    public void addBlack(char c) {
        for (ArrayList<Character> chars : possibleChars) {
            if(chars.size() != 1)
            chars.remove((Character) c);
        }
    }

    /**
     * Takes into account a green character in the wordle
     * @param index the index of the word the character is in: ex "green" has the 'g' as the 0th character
     * @param c the character that is green
     */
    public void addGreen(int index, char c) {
        if(possibleChars[index].size() == 1) return;
        possibleChars[index] = new ArrayList<>();
        possibleChars[index].add(c);
    }
    /**
     * Takes into account a yellow character in the wordle
     * @param index the index of the word the character is in: ex "green" has the 'g' as the 0th character
     * @param c the character that is yellow
     */
    public void addYellow(int index, char c) {
        possibleChars[index].remove((Character) c);
        for(int i = 0; i < possibleChars.length; i++) {
            if(i != index) {
                if(possibleChars[i].size() != 1) {
                    boolean seen = false;
                    for (Character ch : possibleChars[i]) {
                        if (ch == c) {
                            seen = true;
                            break;
                        }
                    }
                    if (!seen) {
                        possibleChars[i].add(c);
                    }
                }
            }
        }
    }

    /**
     * Updates the possible characters
     * @return the next guess
     */
    public String update() {
        possible.removeIf(word -> {
            for(int i = 0; i < word.getChars().length; i++) {
                if(!possibleChars[i].contains(word.getChars()[i])) return true;
            }
            return false;
        });
        if(possible.size() > 0)
        return Word.bestWord(possible);
        else return "";
    }

    public int getNumPossible() {
        return possible.size();
    }
}

