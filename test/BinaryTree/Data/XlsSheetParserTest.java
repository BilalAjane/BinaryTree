package BinaryTree.Data;

import BinaryTree.Model.XlsSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XlsSheetParserTest {

    @Test
    void create() throws IOException {
        XlsSheet xlsSheet = new XlsParser().create(new File("resources/DistancesInJylland.xls"), 0);

        assertNull(xlsSheet.getCell("A", 1));
        assertEquals("Århus", xlsSheet.getCell("A", 2).getStringCellValue());
        assertEquals("Aalborg", xlsSheet.getCell("A", 3).getStringCellValue());
        assertEquals("Aabenrå", xlsSheet.getCell("A", 4).getStringCellValue());
        assertEquals("Århus", xlsSheet.getCell("B", 1).getStringCellValue());
        assertEquals(0.0, xlsSheet.getCell("B", 2).getNumericCellValue());
        assertEquals("Aalborg", xlsSheet.getCell("C", 1).getStringCellValue());
        assertEquals(118.0, xlsSheet.getCell("C", 2).getNumericCellValue());
        assertEquals("Aabenrå", xlsSheet.getCell("D", 1).getStringCellValue());
        assertEquals(154.0, xlsSheet.getCell("D", 2).getNumericCellValue());
    }
    @Test
    void getRows() throws IOException {
        XlsSheet xlsSheet = new XlsParser().create(new File("resources/DistancesInJylland.xls"), 0);

        assertNull(xlsSheet.getRow(0).get(0));
        assertEquals("Århus", xlsSheet.getRow(1).get(0).getStringCellValue());
        assertEquals("Aalborg", xlsSheet.getRow(2).get(0).getStringCellValue());
        for (List<Cell> l: xlsSheet) {
            for (Cell c: l) {
                System.out.println(c);
            }
        }
    }
}