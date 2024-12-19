package Leetcode.BinaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorder {
    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorder builder = new ConstructBinaryTreeFromInorderAndPostorder();

        // Example preorder and inorder arrays
        int[] postOrder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = builder.buildTree(inorder, postOrder);

        // Print the inorder traversal of the constructed tree to verify
        System.out.print("Inorder Traversal of the constructed tree: ");
        root.printInOrder(root);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        return root;

    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot - inStart;

        root.left = buildTree(inorder, inStart, inRoot - 1,
                postorder, postStart, postStart + numLeft - 1, map);
        root.right = buildTree(inorder, inRoot + 1, inEnd,
                postorder, postStart + numLeft, postEnd - 1, map);
        return root;
    }
}
