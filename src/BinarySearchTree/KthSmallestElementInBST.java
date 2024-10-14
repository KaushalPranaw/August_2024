package BinarySearchTree;

import BinaryTreeGeneral.TreeNode;

public class KthSmallestElementInBST {
    int count = 0;
    int result = 0;

    public static void main(String[] args) {
// Create a sample BST
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(7));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(4));
        root.getRight().setRight(new TreeNode(8));

        // Create an instance of KthSmallestElementInBST
        KthSmallestElementInBST kthFinder = new KthSmallestElementInBST();

        // Example: Find the 3rd smallest element
        int k = 3;
        int result = kthFinder.kthSmallest(root, k);
        System.out.println(k + "rd smallest element is: " + result);

    }

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);
        return result;

    }

    private void inorder(TreeNode root, int k) {
        if (root == null)
            return;

        inorder(root.getLeft(), k);

        count++;
        if (count == k) {
            result = root.getVal();
            return;
        }
        inorder(root.getRight(), k);
    }

}
