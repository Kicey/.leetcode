import java.sql.RowId;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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
    public int longestUnivaluePath(TreeNode root) {
        return dfs(root)[1] - 1;
    }

    private int[] dfs(TreeNode root){
        int[] ret = new int[]{1, 1, 1};
        int[] leftMax = null;
        int[] rightMax = null;
        if(root != null && root.left != null){
            leftMax = dfs(root.left);
            if(root.left.val == root.val){
                ret[0] = leftMax[0] + 1;
            }
        }
        if(root != null && root.right != null){
            rightMax = dfs(root.right);
            if(root.right.val == root.val){
                ret[1] = rightMax[0] + 1;
            }
        }
        ret[2] = ret[0] + ret[1] - 1;
        if(leftMax != null){
            ret[2] = Math.max(ret[2], leftMax[1]);
        }
        if(rightMax != null){
            ret[2] = Math.max(ret[2], rightMax[1]);
        }
        return new int[]{Math.max(ret[0], ret[1]), ret[2]};
    }
}
// @lc code=end

