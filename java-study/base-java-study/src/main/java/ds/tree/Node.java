package ds.tree;

public class Node<T> {
    Node<T>    left;
    Node<T>    right;
    T     data;

    Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
