import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solution {
    int[] array;
    boolean[] vis;
    int k;
    int n;
    int cnt = 0;
    boolean ansGotten = false;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        array = new int[n];
        vis = new boolean[n];
        next(0);
        StringBuilder stringBuilder = new StringBuilder();
        for(int num: array){
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private void next(int index){
        if(ansGotten) return;
        if(index == n) {
            ++cnt;
            if(cnt == k){
                ansGotten = true;
                return;
            }
        }
        for(int i = 0;i < n;++i){
            if(vis[i]) continue;
            if(ansGotten) return;
            array[index] = i + 1;
            vis[i] = true;
            next(index + 1);
            vis[i] = false;
        }
    }

}
// @lc code=end

