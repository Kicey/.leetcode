import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] vis;
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        n = nums.length;
        vis = new boolean[n];
        next(new ArrayList<>());
        return ans;
    }

    private void next(List<Integer> lastList) {
        if(lastList.size() == n){
            ans.add(lastList);
            return;
        }
        for(int i = 0 ;i < n;++i){
            if(i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]){
                continue;
            }
            if(!vis[i]){
                List<Integer> curList = new ArrayList<>();
                curList.addAll(lastList);
                curList.add(nums[i]);
                vis[i] = true;
                next(curList);
                vis[i] = false;
            }
        }
    }
}
// @lc code=end

