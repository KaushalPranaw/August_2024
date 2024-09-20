package DivideAndConquer;

import BinaryTreeGeneral.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        // Example sorted array
        int[] sortedArray = {-10, -3, 0, 5, 9};
        ConvertSortedArrayToBinarySearchTree converter = new ConvertSortedArrayToBinarySearchTree();

        // Convert sorted array to BST
        TreeNode root = converter.sortedArrayToBST(sortedArray);

        // Print the in-order traversal of the tree to verify
        System.out.println("In-order traversal of constructed BST:");
        new TreeNode().printPreOrder(root);

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return createTree(nums, 0, nums.length - 1);

    }

    private TreeNode createTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.setLeft(createTree(nums, start, mid - 1));
        root.setRight(createTree(nums, mid + 1, end));
        return root;
    }
}
