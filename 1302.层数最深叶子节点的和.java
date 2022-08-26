import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1302 lang=java
 *
 * [1302] 层数最深叶子节点的和
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
    List<Integer> levelSum = new ArrayList<>();
    int curLevel = 0;
    public int deepestLeavesSum(TreeNode root) {
        recurse(root);
        return levelSum.get(levelSum.size() - 1);
    }

    private void recurse(TreeNode root){
        if(curLevel == levelSum.size()){
            levelSum.add(root.val);
        } else {
            levelSum.set(curLevel, levelSum.get(curLevel) + root.val);
        }
        ++curLevel;
        if(root.left != null){
            recurse(root.left);
        }
        if(root.right != null){
            recurse(root.right);
        }
        --curLevel;
    }
}
// @lc code=end

