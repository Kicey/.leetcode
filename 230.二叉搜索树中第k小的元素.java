import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    List<Integer> ans = new LinkedList<>();
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traceBackTok(root);
        return ans.get(k - 1);
    }

    private void traceBackTok(TreeNode curNode){
        if(curNode == null) return;
        traceBackTok(curNode.left);
        ans.add(curNode.val);
        if(ans.size() == k) return;
        traceBackTok(curNode.right);
    }
}
// @lc code=end

