import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=519 lang=java
 *
 * [519] 随机翻转矩阵
 */

// @lc code=start
class Solution {
    
    int m, n, size;
    Set<Integer> set = new HashSet<>();
    Random random = new Random();
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        size = m * n;
    }
    
    public int[] flip() {
        int index = random.nextInt(size);
        while (set.contains(index)) {
            index = random.nextInt(size);
        }
        set.add(index);
        return new int[]{index / n, index % n};
    }
    
    public void reset() {
        set.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
// @lc code=end

