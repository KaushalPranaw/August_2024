package BinaryTreeBFS;

import BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        // Create a sample binary tree:
        //        3
        //       / \
        //      9   20
        //          /  \
        //         15   7

        TreeNode root = new TreeNode(3);
        TreeNode leftChild = new TreeNode(9);
        TreeNode rightChild = new TreeNode(20);
        TreeNode leftChildRight = new TreeNode(15);
        TreeNode rightChildRight = new TreeNode(7);

        root.setLeft(leftChild);
        root.setRight(rightChild);
        rightChild.setLeft(leftChildRight);
        rightChild.setRight(rightChildRight);

        // Create an instance of the class and call the method
        AverageOfLevelsInBinaryTree avgLevels = new AverageOfLevelsInBinaryTree();
        List<Double> averages = avgLevels.averageOfLevels(root);

        // Print the results
        System.out.println("Average of levels in the binary tree:");
        for (double avg : averages) {
            System.out.println(avg);
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.getVal();
                if (node.getLeft() != null)
                    queue.offer(node.getLeft());
                if (node.getRight() != null)
                    queue.offer(node.getRight());
            }
            result.add(sum / n);
        }
        return result;


    }
}
