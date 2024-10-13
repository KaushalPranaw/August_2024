package BinaryTreeGeneral;

public class SameTree {
    public static void main(String[] args) {
        SameTree sameTreeChecker = new SameTree();

        // Create first binary tree:    1
        //                              /   \
        //                             2     3
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        // Create second binary tree:   1
        //                               / \
        //                              2   3
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        // Create third binary tree:    1
        //                              /
        //                             2
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);

        // Compare trees
        System.out.println("Tree 1 and Tree 2 are the same: " + sameTreeChecker.isSameTree(tree1, tree2)); // should return true
        System.out.println("Tree 1 and Tree 3 are the same: " + sameTreeChecker.isSameTree(tree1, tree3)); // should return false
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
