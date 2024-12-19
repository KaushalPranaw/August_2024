package Leetcode.BinaryTreeGeneral;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // Print the original tree (in-order)
        System.out.println("Original Tree (In-order):");
        root.printPreOrder(root);
        System.out.println();

        // Flatten the binary tree
        FlattenBinaryTreeToLinkedList flattener = new FlattenBinaryTreeToLinkedList();
        flattener.flatten(root);

        // Print the flattened tree (which should be a linked list)
        System.out.println("Flattened Tree (Linked List):");
        root.printPreOrder(root);

    }
    public void flatten(TreeNode root) {
        if(root==null)
            return;

        TreeNode cur=root;
        while (cur!=null){
            if(cur.left!=null){
                TreeNode deepest=cur.left;
                while (deepest.right!=null){
                    deepest=deepest.right;
                }

                deepest.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }

    }
}
