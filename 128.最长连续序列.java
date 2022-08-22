import java.util.Map;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    int n;
    int[] uniqueNums;
    int[] ufArray;
    Map<Integer, Integer> hashMap;

    private int findRoot(int index) {
        if(ufArray[index] == index){
            return index;
        }
        int root = findRoot(ufArray[index]);
        ufArray[index] = root;
        return root;
    }

    private int unionRoot(int indexA, int indexB){
        int rootA = findRoot(indexA);
        int rootB = findRoot(indexB);
        if(rootA == rootB) return indexA;
        ufArray[rootB] = rootA;
        return rootA;
    }

    public int longestConsecutive(int[] nums) {
        n = nums.length;
        ufArray = new int[n];
        hashMap = new HashMap<>(n);
        int cnt = 0;
        for(int i = 0;i < n;++i){
            if(hashMap.containsKey(nums[i])) {
                continue;
            }
            ufArray[cnt] = cnt;
            hashMap.put(nums[i], cnt);
            ++cnt;
        }
        n = cnt;
        uniqueNums = new int[n];
        for(var kv: hashMap.entrySet()){
            uniqueNums[kv.getValue()] = kv.getKey();
        }
        for(int i = 0;i < n;++i){
            int num = uniqueNums[i];
            int left = num - 1;
            if(hashMap.containsKey(left)){
                unionRoot(hashMap.get(left), i);
            }
        }
        Map<Integer, Integer> statistic = new HashMap<>();
        for(int i = 0;i < n;++i){
            statistic.put(findRoot(i), statistic.getOrDefault(ufArray[i], 0) + 1);
        }
        int ans = 0;
        for(var v: statistic.values()){
            if(v > ans){
                ans = v;
            }
        }
        return ans;
    }
}
// @lc code=end

