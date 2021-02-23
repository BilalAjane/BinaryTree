package BinaryTree.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColumnLetteringTest {
    private ColumnLettering columnLettering;

    @BeforeEach
    public void start() {
        columnLettering = new ColumnLettering();
    }

    @Test
    public void getLetter() {
        assertEquals("A", columnLettering.getLetter(0));
        assertEquals("AA", columnLettering.getLetter(26));
        assertEquals("AAA", columnLettering.getLetter(26*2));
        assertEquals("AAAA", columnLettering.getLetter(26*3));
        assertEquals("AAAAA", columnLettering.getLetter(26*4));
        for (int i = 0; i < 26*4; i++) {
            System.out.println(columnLettering.getLetter(i));
        }
    }

    @Test
    public void getNumber() {
        assertEquals(0, columnLettering.getNumber("A"));
        assertEquals(25, columnLettering.getNumber("Z"));
        assertEquals(25*4, columnLettering.getNumber("ZZZZ"));
        assertThrows(IllegalArgumentException.class, ()->{columnLettering.getNumber("ZZZZZZZZZZ");});
    }

}