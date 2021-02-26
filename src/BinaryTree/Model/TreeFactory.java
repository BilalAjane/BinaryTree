package BinaryTree.Model;

import BinaryTree.Data.XlsParser;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TreeFactory {
    public Node<City> create(File file) throws IllegalArgumentException, IOException {
        System.out.println("Reading file contents...");

        Node<City> tree;
        if (FilenameUtils.getExtension(file.getName()).equals("xls")) {
            tree = this.generateFromXls(file);
        } else {
            throw new IllegalArgumentException("Checked Exception: File was not of relevant type!");
        }

        return tree;
    }

    private Node<City> generateFromXls(File file) throws IOException {
        XlsSheet xlsSheet = new XlsParser().create(file, 0);

        // Find matrices in the sheet for models

        // Find names of columns and generate list of models

        // Sort from list through xls data to make a tree for every model as root

        List<Cell> list = new ArrayList<>();
        for (Cell cell: xlsSheet.getRow(0)) {
            if (!(cell==null)) {
                System.out.println(cell);
                list.add(cell);
            }
        }

        return null;
    }
}
