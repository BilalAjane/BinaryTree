package BinaryTree.Data;

import BinaryTree.Model.ColumnLettering;
import BinaryTree.Model.Xls;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class XlsParser {

    public Xls create(File file) throws IOException {

        FileInputStream io = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(io);
        Sheet sheet = workbook.getSheetAt(0);

        ColumnLettering columnLettering = new ColumnLettering();
        Map<String, Cell> map = new HashMap<>();
        List<List<Cell>> rows = new ArrayList<>();
        List<List<Cell>> columns = new ArrayList<>();

        for (Row row: sheet) {
            List<Cell> new_row = new ArrayList<>();
            for (Cell cell: row) {
                new_row.add(cell);
                map.put(columnLettering.getLetter(cell.getColumnIndex()).toString()+(cell.getRowIndex()+1), cell);
            }
            rows.add(new_row);
        }

        return new Xls(map, rows, columns);
    }
}
