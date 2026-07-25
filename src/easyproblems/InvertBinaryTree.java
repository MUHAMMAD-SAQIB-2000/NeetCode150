package easyproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // Build: [1,2,3,4,5,6,7]
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //    4  5 6  7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Test Case 1: " + toLevelOrder(invertTree(root)) + ", Expected: [1,3,2,7,6,5,4]");
    }

    public static String toLevelOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean first = true;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (!first) sb.append(",");
            first = false;

            if (current == null) {
                sb.append("null");
            } else {
                sb.append(current.val);
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Complexity: O(n) time, O(n) space
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return root;
    }

    public static TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = invertTreeRecursive(root.right);
        root.right = invertTreeRecursive(temp);

        return root;
    }
}
