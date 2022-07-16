import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=729 lang=java
 *
 * [729] 我的日程安排表 I
 */

// @lc code=start
class MyCalendar {
    class TreeNode {
        int left, right;
        int val;
        int add;
    }
    int N = (int)1e9 + 1;
    List<TreeNode> segementTree = new ArrayList<>();
    public MyCalendar() {
        segementTree.add(new TreeNode());
    }
    
    public boolean book(int start, int end) {
        if( sumRange(0, start, end, 0, N) >0) return false;
        update(0, start, end, 0, N, 1);
        return true;
    }

    public int sumRange(int node, int left, int right, int lb, int ub) throws StackOverflowError {
        TreeNode curNode = segementTree.get(node);
        if (lb == left && right == ub) {
            return curNode.val;
        }
        int mid = (lb + ub) / 2;
        createSub(node);
        pushDown(node, lb, ub, mid);
        if (right <= mid) {
            return sumRange(curNode.left, left, right, lb, mid);
        } else if(left >= mid) {
            return sumRange(curNode.right, left, right, mid, ub);
        } else {
            return sumRange(curNode.left, left, mid, lb, mid) + sumRange(curNode.right, mid, right, mid, ub);
        }
    }

    public void createSub(int node) {
        TreeNode curNode = segementTree.get(node);
        if(curNode.left == 0) {
            segementTree.add(new TreeNode());
            curNode.left = segementTree.size() - 1;
        }
        if(curNode.right == 0) {
            segementTree.add(new TreeNode());
            curNode.right = segementTree.size() - 1;
        }
    }

    public void pushDown(int node, int lb, int ub, int mid) {
        TreeNode curNode = segementTree.get(node);
        if(curNode.add == 0) return;
        TreeNode leftNode = segementTree.get(curNode.left);
        TreeNode rightNode = segementTree.get(curNode.right);
        leftNode.add += curNode.add;
        rightNode.add += curNode.add;
        leftNode.val += (mid - lb) * curNode.add;
        rightNode.val += (ub - mid) * curNode.add;
        curNode.add = 0;
    }

    public void update(int node, int left, int right, int lb, int ub, int v) {
        TreeNode curNode = segementTree.get(node);
        // [left, rigth) 完全覆盖节点对应的区间
        if (left == lb && ub == right) {
            curNode.val += (ub - lb) * v;
            curNode.add += v;
            return;
        }
        createSub(node);
        int mid = (lb + ub) / 2;
        pushDown(node, lb, ub, mid);
        if (left >= mid) {
            update(curNode.right, left, right, mid, ub, v);
        } else if(right <= mid) {
            update(curNode.left, left, right, lb, mid, v);
        } else {
            update(curNode.left, left, mid, lb, mid, v);
            update(curNode.right, mid, right, mid, ub, v);
        }
        curNode.val = segementTree.get(curNode.left).val + segementTree.get(curNode.right).val;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

