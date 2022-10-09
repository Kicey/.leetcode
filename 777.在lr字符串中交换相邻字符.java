import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=777 lang=java
 *
 * [777] 在LR字符串中交换相邻字符
 */

// @lc code=start
class Solution {
    // start 和 end 中 L 换 R 的数量必须相等
    // L 能左移, R 能右移, 判断在任何一个位置，左边的 L 和 R 数量是相等的
    int n;
    List<int[]> startCntLR = new ArrayList<>();
    List<int[]> endCntLR = new ArrayList<>();
    List<int[]> startCntOnly = new ArrayList<>();
    List<int[]> endCntOnly = new ArrayList<>();
    public boolean canTransform(String start, String end) {
        n = start.length();
        cntLR(start, startCntLR, startCntOnly);
        cntLR(end, endCntLR, endCntOnly);
        if(startCntLR.size() != endCntLR.size()){
            return false;
        }
        if(startCntOnly.size() != endCntOnly.size()){
            return false;
        }
        for(int i = 0;i < startCntOnly.size();++i){
            int[] startOnly = startCntOnly.get(i);
            int[] endOnly = endCntOnly.get(i);
            if(startOnly[0] != endOnly[0] || startOnly[1] != endOnly[1]){
                return false;
            }
        }
        for(int i = 0;i < startCntLR.size();++i){
            int[] startLR = startCntLR.get(i);
            int[] endLR = endCntLR.get(i);
            if(startLR[0] > endLR[0]){
                return false;
            }
            if(startLR[1] < endLR[1]){
                return false;
            }
        }
        return true;
    }

    private void cntLR(String str, List<int[]> cntLR, List<int[]> onlyLR){
        int curL = 0, curR = 0;
        for(int i = 0;i < n;++i){
            if(str.charAt(i) == 'L'){
                ++curL;
                onlyLR.add(new int[]{curL, curR});
            } else if(str.charAt(i) == 'R'){
                ++curR;
                onlyLR.add(new int[]{curL, curR});
            }
            cntLR.add(new int[]{curL, curR});
        }
    }
}
// @lc code=end

