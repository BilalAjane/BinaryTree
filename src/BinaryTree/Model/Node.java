package BinaryTree.Model;

public class Node {
    private Node root;
    private City value;
    private Node left;
    private Node right;

    public Node(Node root, City city, Node left, Node right) {
        this.root = root;
        this.value = city;
        this.left = left;
        this.right = right;
    }

    public Node getRoot() {
        return root;
    }

    public City getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
