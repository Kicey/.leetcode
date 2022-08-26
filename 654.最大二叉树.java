import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    static class SegementTree{
        int val;
        int left = 0, right = 0;
    }
    int[] nums;
    List<SegementTree> segementTree = new ArrayList<>();
    int n;
    int[] num2index;
    final int MAX_LIMIT = (int)1E3;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        n = nums.length;
        num2index = new int[MAX_LIMIT];
        for(int i = 0;i < n;++i){
            num2index[nums[i]] = i;
        }
        segementTree.add(new SegementTree());
        build(0, 0, n);
        return generateTree(0, n);
    }

    private void build(int node, int lb, int ub){
        SegementTree curNode = segementTree.get(node);
        if(lb + 1 == ub){
            curNode.val = nums[lb];
            return;
        }
        confirmSubNode(node);
        int mid = (lb + ub) / 2;
        build(curNode.left, lb, mid);
        build(curNode.right, mid, ub);
        curNode.val = Math.max(segementTree.get(curNode.left).val, segementTree.get(curNode.right).val);
    }

    private void confirmSubNode(int node){
        SegementTree curNode = segementTree.get(node);
        if(curNode.left == 0){
            segementTree.add(new SegementTree());
            curNode.left = segementTree.size() - 1;
        }
        if(curNode.right == 0){
            segementTree.add(new SegementTree());
            curNode.right = segementTree.size() - 1;
        }
    }

    private int rangeMax(int node, int lb, int ub, int left, int right){
        SegementTree curNode = segementTree.get(node);
        if(lb == left && ub == right){
            return curNode.val;
        }
        int mid = (lb + ub) / 2;
        if(right <= mid){
            return rangeMax(curNode.left, lb, mid, left, right);
        } else if(left >= mid){
            return rangeMax(curNode.right, mid, ub, left, right);
        } else {
            return Math.max(rangeMax(curNode.left, lb, mid, left, mid), rangeMax(curNode.right, mid, ub, mid, right));
        }
    }
    private TreeNode generateTree(int lb, int ub){
        if(lb == ub){
            return null;
        }
        int rangeMax = rangeMax(0, 0, n, lb, ub);
        int index = num2index[rangeMax];
        System.out.printf("%d %d %d\n", lb, ub, index);
        TreeNode curNode = new TreeNode(rangeMax);
        curNode.left = generateTree(lb, index);
        curNode.right = generateTree(index + 1, ub);
        return curNode;
    }
}
// @lc code=end

