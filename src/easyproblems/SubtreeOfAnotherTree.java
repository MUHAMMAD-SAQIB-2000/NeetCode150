package easyproblems;

public class SubtreeOfAnotherTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // root = [3,4,5,1,2], subRoot = [4,1,2] — subRoot IS a subtree
        //        3
        //       / \
        //      4   5
        //     / \
        //    1   2
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        TreeNode subRoot1 = new TreeNode(4);
        subRoot1.left = new TreeNode(1);
        subRoot1.right = new TreeNode(2);

        System.out.println("Test Case 1: " + isSubtree(root1, subRoot1) + ", Expected: true");

        System.out.println("\n========================");

        // root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2] — NOT a subtree (extra node under 2)
        //        3
        //       / \
        //      4   5
        //     / \
        //    1   2
        //       /
        //      0
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(2);
        root2.left.right.left = new TreeNode(0);

        TreeNode subRoot2 = new TreeNode(4);
        subRoot2.left = new TreeNode(1);
        subRoot2.right = new TreeNode(2);

        System.out.println("Test Case 2: " + isSubtree(root2, subRoot2) + ", Expected: false");
    }

    // Solution - Time: O(n x m), Space: O(height_root + height_subRoot)
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(root.val == subRoot.val && isSameTree(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}