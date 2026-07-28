package easyproblems;

import java.util.Stack;

public class SameTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // p = [1,2,3], q = [1,2,3] — same
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Test Case 1: " + isSameTree(p1, q1) + ", Expected: true");

        System.out.println("\n========================");

        // p = [1,2], q = [1,null,2] — different structure
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println("Test Case 2: " + isSameTree(p2, q2) + ", Expected: false");

        System.out.println("\n========================");

        // p = [1,2,1], q = [1,1,2] — same structure, different values
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);

        System.out.println("Test Case 3: " + isSameTree(p3, q3) + ", Expected: false");

        System.out.println("\n========================");

        // p = [1,2,3], q = [1,2,9] — same structure, different values
        TreeNode p4 = new TreeNode(1);
        p4.left = new TreeNode(2);
        p4.right = new TreeNode(3);

        TreeNode q4 = new TreeNode(1);
        q4.left = new TreeNode(2);
        q4.right = new TreeNode(9);

        System.out.println("Test Case 4: " + isSameTree(p4, q4) + ", Expected: false");
    }

    // Solution - Time: O(n), Space: O(n)
    public static boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Stack<TreeNode> pTree = new Stack<>();
        Stack<TreeNode> qTree = new Stack<>();

        pTree.push(p);
        qTree.push(q);

        while(!pTree.isEmpty() && !qTree.isEmpty()) {
            TreeNode currP = pTree.pop();
            TreeNode currQ = qTree.pop();

            if(currP.val != currQ.val) return false;

            if(currP.left != null) {
                pTree.push(currP.left);
            }

            if(currQ.left != null) {
                qTree.push(currQ.left);
            }

            if (currP.right != null) {
                pTree.push(currP.right);
            }
            if (currQ.right != null) {
                qTree.push(currQ.right);
            }
        }

        return pTree.isEmpty() && qTree.isEmpty();
    }

    // Solution: Time: O(n), Space: O(h)
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
