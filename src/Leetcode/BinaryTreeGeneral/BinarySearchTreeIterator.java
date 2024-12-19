package Leetcode.BinaryTreeGeneral;

import java.util.Stack;

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);

    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;

    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }


    public boolean hasNext() {
        return !stack.isEmpty();

    }

    public static void main(String[] args) {
        // Create a sample binary search tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        // Initialize the iterator
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root);

        // Traverse the BST using the iterator
        System.out.println("In-order traversal of the BST:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }

}
