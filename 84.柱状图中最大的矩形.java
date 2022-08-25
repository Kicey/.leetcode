import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    List<Integer> heightsWithGuard = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    int[] left, right;
    int n = 0;
    public int largestRectangleArea(int[] heights) {
        heightsWithGuard.add(0);
        for(int height: heights){
            heightsWithGuard.add(height);
        }
        heightsWithGuard.add(0);
        n = heightsWithGuard.size();
        left = new int[n];
        right = new int[n];
        for(int i = 0;i < n;++i){
            while(!stack.empty() && heightsWithGuard.get(i) < heightsWithGuard.get(stack.peek())){
                right[stack.pop()] = i;
            }
            if(!stack.empty()){
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1;i < n;++i){
            ans = Math.max(ans, heightsWithGuard.get(i) * (right[i] - left[i] - 1));
        }
        return ans;
    }
}
// @lc code=end

