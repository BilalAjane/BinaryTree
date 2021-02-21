package BinaryTree.Model;

import org.apache.poi.ss.usermodel.Cell;

import java.util.Map;

public class Xls {
    private Map<String, Cell> map;

    public Xls(Map<String, Cell> map) {
        this.map = map;
    }

    public Container<?> getContainer(String str) {
        Cell c = map.get(str);
        if (c != null) {
            switch (c.getCellType()) {
                case NUMERIC:
                    return new Container<>(c.getNumericCellValue());
                case STRING:
                    return new Container<>(c.getStringCellValue());
            }
        }
        return new Container<>();
    }
}
