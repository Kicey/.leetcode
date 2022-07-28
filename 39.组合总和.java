import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    int[] candidates;
    int target;
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.n = candidates.length;
        this.target = target;
        return dfs(0, 0);
    }

    private List<List<Integer>> dfs(int index, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(index == n){
            return ret;
        }
        var num = candidates[index];
        for(var added = 0;added + sum <= target;added += num){
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

