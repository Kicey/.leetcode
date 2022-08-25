import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = Arrays.binarySearch(arr, x);
        int left, right, cnt;
        if(index < 0){
            index = - (index + 1);
            left = right = index;
            cnt = 0;
        } else{
            left = index;
            right = left + 1;
            cnt = 1;
        }
        while(cnt < k){
            if( right == arr.length || left > 0 && Math.abs(arr[left - 1] - x) <= Math.abs(arr[right] - x)){
                --left;
            } else {
                ++right;
            }
            ++cnt;
        }
        List<Integer> ans = new ArrayList<>();
        for(;left < right;++left){
            ans.add(arr[left]);
        }
        return ans;
    }
}
// @lc code=end

