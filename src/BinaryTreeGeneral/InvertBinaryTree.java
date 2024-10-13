package BinaryTreeGeneral;

public class InvertBinaryTree {
    public static void main(String[] args) {
        // Create a sample binary tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InvertBinaryTree tree = new InvertBinaryTree();
        System.out.println("Original tree (pre-order):");
        root.printPreOrder(root);

        TreeNode invertedRoot = tree.invertTree(root);

        System.out.println("\nInverted tree (pre-order):");
        root.printPreOrder(invertedRoot);

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
