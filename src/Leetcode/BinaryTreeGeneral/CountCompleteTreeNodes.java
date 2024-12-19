package Leetcode.BinaryTreeGeneral;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        // Create a sample complete binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        // Count the nodes in the tree
        CountCompleteTreeNodes counter = new CountCompleteTreeNodes();
        int count = counter.countNodes(root);
        System.out.println("Total number of nodes: " + count);

    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);

    }
}
