import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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
    // 问题的关键在于以一个容易比较的方式表示一棵树
    Map<String, Integer> map = new HashMap<>();
    Map<String, TreeNode> strToTree = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        List<TreeNode> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() > 1){
                ans.add(strToTree.get(entry.getKey()));
            }
        }
        return ans;
    }
    private String dfs(TreeNode root){
        if(root == null) return "-";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val).append("_");
        String leftstr = dfs(root.left);
        String rightStr = dfs(root.right);
        stringBuilder.append(leftstr).append(rightStr);
        String subTree = stringBuilder.toString();
        int preCnt = map.getOrDefault(subTree, 0);
        map.put(subTree, preCnt + 1);
        if(preCnt == 0){
            strToTree.put(subTree, root);
        }
        return subTree;
    }
}
// @lc code=end

