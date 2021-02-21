package BinaryTree.Model;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    private List<String> list;

    public Alphabet() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            site(i);
        }
    }

    private void site(int increment) {
        String character = "";
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            character = "";
            for (int i = 0; i <= increment; i++) {
                character += alphabet;
            }
            list.add(character);
        }
    }

    public String get(int index) {
        return list.get(index);
    }

}
