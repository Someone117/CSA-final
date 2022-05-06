import java.util.ArrayList;

public class Wordle {
    private final ArrayList<Character> contents = new ArrayList<>();
    private final char[] order = new char[5];

    public Wordle() {}

    public ArrayList<Character> getContents() {
        return contents;
    }
    public void add(Character c) {
        contents.add(c);
    }

    public void addIndex(int index, char c) {
        order[index] = c;
    }
}
