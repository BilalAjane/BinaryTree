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
        System.out.println(columnLettering.getLetter(27));
    }

    @Test
    public void getNumber() {
        /**
         * The numerical notation for predicting indexes of column letters go as follows:
         *
         * First repetition is index 0-25 where index 0="A" and index 25="Z".
         *
         * All following repetitions for indexing are calculated from the first letter in second repetition 26="AA".
         * Subsequently multiplying 26="AA" with any number will provide the amount of letters applied next to the initial "A".
         * So ((26="AA")*3)=(78="AAAA") is like saying ("A"+"AAA"="AAAA").
         *
         * Traversing through the next level repetitions require addition or subtraction.
         * Error. All indexes are simply repetitions... IE AAA not ABA like a xls spreadsheet.
         *
         */
        assertEquals(0, columnLettering.getNumber("A"));
        assertEquals(25, columnLettering.getNumber("Z"));
        assertEquals(26, columnLettering.getNumber("AA"));
        assertEquals(26*3, columnLettering.getNumber("AAAA"));
        assertEquals(26*3+1, columnLettering.getNumber("BBBB"));
        assertEquals(26*4-1, columnLettering.getNumber("ZZZZ"));
        assertDoesNotThrow(()->{columnLettering.getNumber("ZZZZZ");});
        assertThrows(IllegalArgumentException.class, ()->{columnLettering.getNumber("ZZZZZZ");});
        assertDoesNotThrow(()->{columnLettering.getNumber("ZZZZZZ", 6);});
    }

}