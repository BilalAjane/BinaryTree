package BinaryTree.Model;

public class Container<T> {
    private T value;

    public Container(T value) {
        this.value = value;
    }

    public Container() {}

    public T getValue() {
        return value;
    }
}
