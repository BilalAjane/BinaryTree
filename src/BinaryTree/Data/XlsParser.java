package BinaryTree.Data;

import BinaryTree.Model.Alphabet;
import BinaryTree.Model.Xls;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XlsParser {

    public Xls create(String filepath) throws IOException {

        FileInputStream file = new FileInputStream(filepath);
        Workbook workbook = new HSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Alphabet alphabet = new Alphabet();
        Map<String, Cell> data = new HashMap<>();
        for (Row row: sheet) {

            for (Cell cell: row) {
                data.put(alphabet.get(cell.getColumnIndex()).toString()+(cell.getRowIndex()+1), cell);
            }
        }

        return new Xls(data);
    }
}
