package BinaryTree;

import BinaryTree.Data.XlsParser;

import java.io.File;
import java.io.IOException;

public class RunTree {

    public static void main(String[] args) throws IOException {
        XlsParser xlsParser = new XlsParser();
        xlsParser.create(new File("DistancesInJylland.xls"));
    }
}
