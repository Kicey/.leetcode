/*
 * @lc app=leetcode.cn id=623 lang=java
 *
 * [623] 在二叉树中增加一行
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
    int curDepth = 1;
    boolean isLeftChild = true;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(curDepth == depth) {
            if(root == null){
                return new TreeNode(val);
            }
            TreeNode added;
            if(isLeftChild){
                added = new TreeNode(val, root, null);
            } else {
                added = new TreeNode(val, null, root);
            }
            return added;
        }
        if(root == null) return null;
        ++curDepth;
        isLeftChild = true;
        root.left = addOneRow(root.left, val, depth);
        isLeftChild = false;
        root.right = addOneRow(root.right, val, depth);
        --curDepth;
        return root;
    }
}
// @lc code=end

