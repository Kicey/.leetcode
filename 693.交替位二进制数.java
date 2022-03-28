/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n < 3) return true;
        int flag = n % 2;
        flag = flag ^ 1 & 1;
        while(n > 0){
            if(n % 2 == flag) return false;
            n /= 2;
            flag = flag ^ 1 & 1;
        }
        return true;
    }
}
// @lc code=end

