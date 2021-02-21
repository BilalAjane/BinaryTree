package BinaryTree;

import BinaryTree.Data.XlsParser;

import java.io.IOException;

public class RunTree {

    public static void main(String[] args) throws IOException {
        XlsParser xlsParser = new XlsParser();
        xlsParser.create("C:\\Users\\patri\\IdeaProjects\\Sem03\\BinaryTree\\resources\\DistancesInJylland.xls");
    }
}
