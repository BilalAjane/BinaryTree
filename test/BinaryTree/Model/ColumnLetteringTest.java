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
        /**
         * The numerical notation for predicting indexes of column letters go as follows:
         *
         * For single letter columns get index 0-25 where index 0="A" and index 25="Z".
         */
        assertEquals("A", columnLettering.getLetter(0));
        assertEquals("Z", columnLettering.getLetter(25));

        /**
         * Dual-letter columns are to be calculated with initial value 'a', 'b' that is determinate of the first
         * letter, and 'c' that is determinate of BOTH the first and second letter.
         *
         * a = 26
         * b = not 0 or negative
         * c = can be any number
         * This provides the formula (a*b+-c) where 'a' is 26 and 'b' cannot be 0 or negative.
         *
         * Simply multiplying 'a' with 'b' produces a step on first letter.
         */
        assertEquals("AA", columnLettering.getLetter(26)); // or 26*1
        assertEquals("BA", columnLettering.getLetter(26*2));
        assertEquals("CA", columnLettering.getLetter(26*3));
        assertEquals("DA", columnLettering.getLetter(26*4));

        /**
         * Adding or subtracting the 'a'(*'b') by 'c' value produces a step of the last letter, potentially
         * also forcing the first letter.
         */
        assertEquals("AB", columnLettering.getLetter(26+1)); // or 26*1+1
        assertEquals("BB", columnLettering.getLetter(26*2+1));
        assertEquals("AZ", columnLettering.getLetter(26*2-1)); // first letter stepped down by force of 'c'

        /**
         * As a test, see if you can calculate by hand what solution would produce column number "GR".
         */
    }

    @Test
    public void getNumber() {

        assertEquals(0, columnLettering.getNumber("A"));
        assertEquals(25, columnLettering.getNumber("Z"));
        assertEquals(26, columnLettering.getNumber("AA"));
        assertEquals(26+1, columnLettering.getNumber("AB"));

        assertEquals(26*3, columnLettering.getNumber("CA"));
        assertEquals(26*3+1, columnLettering.getNumber("CB"));
        assertEquals(26*4-1, columnLettering.getNumber("CZ"));

        assertEquals(-1, columnLettering.getNumber("ZZ"));
    }

}