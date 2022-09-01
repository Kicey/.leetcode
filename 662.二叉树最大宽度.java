import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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
    TreeMap<Integer, int[]> treeMap = new TreeMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        recurse(root, 0, 0);
        int ans = 0;
        for(Map.Entry<Integer, int[]> kv: treeMap.entrySet()){
            ans = Math.max(ans, kv.getValue()[1] - kv.getValue()[0] + 1);
        }
        return ans;
    }

    private void recurse(TreeNode root, int num, int level){
        if(root == null){
            return;
        }
        int[] record = treeMap.getOrDefault(level, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
        record[0] = Math.min(record[0], num);
        record[1] = Math.max(record[1], num);
        treeMap.put(level, record);
        recurse(root.left, num * 2 + 1, level + 1);
        recurse(root.right, num * 2 + 2, level + 1);
    }
}
// @lc code=end

