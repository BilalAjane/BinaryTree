package BinaryTree.Model;

public class Node<T> {
    private Node root;
    private T value;
    private Node left;
    private Node right;

    public Node(Node root, T value, Node left, Node right) {
        this.root = root;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node getRoot() {
        return root;
    }

    public T getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
