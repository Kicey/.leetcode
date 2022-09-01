import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
class Solution {
    int n;
    static class Slope {
        int dx, dy;
        Slope(int dy, int dx){
            this.dx = dx;
            this.dy = dy;
        }
    }
    public int maxPoints(int[][] points) {
        if(points.length <= 2){
            return points.length;
        }
        n = points.length;
        int max = 2;
        for(int i = 0;i < n;++i){
            Map<Slope, Integer> map = new TreeMap<>((a, b)->{
                if(a.dx == b.dx && a.dy == b.dy){
                    return 0;
                }
                if(a.dx == b.dx){
                    return a.dy - b.dy;
                }
                return a.dx - b.dx;
            });
            for(int j = i + 1;j < n;++j){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if(dx < 0){
                    dy *= -1;
                    dx *= -1;
                }
                if(dx == 0){
                    dy = Integer.MAX_VALUE;
                } else if(dy == 0){
                    dx = 0;
                }else {
                    int gcd = gcd(Math.abs(dx), Math.abs(dy));
                    dx /= gcd;
                    dy /= gcd;
                }
                Slope curSlope = new Slope(dy, dx);
                int previousCnt = map.getOrDefault(curSlope, 1);
                map.put(curSlope, previousCnt + 1);
                max = Math.max(max, previousCnt + 1);
            }
        }
        return max;
    }

    private int gcd(int a, int b){
        int tmp = 0;
        while(a % b != 0){
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}
// @lc code=end

