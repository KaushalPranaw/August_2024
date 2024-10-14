package BinaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorder builder = new ConstructBinaryTreeFromPreorderAndInorder();

        // Example preorder and inorder arrays
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = builder.buildTree(preorder, inorder);

        // Print the inorder traversal of the constructed tree to verify
        System.out.print("Inorder Traversal of the constructed tree: ");
        root.printInOrder(root);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);
        return root;

    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart>preEnd || inStart>inEnd)
            return null;

        TreeNode root=new TreeNode(preorder[preStart]);

        int inRoot=map.get(root.val);
        int numLeft=inRoot-inStart;

        root.left=buildTree(preorder, preStart+1, preStart+numLeft,
                inorder, inStart, inRoot-1, map);
        root.right=buildTree(preorder, preStart+numLeft+1, preEnd,
                inorder, inRoot+1, inEnd, map);
        return  root;
    }
}
