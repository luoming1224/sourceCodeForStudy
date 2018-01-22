package ds.tree;

public class BinaryTree<T> {
    Node<T> root;

    void createBinaryTree(Node<T> node, T data) {
        if (root == null) {
            root = new Node<T>(data);
        } else {
            if (Math.random() > 0.5) {
                if (node.left == null) {
                    node.left = new Node<>(data);
                } else {
                    createBinaryTree(node.left, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node<>(data);
                } else {
                    createBinaryTree(node.right, data);
                }
            }
        }
    }

    Node<T> createBinaryTreeByArray(T[] array, int index) {
        Node tn = null;
        if (index < array.length) {
            T value = array[index];
            tn = new Node(value);
            tn.left = createBinaryTreeByArray(array, 2*index + 1);
            tn.right = createBinaryTreeByArray(array, 2*index + 2);
        }
        return tn;
    }
}
