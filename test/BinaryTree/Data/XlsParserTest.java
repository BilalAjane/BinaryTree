package BinaryTree.Data;

import BinaryTree.Model.Xls;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XlsParserTest {

    @Test
    void getMap() throws IOException {
        Xls xls = new XlsParser().create(new File("resources/DistancesInJylland.xls"));

        assertNull(xls.getCell("A", 1));
        assertEquals("Århus", xls.getCell("A", 2).getStringCellValue());
        assertEquals("Aalborg", xls.getCell("A", 3).getStringCellValue());
        assertEquals("Aabenrå", xls.getCell("A", 4).getStringCellValue());
        assertEquals("Århus", xls.getCell("B", 1).getStringCellValue());
        assertEquals(0.0, xls.getCell("B", 2).getNumericCellValue());
        assertEquals("Aalborg", xls.getCell("C", 1).getStringCellValue());
        assertEquals(118.0, xls.getCell("C", 2).getNumericCellValue());
        assertEquals("Aabenrå", xls.getCell("D", 1).getStringCellValue());
        assertEquals(154.0, xls.getCell("D", 2).getNumericCellValue());
    }
}