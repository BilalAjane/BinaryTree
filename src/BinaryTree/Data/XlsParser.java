package BinaryTree.Data;

import BinaryTree.Model.ColumnLettering;
import BinaryTree.Model.XlsSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class XlsParser {
    private final ColumnLettering columnLettering;

    public XlsParser() {
        columnLettering = new ColumnLettering();
    }

    public XlsSheet create(File file, int sheetIndex) throws IOException {

        FileInputStream io = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(io);
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        Map<String, Cell> map = new HashMap<>();
        List<List<Cell>> rows = new ArrayList<>();
        List<List<Cell>> columns = new ArrayList<>();

        // Create Rows and Map
        List<Cell> r = new ArrayList<>();
        int count = 0;
        int i = 0;
        for (Row itRow:sheet) {
            for (Cell cell:itRow) {
                map.put(""+columnLettering.getLetter(cell.getColumnIndex())+(cell.getRowIndex()+1), cell);

                if (cell.getColumnIndex() > i) {
                    int j = cell.getColumnIndex() - i;
                    for (int k = 0; k < j; k++) {
                        r.add(null);
                        i++;
                    }
                }

                r.add(cell);
                i++;
                count++;
            }
            i = 0;
            rows.add(r);
            r = new ArrayList<>();
        }

        // Create Columns
        List<Cell> c = new ArrayList<>();
        for (int l = 0;l <= count; l++) {
            int j = 0;
            while (true) {
                try {
                    c.add(rows.get(l).get(j));
                    j++;
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
            columns.add(c);
            c = new ArrayList<>();
        }

        return new XlsSheet(columnLettering, map, rows, columns);
    }
}
