#
# @lc app=leetcode.cn id=1401 lang=python3
#
# [1401] 圆和矩形是否有重叠
#

# @lc code=start
class Solution:
    def checkOverlap(self, radius: int, xCenter: int, yCenter: int, x1: int, y1: int, x2: int, y2: int) -> bool:
        x, y = float(x1 + x2) / 2, float(y1 + y2) / 2
        distance_of_center = float((x - xCenter) ** 2 + (y - yCenter) ** 2) ** 0.5
        print("%f %f %f %f" % (x, y, xCenter, yCenter))
        if x == xCenter:
            return abs(y - yCenter) <= radius + (y2 - y1) / 2
        if y == yCenter:
            return abs(x - xCenter) <= radius + (x2 - x1) / 2
        sec, csc = distance_of_center / abs(x - xCenter), distance_of_center / abs(y - yCenter)
        lenth_of_diagonal = float((y2 - y1) ** 2 + (x2 - x1) ** 2) ** 0.5
        lenth_within_rectangle: float # = max(sec * ((x2 - x1) / 2), csc * ((y2 - y1) / 2))
        if lenth_of_diagonal / (x2 - x1) > distance_of_center / abs(x - xCenter):
            lenth_within_rectangle = sec * ((x2 - x1) / 2)
        else:
            lenth_within_rectangle = csc * ((y2 - y1) / 2)
        print("sec: %f, csc: %f, length_within_rectangle: %f" % (sec, csc, lenth_within_rectangle))
        return distance_of_center <= radius + lenth_within_rectangle
# @lc code=end

