package BinaryTree.Data;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xls {
    public void attempt() throws IOException {
        FileInputStream file = new FileInputStream(new File("C:\\Users\\patri\\Downloads\\DistancesInJylland.xls"));
        Workbook workbook = new HSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                try {
                    if (!cell.getStringCellValue().isEmpty()) {
                        System.out.println(cell.getStringCellValue());
                    }
                } catch(IllegalStateException e) {
                    assert true;
                }
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        break;
                    case NUMERIC:
                        break;
                    case BOOLEAN:
                        break;
                    case FORMULA:
                        break;
                    default:
                        data.get(new Integer(i)).add(" ");
                }
            }
            i++;
    }
}
}
