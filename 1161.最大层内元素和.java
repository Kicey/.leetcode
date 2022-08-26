import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1161 lang=java
 *
 * [1161] 最大层内元素和
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
    int maxLevelSum = Integer.MIN_VALUE;
    List<TreeNode> nodes = new ArrayList<>();
    public int maxLevelSum(TreeNode root) {
        int ans = 0;
        if(root == null){
            return 0;
        }
        nodes.add(root);
        int curLevel = 1;
        while(true){
            if(nodes.isEmpty()) break;
            List<TreeNode> nextNodes = new ArrayList<>(nodes.size());
            int curLevelSum = 0;
            for(var node: nodes){
                curLevelSum += node.val;
                if(node.left != null)nextNodes.add(node.left);
                if(node.right != null)nextNodes.add(node.right);
            }
            if(curLevelSum > maxLevelSum){
                ans = curLevel;
                maxLevelSum = curLevelSum;
            }
            ++curLevel;
            nodes = nextNodes;
        }
        return ans;
    }
}
// @lc code=end

