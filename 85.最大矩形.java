import java.util.Stack;

/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    int n, m;
    int[][] leftLen;
    public int maximalRectangle(char[][] matrix) {
        n = matrix.length + 2;
        m = matrix[0].length;
        leftLen = new int[n][m];
        for(int i = 0;i < n - 2;++i){
            int lenIncluded = 0;
            for(int j = 0;j < m;++j){
                if(matrix[i][j] == '0'){
                    lenIncluded = 0;
                    continue;
                }
                leftLen[i + 1][j] = ++lenIncluded;
            }
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = Integer.MIN_VALUE;
        for(int j = 0;j < m;++j){
            Stack<Integer> stack = new Stack<>();
            for(int i = 0;i < n;++i){
                while(!stack.isEmpty() && leftLen[i][j] < leftLen[stack.peek()][j]){
                    right[stack.pop()] = i;
                }
                if(!stack.empty()){
                    left[i] = stack.peek();
                }
                stack.push(i);
            }
            for(int i =  1;i < n - 1;++i){
                ans = Math.max(ans, leftLen[i][j] * (right[i] - left[i] - 1));
            }
        }
        return ans;
    }
}
// @lc code=end

