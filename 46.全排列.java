import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> remains;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        remains = new HashSet<>(n);
        for(int num: nums){
            remains.add(num);
        }
        pickFromRemain(new ArrayList<>());
        return ans;
    }

    private void pickFromRemain(List<Integer> list){
        if(list.size() == n){
            ans.add(list);
            return;
        }
        Integer[] remainedNums = new Integer[remains.size()];
        remains.toArray(remainedNums);
        for(Integer num: remainedNums){
            List<Integer> nextList = new ArrayList<>();
            nextList.addAll(list);
            nextList.add(num);
            remains.remove(num);
            pickFromRemain(nextList);
            remains.add(num);
        }
    }
}
// @lc code=end

