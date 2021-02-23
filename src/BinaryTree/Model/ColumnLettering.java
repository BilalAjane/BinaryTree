package BinaryTree.Model;

import java.util.ArrayList;
import java.util.List;

public class ColumnLettering {
    private int repetitions;
    private List<String> list;

    public ColumnLettering() {
        this.repetitions = 0;
        this.generate();
    }

    private void generate() {
        list = new ArrayList<>();
        for (int i = 0; i <= repetitions; i++) {
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

    public String getLetter(int index) {
        try {
            return list.get(index);
        } catch (IndexOutOfBoundsException e) {
            this.repetitions += 1;
            this.generate();
            return this.getLetter(index);
        }
    }

    private int numberCounter(String letters, int stackCount, int stackLimit) {
        try {
            while (stackCount < stackLimit) {
                String listLetter = list.get(stackCount);
                if (listLetter.equals(letters)) {
                    return stackCount-repetitions;
                } else {
                    stackCount += 1;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            this.repetitions += 1;
            this.generate();
            return numberCounter(letters, stackCount, stackLimit);
        }
        throw new IllegalArgumentException("Stack limit '" + stackLimit + "' exceeded. could not find '" + letters + "' in generated columns letters.");
    }

    public int getNumber(String letters) {
        return numberCounter(letters, 0, 250);
    }

}
