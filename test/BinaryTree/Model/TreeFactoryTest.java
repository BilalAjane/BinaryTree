package BinaryTree.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TreeFactoryTest {
    TreeFactory treeFactory;

    @BeforeEach
    void start() {
        treeFactory = new TreeFactory();
    }

    @Test
    void create() throws IOException {
        assertThrows(IllegalArgumentException.class, ()->{treeFactory.create(new File("resources/BTD_BinaryTreeDistances.pdf"));});
        treeFactory.create(new File("resources/DistancesInJylland.xls"));
    }
}