import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=899 lang=java
 *
 * [899] 有序队列
 */

// @lc code=start
class Solution {
    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        if(k > 1){
            Arrays.sort(chars);
            return String.copyValueOf(chars);
        }
        char min = 'z';
        List<Integer> at = new ArrayList<>();
        for(int i = 0;i < chars.length;++i){
            min = min < chars[i]? min: chars[i];
        }
        for(int i = 0;i < chars.length;++i){
            if(chars[i] == min){
                at.add(i);
            }
        }
        int stepCnt = 0;
        while(at.size() != 1){
            if(stepCnt == chars.length){
                int head = at.get(0);
                at.clear();
                at.add(head);
            }
            min = 'z';
            List<Integer> nextAt = new ArrayList<>();
            for(var index: at){
                int next = (index + 1) % chars.length;
                min = min < chars[next]? min: chars[next];
            }
            for(var index: at){
                int next = (index + 1) % chars.length;
                if(chars[next] == min) {
                    nextAt.add(next);
                }
            }
            if(nextAt.isEmpty()){
                nextAt.add(at.get(0));
            }
            ++stepCnt;
            at = nextAt;
        }
        int head = (at.get(0) - stepCnt + chars.length) % chars.length;
        return s.substring(head) + s.substring(0, head);
    }
}
// @lc code=end

