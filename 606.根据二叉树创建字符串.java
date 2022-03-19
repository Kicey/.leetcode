/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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

    StringBuilder stringBuilder = new StringBuilder();

    public void mlr(TreeNode root) {
        if(root != null){
            stringBuilder.append(root.val);
        }
        if(root == null){
            return;
        }
        
        if(root.left != null || root.right != null){
            stringBuilder.append('(');
            tree2str(root.left);
            stringBuilder.append(')');
        }
        
        if(root.right != null){
            stringBuilder.append('(');
            tree2str(root.right);
            stringBuilder.append(')');
        }
    }

    public String tree2str(TreeNode root) {
        mlr(root);
        return stringBuilder.toString();
    }
}
// @lc code=end

