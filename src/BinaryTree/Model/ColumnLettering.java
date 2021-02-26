package BinaryTree.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @version  1.2
 * @author PatrickVincentHoestroem
 *
 * A class for converting index numbers to xls column letters and back again.
 *
 * (See test section for numerical notation of column index calculation and runtime examples).
 */

public class ColumnLettering {
    private final char[] alphabet = new char[26];
    private final List<String> list;

    public ColumnLettering() {
        list = new ArrayList<>();
        for (char a = 'A'; a <= 'Z'; a++) {
            alphabet[Character.getNumericValue(a)-10] = a;
        }
        this.generate();
    }

    private List<String> generate() {
        for (int i = 0; i < alphabet.length; i++) {
            list.add(String.valueOf(alphabet[i]));
        }

        String letters = "";
        while (true) {
            for (char i: alphabet) {
                for (char j: alphabet) {
                    letters = "" + i + j;
                    list.add(letters);
                    if (letters.equals("IV")) {
                        return list;
                    } else {
                        letters = "";
                    }
                }
            }
        }
    }

    public String getLetter(int index) {
        return list.get(index);
    }

    public int getNumber(String letters) {
        for (int i = 0; i < list.size(); i++) {
            if (letters.equals(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

}
