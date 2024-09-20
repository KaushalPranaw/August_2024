package BinaryTreeGeneral;

public class PathSum {
    public static void main(String[] args) {
        // Create a sample binary tree:
        //         5
        //        / \
        //       4   8
        //      /   / \
        //     11  13  4
        //    /  \      \
        //   7    2      1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        PathSum pathSum = new PathSum();

        int targetSum1 = 22;
        int targetSum2 = 26;
        int targetSum3 = 18;

        System.out.println("Has path sum " + targetSum1 + "? " + pathSum.hasPathSum(root, targetSum1));
        System.out.println("Has path sum " + targetSum2 + "? " + pathSum.hasPathSum(root, targetSum2));
        System.out.println("Has path sum " + targetSum3 + "? " + pathSum.hasPathSum(root, targetSum3));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
