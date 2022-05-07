import java.util.ArrayList;
import java.util.Arrays;

public class Wordle {
    private final ArrayList<Character> contents = new ArrayList<>();
    private final char[] order = {'-','-','-','-','-'};
    private final ArrayList<Character> exclude = new ArrayList<>();

    // TODO: make it so that only letter is counted once when needed and also make it so yellow letters are not in there places


    private final ArrayList<Word> possible = new ArrayList<>();

    public Wordle() {
        possible.addAll(Arrays.asList(Word.getAllWords()));
    }

    public ArrayList<Character> getContents() {
        return contents;
    }
    public void add(char c) {
        contents.add(c);
    }

    public void addIndex(int index, char c) {
        order[index] = c;
    }

    public void addExclude(char c) {
        possible.removeIf(word -> {
            for(int i = 0; i < word.getChars().length; i++) {
                if(word.getChars()[i] == c) return true;
            }
            return false;
        });
    }

    public char[] getOrder() {
        return order;
    }

    public ArrayList<Character> getExclude() {
        return exclude;
    }

    public String update() {
        System.out.println(order);
        possible.removeIf(word -> {
            for(int i = 0; i < order.length; i++) {
                if(order[i] != word.getChars()[i] && order[i] != '-') return true;
            }
            for (Character content : contents) {
                if (word.notPartOf(String.valueOf(content))) return true;
            }
            return false;
        });
        if(possible.size() == 0) throw new IllegalArgumentException("UHH");
        System.out.println(possible.size());
        System.out.println(possible);
        return possible.get(0).getWord();
    }

}
