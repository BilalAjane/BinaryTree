package BinaryTree.Model;

import org.apache.poi.ss.usermodel.Cell;

import java.util.*;

public class Xls implements Iterable<List<Cell>> {
    private final ColumnLettering columnLettering;
    private final Map<String, Cell> map;
    private final List<List<Cell>> rows;
    private final List<List<Cell>> columns;

    public Xls(Map<String, Cell> map, List<List<Cell>> rows, List<List<Cell>> columns) {
        this.columnLettering = new ColumnLettering();
        this.map = map;
        this.rows = rows;
        this.columns = columns;
    }

    public Cell getCell(String columnLetters, int rowNumber) {
        return map.get("" + columnLetters + rowNumber);
        /*
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
        */
    }

    public List<Cell> getRow(int rowNumber) {
        return rows.get(rowNumber);
    }

    public List<Cell> getColumn(String columnLetters) {
        return rows.get(columnLettering.getNumber(columnLetters));
    }

    public List<Cell> getColumn(int number) {
        return columns.get(number);
    }

    @Override
    public Iterator<List<Cell>> iterator() {
        return rows.iterator();
    }
}
