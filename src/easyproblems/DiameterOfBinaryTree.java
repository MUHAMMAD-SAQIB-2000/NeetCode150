package easyproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DiameterOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Build: [1,2,3,4,5]
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println("Test Case 1: " + diameterOfBinaryTree(root1) + ", Expected: 3");

        System.out.println("\n========================");

        // Build: [1,2]
        //        1
        //       /
        //      2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        System.out.println("Test Case 2: " + diameterOfBinaryTree(root2) + ", Expected: 1");
    }

    static int maximumDepth = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maximumDepth = 0; // reset before each fresh call
        computeDepth(root);
        return maximumDepth;
    }

    private static int computeDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = computeDepth(root.left);
        int rightDepth = computeDepth(root.right);

        maximumDepth = Math.max(maximumDepth, leftDepth + rightDepth);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
