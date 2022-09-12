import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    int n;
    TreeMap<Integer, Integer> treeMap = new TreeMap<>((a, b) -> {
        return -(a - b);
    });
    List<Integer> ans = new ArrayList<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        n = nums.length;
        int i = 0;
        for(;i < k;++i){
            int cnt = treeMap.getOrDefault(nums[i], 0);
            treeMap.put(nums[i], cnt + 1);
        }
        ans.add(treeMap.firstKey());
        for(;i < n;++i){
            int cnt = treeMap.get(nums[i - k]);
            if(cnt == 1){
                treeMap.remove(nums[i - k]);
            } else {
                treeMap.put(nums[i - k], cnt - 1);
            }
            cnt = treeMap.getOrDefault(nums[i], 0);
            treeMap.put(nums[i], cnt + 1);
            ans.add(treeMap.firstKey());
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

