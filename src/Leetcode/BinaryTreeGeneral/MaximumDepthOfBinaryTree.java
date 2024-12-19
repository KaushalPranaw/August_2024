package Leetcode.BinaryTreeGeneral;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        // Create a sample binary tree:
        //         1
        //        / \
        //       2   3
        //      /
        //     4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        int depth = tree.maxDepth(root);
        System.out.println("Maximum depth of the binary tree: " + depth);
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
