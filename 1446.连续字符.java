/*
 * @lc app=leetcode.cn id=1446 lang=java
 *
 * [1446] 连续字符
 */

// @lc code=start
class Solution {
    public int maxPower(String s) {
        int ret = 1;
        int cnt = 1;
        for(int i = 1;i < s.length();++i){
            if(s.charAt(i) == s.charAt(i - 1)){
                ++cnt;
            }else{
                ret = Math.max(ret, cnt);
                cnt = 1;
            }
        }
        ret = Math.max(ret, cnt);
        return ret;
    }
}
// @lc code=end

