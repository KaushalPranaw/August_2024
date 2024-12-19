package Leetcode.BinaryTreeGeneral;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Create an instance of SumRootToLeafNumbers
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();

        // Calculate the sum of root-to-leaf numbers
        int sum = solution.sumNumbers(root);

        // Print the result
        System.out.println("Sum of root-to-leaf numbers: " + sum);

    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);

    }

    private int dfs(TreeNode root, int num) {
        if (root == null)
            return 0;
        num = num * 10 + root.val;

        if (root.left == null && root.right == null)
            return num;
        return dfs(root.left, num) + dfs(root.right, num);
    }
}
