/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        return recurse(root)[1];
    }

    private int[] recurse(TreeNode root){
        if(root == null){
            return new int[]{Integer.MIN_VALUE / 4, Integer.MIN_VALUE / 4};
        }
        int[] left = recurse(root.left);
        int[] right = recurse(root.right);
        // System.out.printf("left: %d, %d, right: %d, %d\n", left[0], left[1], right[0], right[1]);
        int[] wayRound = new int[2];
        wayRound[0] = Math.max(root.val, Math.max(0, Math.max(left[0] + root.val, right[0] + root.val)));
        wayRound[1] = Math.max(
            root.val, 
            Math.max(
                Math.max(
                    left[0] + right[0] + root.val,
                    Math.max(left[1], right[1])), 
                Math.max(
                    left[0] + root.val,
                    right[0] + root.val)));
        return wayRound;
    }
}
// @lc code=end