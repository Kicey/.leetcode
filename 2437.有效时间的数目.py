#
# @lc app=leetcode.cn id=2437 lang=python3
#
# [2437] 有效时间的数目
#

# @lc code=start
class Solution:
    def countTime(self, time: str) -> int:
        # 1. 分割时间
        h, m = time.split(':')
        # 2. 判断是否有效
        if int(h) < 24 and int(m) < 60:
            return 1
        return 0
# @lc code=end

