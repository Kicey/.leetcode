/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 /*
 */

class Solution {

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lrm(root, p, q);
        return ans;
    }

    public int lrm(TreeNode cur, TreeNode p, TreeNode q){
        int count = 0;
        if(cur.left != null) count += lrm(cur.left, p, q);
        if(cur.right != null) count += lrm(cur.right, p, q);
        if(cur == p || cur == q) ++count;
        if(ans == null && count == 2) ans = cur;
        return count;
    }
}
// @lc code=end

