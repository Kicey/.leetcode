/*
 * @lc app=leetcode.cn id=998 lang=java
 *
 * [998] 最大二叉树 II
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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(val > root.val) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        } else {
            if(root.right == null){
                root.right = new TreeNode(val);
                return root;
            }
            TreeNode right = insertIntoMaxTree(root.right, val);
            root.right = right;
            return root;
        }
    }
}
// @lc code=end

