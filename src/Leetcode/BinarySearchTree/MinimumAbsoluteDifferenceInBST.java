package Leetcode.BinarySearchTree;

import Leetcode.BinaryTreeGeneral.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    private TreeNode prev;
    int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(4);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(6));
        root.getLeft().setLeft(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(3));

        // Create an instance of the class
        MinimumAbsoluteDifferenceInBST solution = new MinimumAbsoluteDifferenceInBST();

        // Get the minimum absolute difference
        int result = solution.getMinimumDifference(root);

        // Print the result
        System.out.println("Minimum Absolute Difference in BST: " + result);
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        inorderTraversal(root);
        return minDiff;

    }

    private void inorderTraversal(TreeNode node) {
        if (node == null)
            return;
        // Traverse left subtree
        inorderTraversal(node.getLeft());

        // Process current node
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(node.getVal() - prev.getVal()));
        }
        prev = node;

        // Traverse right subtree
        inorderTraversal(node.getRight());

    }
}
