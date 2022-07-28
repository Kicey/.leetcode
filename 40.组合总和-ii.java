import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    int n;
    List<Integer> candidates = new ArrayList<>();
    List<Integer> times = new ArrayList<>();
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates.add(candidates[0]);
        times.add(1);
        int curIndex = 0;
        for(int i = 1;i < candidates.length;++i){
            if(candidates[i] == candidates[i - 1]){
                times.set(curIndex, times.get(curIndex) + 1);
            } else {
                ++curIndex;
                this.candidates.add(candidates[i]);
                this.times.add(1);
            }
        }
        n = this.candidates.size();
        this.target = target;
        return dfs(0, 0);
    }

    private List<List<Integer>> dfs(int index, int sum){
        List<List<Integer>> ret = new ArrayList<>();
        if(index == n){
            return ret;
        }
        var num = candidates.get(index);
        for(var added = 0;added + sum <= target && added <= num * times.get(index);added += num){
            if(sum + added == target){
                List<Integer> cur = new ArrayList<>();
                for(int i = 0;i * num < added;++i){
                    cur.add(num);
                }
                ret.add(cur);
            } else if(sum + added < target){
                List<List<Integer>> conbinations = dfs(index + 1, sum + added);
                if(!conbinations.isEmpty()){
                    for(var conbination: conbinations) {
                        for(int i = 0;i * num < added;++i){
                            conbination.add(num);
                        }
                    }
                    ret.addAll(conbinations);
                }
            }
        }
        return ret;     
    }
}
// @lc code=end

