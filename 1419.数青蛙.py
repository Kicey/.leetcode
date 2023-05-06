#
# @lc app=leetcode.cn id=1419 lang=python3
#
# [1419] 数青蛙
#

# @lc code=start
class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        c, r, o, a, k = 0, 0, 0, 0, 0
        max_frog = 0
        for cur_str in croakOfFrogs:
            if cur_str == 'c':
                c += 1
            elif cur_str == 'r':
                r += 1
            elif cur_str == 'o':
                o += 1
            elif cur_str == 'a':
                a += 1
            elif cur_str == 'k':
                k += 1
            if c >= r and r >= o and o >= a and a >= k:
                max_frog = max(max_frog, c - k)
            else:
                return -1

        if c == r == o == a == k:
            return max_frog
        else:
            return -1
# @lc code=end

