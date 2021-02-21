package BinaryTree.Data;

import BinaryTree.Model.Xls;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XlsParserTest {

    @Test
    void getMap() throws IOException {
        Xls xls = new XlsParser().create("C:\\Users\\patri\\IdeaProjects\\Sem03\\BinaryTree\\resources\\DistancesInJylland.xls");

        assertNull(xls.getContainer("A1").getValue());

        assertEquals("Århus", xls.getContainer("A2").getValue());
        assertEquals("Aalborg", xls.getContainer("A3").getValue());
        assertEquals("Aabenrå", xls.getContainer("A4").getValue());

        assertEquals("Århus", xls.getContainer("B1").getValue());
        assertEquals(0.0, xls.getContainer("B2").getValue());

        assertEquals("Aalborg", xls.getContainer("C1").getValue());
        assertEquals(118.0, xls.getContainer("C2").getValue());

        assertEquals("Aabenrå", xls.getContainer("D1").getValue());
        assertEquals(154.0, xls.getContainer("D2").getValue());
    }
}