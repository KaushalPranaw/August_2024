package Leetcode.BinaryTreeGeneral;

public class LowestCommonAncestorOfBinaryTree {
    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        // Set up the tree structure
        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;

        // Nodes for which we want to find the LCA
        TreeNode p = node5; // Node with value 5
        TreeNode q = node1; // Node with value 1

        // Create an instance of the class to call the method
        LowestCommonAncestorOfBinaryTree lcaFinder = new LowestCommonAncestorOfBinaryTree();
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);

        // Print the result
        if (lca != null) {
            System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
        } else {
            System.out.println("Lowest Common Ancestor not found.");
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else
            return right;

    }
}
