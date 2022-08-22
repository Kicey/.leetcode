import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1450 lang=java
 *
 * [1450] 在既定时间做作业的学生人数
 */

// @lc code=start
class Solution {
    static class SegementTree {
        int val = 0, add = 0;
        int left = 0, right = 0;
    }
    List<SegementTree> segementTree = new ArrayList<>();
    final int MaxBound = (int) 1e3 + 1;
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        segementTree.add(new SegementTree());
        int n = startTime.length;
        for(int i = 0;i < n;++i){
            update(0, 0, MaxBound, startTime[i], endTime[i] + 1, 1);
        }
        return sumRange(0, 0, MaxBound, queryTime, queryTime + 1);
    }

    private void update(int node, int lb, int ub, int left, int right, int val){
        SegementTree curNode = segementTree.get(node);
        if(left == lb && right == ub){
            curNode.val += (ub - lb) * val;
            curNode.add += val;
            return;
        }
        confirmSubNode(node);
        int mid = (lb + ub) / 2;
        pushDown(node, lb, ub);
        if(right <= mid){
            update(curNode.left, lb, mid, left, right, val);
        } else if(left >= mid){
            update(curNode.right, mid, ub, left, right, val);
        } else {
            update(curNode.left, lb, mid, left, mid, val);
            update(curNode.right, mid, ub, mid, right, val);
        }
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

    private void pushDown(int node, int lb, int ub){
        SegementTree curNode = segementTree.get(node);
        if(curNode.add == 0) {
            return;
        }
        int mid = (ub + lb) / 2;
        SegementTree leftNode = segementTree.get(curNode.left);
        SegementTree rightNode = segementTree.get(curNode.right);
        leftNode.val += (mid - lb) * curNode.add;
        leftNode.add += curNode.add;
        rightNode.val += (ub - mid) * curNode.add;
        rightNode.add += curNode.add;
        curNode.add = 0;
    }

    private int sumRange(int node, int lb, int ub, int left, int right){
        SegementTree curNode = segementTree.get(node);
        if(left == lb && right == ub){
            return curNode.val;
        }
        confirmSubNode(node);
        pushDown(node, lb, ub);
        int mid = (ub + lb) / 2;
        if(right <= mid){
            return sumRange(curNode.left, lb, mid, left, right);
        } else if(left >= mid){
            return sumRange(curNode.right, mid, ub, left, right);
        } else{
            return sumRange(curNode.left, lb, mid, left, mid) + sumRange(curNode.right, mid, ub, mid, right);
        }
    }
}
// @lc code=end

