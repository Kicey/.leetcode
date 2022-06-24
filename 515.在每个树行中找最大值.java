import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    Queue<TreeNode> queue = new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        queue.add(root);
        while(!queue.isEmpty()){
            List<TreeNode> temp = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if(left != null){
                    temp.add(left);
                }
                if(right != null){
                    temp.add(right);
                }
            }
            if(!temp.isEmpty()) {
                int max = temp.get(0).val;
                for(int i = 1;i < temp.size(); ++i) {
                    max = Math.max(max, temp.get(i).val);
                }
                res.add(max);
            }
            for(TreeNode node : temp){
                queue.add(node);
            }
        }
        return res;
    }
}
// @lc code=end

