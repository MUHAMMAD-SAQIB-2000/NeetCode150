package easyproblems;

public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Build: [3,9,20,null,null,15,7] — balanced
        //        3
        //       / \
        //      9  20
        //         / \
        //        15  7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println("Test Case 1: " + isBalanced(root1) + ", Expected: true");

        System.out.println("\n========================");

        // Build: [1,2,2,3,3,null,null,4,4] — not balanced
        //              1
        //             / \
        //            2   2
        //           / \
        //          3   3
        //         / \
        //        4   4
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);

        System.out.println("Test Case 2: " + isBalanced(root2) + ", Expected: false");
    }

    static boolean isBalanced = true;

    // Solution - O(n)
    public static boolean isBalanced(TreeNode root) {
        isBalanced = true;
        computeHeight(root);
        return isBalanced;
    }

    private static int computeHeight(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = computeHeight(root.left);
        int rightDepth = computeHeight(root.right);

        isBalanced = isBalanced && Math.abs(leftDepth - rightDepth) <= 1;

        return 1 + Math.max(leftDepth, rightDepth);
    }

}
