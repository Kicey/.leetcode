import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
class Solution {
    int n;
    int uniqueN;
    Map<Integer, Integer> sparseMap = new HashMap<>();
    int[] c; // 树状数组
    int cn;
    public List<Integer> countSmaller(int[] nums) {
        n = nums.length;
        int[] uniqueNums = IntStream.of(nums).distinct().toArray();
        Arrays.sort(uniqueNums);
        uniqueN = uniqueNums.length;
        for(int i = 0;i < uniqueN;++i){
            sparseMap.put(uniqueNums[i], i + 1);
        }
        cn = uniqueN + 1;
        c = new int[cn];

        List<Integer> ans = new LinkedList<>();
        for(int i = n - 1;i >= 0;--i){
            int numIndex = sparseMap.get(nums[i]);
            ans.add(0, sum(numIndex - 1));
            add(numIndex, 1);
        }
        return ans;
    }

    private void add(int index, int v){
        while(index < cn) {
            c[index] += v;
            index += lowBit(index);
        }
    }

    private int lowBit(int x){
        return x & (-x);
    }

    private int sum(int index){
        int sum = 0;
        while(index > 0){
            sum += c[index];
            index -= lowBit(index);
        }
        return sum;
    }
}
// @lc code=end

