package BinaryTree.Model;

import org.apache.poi.ss.usermodel.Cell;

import java.util.*;

public class XlsSheet implements Iterable<List<Cell>> {
    private final ColumnLettering columnLettering;
    private final Map<String, Cell> map;
    private final List<List<Cell>> rows;
    private final List<List<Cell>> columns;

    public XlsSheet(ColumnLettering columnLettering, Map<String, Cell> map, List<List<Cell>> rows, List<List<Cell>> columns) {
        this.columnLettering = columnLettering;
        this.map = map;
        this.rows = rows;
        this.columns = columns;
    }

    public Cell getCell(int columnNumber, int rowNumber) {
        return map.get("" + columnLettering.getLetter(columnNumber) + rowNumber);
    }

    public Cell getCell(String columnLetters, int rowNumber) {
        return map.get("" + columnLetters + rowNumber);
    }

    public List<Cell> getRow(int rowNumber) {
        return rows.get(rowNumber);
    }

    public List<Cell> getColumn(String columnLetters) {
        return columns.get(columnLettering.getNumber(columnLetters));
    }

    public List<Cell> getColumn(int number) {
        return columns.get(number);
    }

    @Override
    public Iterator<List<Cell>> iterator() {
        return rows.iterator();
    }
}
