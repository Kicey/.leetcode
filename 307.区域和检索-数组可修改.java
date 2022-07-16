/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {
    int[] nums;
    int[] segementTree;

    public NumArray(int[] nums) {
        this.nums = nums;
        segementTree = new int[nums.length * 4];
        build(0, 0, nums.length);
    }
    
    public void update(int index, int val) {
        update(0, index, val, 0, nums.length);
    }
    
    public int sumRange(int left, int right) {
        return range(0, left, right + 1, 0, nums.length);
    }

    public void build(int node, int left, int right) {
        if (right - left == 1) {
            segementTree[node] = nums[left];
            return;
        }
        int mid = (left + right) / 2;
        build(node * 2 + 1, left, mid);
        build(node * 2 + 2, mid, right);
        segementTree[node] = segementTree[node * 2 + 1] + segementTree[node * 2 + 2];
    }

    public int range(int node, int left, int right, int lb, int up) {
        if (left == lb && right == up) {
            return segementTree[node];
        }
        int mid = (lb + up) / 2;
        if (right <= mid) {
            return range(node * 2 + 1, left, right, lb, mid);
        } else if (left >= mid) {
            return range(node * 2 + 2, left, right, mid, up);
        } else {
            return range(node * 2 + 1, left, mid, lb, mid) + range(node * 2 + 2, mid, right, mid, up);
        }
    }

    public void update(int node, int index, int value, int lb, int up) {
        if (index == lb && up == lb + 1) {
            segementTree[node] = value;
            return;
        }
        int mid = (lb + up) / 2;
        if (index < mid) {
            update(node * 2 + 1, index, value, lb, mid);
        } else {
            update(node * 2 + 2, index, value, mid, up);
        }
        segementTree[node] = segementTree[node * 2 + 1] + segementTree[node * 2 + 2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

