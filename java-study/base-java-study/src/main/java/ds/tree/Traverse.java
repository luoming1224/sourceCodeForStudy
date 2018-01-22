package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Traverse {
    static void levelTraversal(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        System.out.println();
    }

    static Node reversalBinaryTree(Node root) {
        if (root == null) {
            return root;
        }

        Node tn = root.left;
        root.left = root.right;
        root.right = tn;

        reversalBinaryTree(root.left);
        reversalBinaryTree(root.right);

        return root;

    }

    static void preorderTraversalRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        if (root.left != null) {
            preorderTraversalRecursive(root.left);
        }
        if (root.right != null) {
            preorderTraversalRecursive(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        /*for (int i = 0; i < 10; ++i){
            tree.createBinaryTree(tree.root, i);
        }
*/
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        tree.root = tree.createBinaryTreeByArray(data, 0);
        levelTraversal(tree.root);
        preorderTraversalRecursive(tree.root);
        System.out.println();

        reversalBinaryTree(tree.root);
        levelTraversal(tree.root);
        preorderTraversalRecursive(tree.root);
        System.out.println();
    }
}
