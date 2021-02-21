package BinaryTree.Model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class alphabetTest {

    @Test
    public void read() {
        Alphabet alphabet = new Alphabet();
        assertEquals("A", alphabet.get(0));
        assertEquals("AA", alphabet.get(26));
        assertEquals("AAA", alphabet.get(26*2));
        assertEquals("AAAA", alphabet.get(26*3));
        assertEquals("AAAAA", alphabet.get(26*4));
        for (int i = 0; i < 26*4; i++) {
            System.out.println(alphabet.get(i));
        }
    }

}