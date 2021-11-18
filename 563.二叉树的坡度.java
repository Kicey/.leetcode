/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
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
    int sum = 0;
    public int findTilt(TreeNode root) {
        sum = 0;
        inorderTraverse(root);
        return sum;
    }

    private int inorderTraverse(TreeNode node){
        if(node == null) return 0;
        int leftSum = inorderTraverse(node.left);
        int rightSum = inorderTraverse(node.right);
        sum += Math.abs(rightSum - leftSum);
        return node.val + leftSum + rightSum;
    }
}
// @lc code=end

