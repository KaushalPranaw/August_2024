package BinaryTreeGeneral;

public class SymmetricTree {
    public static void main(String[] args) {
    // Create a symmetric binary tree:
        //         1
        //        / \
        //       2   2
        //      / \ / \
        //     3  4 4  3
        TreeNode symmetricRoot = new TreeNode(1);
        symmetricRoot.left = new TreeNode(2);
        symmetricRoot.right = new TreeNode(2);
        symmetricRoot.left.left = new TreeNode(3);
        symmetricRoot.left.right = new TreeNode(4);
        symmetricRoot.right.left = new TreeNode(4);
        symmetricRoot.right.right = new TreeNode(3);

        // Create an asymmetric binary tree:
        //         1
        //        / \
        //       2   2
        //        \   \
        //         3   3
        TreeNode asymmetricRoot = new TreeNode(1);
        asymmetricRoot.left = new TreeNode(2);
        asymmetricRoot.right = new TreeNode(2);
        asymmetricRoot.left.right = new TreeNode(3);
        asymmetricRoot.right.right = new TreeNode(3);

        SymmetricTree tree = new SymmetricTree();

        System.out.println("Is the first tree symmetric? " + tree.isSymmetric(symmetricRoot));
        System.out.println("Is the second tree symmetric? " + tree.isSymmetric(asymmetricRoot));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);

    }

    private boolean helper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null)
            return false;
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
    }
}
