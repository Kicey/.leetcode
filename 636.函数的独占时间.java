import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=636 lang=java
 *
 * [636] 函数的独占时间
 */

// @lc code=start
class Solution {
    int n;
    Stack<int[]> stack = new Stack<>();
    int[] sums;
    public int[] exclusiveTime(int n, List<String> logs) {
        this.n = n;
        sums = new int[n];
        String[] firstLog = logs.get(0).split(":");
        int lastTimeStamp = Integer.valueOf(firstLog[2]);
        stack.push(new int[]{0});
        for(int i = 1;i < logs.size();++i){
            String[] log = logs.get(i).split(":");
            int curTime = Integer.valueOf(log[2]);
            if(log[1].equals("start")) {
                if(!stack.isEmpty()){
                    int elapsed = curTime - lastTimeStamp;
                    var sum = stack.peek();
                    sum[0] += elapsed;
                }
                stack.push(new int[]{0});
                lastTimeStamp = curTime;
            } else {
                int elapsed = curTime + 1 - lastTimeStamp;
                int curTask = Integer.valueOf(log[0]);
                int sum = stack.pop()[0];
                sums[curTask] += sum + elapsed;
                lastTimeStamp = curTime + 1;
            }
        }
        return sums;
    }
}
// @lc code=end

