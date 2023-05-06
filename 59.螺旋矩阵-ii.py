#
# @lc app=leetcode.cn id=59 lang=python3
#
# [59] 螺旋矩阵 II
#

# @lc code=start
from typing import List

class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        # 1. 初始化
        matrix = [[0 for _ in range(n)] for _ in range(n)]
        # 2. 定义上下左右边界
        top, bottom, left, right = 0, n - 1, 0, n - 1
        # 3. 定义当前值
        cur = 1
        # 4. 循环
        while top <= bottom and left <= right:
            # 4.1 从左到右
            for i in range(left, right + 1):
                matrix[top][i] = cur
                cur += 1
            top += 1
            # 4.2 从上到下
            for i in range(top, bottom + 1):
                matrix[i][right] = cur
                cur += 1
            right -= 1
            # 4.3 从右到左
            for i in range(right, left - 1, -1):
                matrix[bottom][i] = cur
                cur += 1
            bottom -= 1
            # 4.4 从下到上
            for i in range(bottom, top - 1, -1):
                matrix[i][left] = cur
                cur += 1
            left += 1
        return matrix
# @lc code=end

