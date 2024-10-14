package BinaryTreeGeneral;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Create an instance of BinaryTreeMaximumPathSum
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();

        // Calculate the maximum path sum
        int maxSum = solution.maxPathSum(root);

        // Print the result
        System.out.println("Maximum Path Sum: " + maxSum);

    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        helper(root);
        return max;
    }

    int helper(TreeNode root){

        if (root == null)
            return 0;
        // Recursively find the maximum path sums of left and right children
        int leftSum = Math.max(0, helper(root.left));   // Only consider positive sums
        int rightSum = Math.max(0, helper(root.right)); // Only consider positive sums

        // Update the maximum path sum found so far
        max = Math.max(max, root.val + leftSum + rightSum);

        // Return the maximum sum for the path that can be extended to parent
        return root.val + Math.max(leftSum, rightSum);
    }
}
