import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    Map<Integer, Integer> numToIndex = new HashMap<>();
    int[] preorder, inorder;
    int n;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        n = preorder.length;
        for(int i = 0;i < n;++i){
            numToIndex.put(inorder[i], i);
        }
        return build(0, n, 0, n);
    }

    /**
     * 
     * @param pl 前序遍历左边界，闭
     * @param pr 前序遍历右边界，开
     * @param il 中序遍历左边界，闭
     * @param ir 中序遍历右边界，开
     * @return
     */
    private TreeNode build(int pl, int pr, int il, int ir){
        // System.out.printf("%d %d %d %d\n", pl, pr, il, ir);
        if(pl == pr || il == ir){
            return null;
        }
        int rootVal = preorder[pl];
        int inIndex = numToIndex.get(rootVal);
        int leftSize = inIndex - il;
        TreeNode cur = new TreeNode(rootVal);
        cur.left = build(pl + 1, pl + 1 + leftSize, il, inIndex);
        cur.right = build(pl + leftSize + 1, pr, inIndex + 1, ir);
        return cur;
    }
}
// @lc code=end

