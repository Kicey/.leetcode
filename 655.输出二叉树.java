import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
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
    Map<Integer, Integer> map = new HashMap<>();
    int curLevel = -1;
    int maxLevel = Integer.MIN_VALUE;
    public List<List<String>> printTree(TreeNode root) {
        recurse(root, 0);
        int n = (1 << (maxLevel + 1)) - 1;
        System.out.println(n);
        String[] baseStr = new String[n];
        Arrays.fill(baseStr, "");
        List<Integer> space = new ArrayList<>();
        for(int i = 0;i < n;i += 2){
            space.add(i);
        }
        int end = 2 * n + 1;
        int start = n;
        LinkedList<List<String>> ans = new LinkedList<>();
        while(!space.isEmpty()){
            end = start;
            start = end - space.size();
            String[] cur = baseStr.clone();
            for(int i = 0;i < end - start;++i){
                if(map.containsKey(start + i)){
                    cur[space.get(i)] = map.get(start + i).toString();
                }
            }
            ans.addFirst(Arrays.asList(cur));
            List<Integer> newSpace = new ArrayList<>();
            for(int i = 1;i < space.size();i += 2){
                newSpace.add((space.get(i - 1) + space.get(i)) / 2);
            }
            space = newSpace;
        }
        return ans;
    }
    
    private void recurse(TreeNode root, int no){
        if(root == null){
            return;
        }
        ++curLevel;
        maxLevel = Math.max(maxLevel, curLevel);
        map.put(no, root.val);
        recurse(root.left, no * 2 + 1);
        recurse(root.right, no * 2 + 2);
        --curLevel;
    }
}
// @lc code=end

