import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=391 lang=java
 *
 * [391] 完美矩形
 */

// @lc code=start
class Solution {
    
    // 用顶点的个数判定有没有交叠（矩形不完全相同的），用面积判定是否有完全相同的矩形的交叠（）
    public boolean isRectangleCover(int[][] rectangles) {
        Map<Point, Integer> angleCount = new HashMap<>();
        Long area = 0l;
        Integer[] tl = new Integer[2], tr = new Integer[2], bl = new Integer[2], br = new Integer[2];

        Point bl_ = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point tr_ = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for(int[] twoPoint: rectangles){
            area += (long) (twoPoint[2] - twoPoint[0]) * (twoPoint[3] - twoPoint[1]);

            tl[0] = bl[0] = twoPoint[0];
            tr[0] = br[0] = twoPoint[2];
            tl[1] = tr[1] = twoPoint[3];
            bl[1] = br[1] = twoPoint[1];

            if(twoPoint[0] <= bl_.x && twoPoint[1] <= bl_.y) bl_ = new Point(twoPoint[0], twoPoint[1]);
            if(twoPoint[2] >= tr_.x && twoPoint[3] >= tr_.y) tr_ = new Point(twoPoint[2], twoPoint[3]);

            Integer [][] fourAngle = new Integer[][]{tl, tr, bl, br};
            for(Integer[] angle: fourAngle){
                Point point = new Point(angle[0], angle[1]);
                angleCount.put(point, angleCount.getOrDefault(point, 0) + 1);
            }
        }

        //System.out.println(bl_);
        //System.out.println(tr_);

        if(area != (long)(tr_.y - bl_.y) * (long)(tr_.x - bl_.x)) return false;

        if(angleCount.get(bl_) != 1
            || angleCount.get(tr_) != 1
            || angleCount.getOrDefault(new Point(bl_.x, tr_.y), -1) != 1
            || angleCount.getOrDefault(new Point(tr_.x, bl_.y), -1) != 1)
            return false;
        angleCount.remove(bl_);
        angleCount.remove(tr_);
        angleCount.remove(new Point(bl_.x, tr_.y));
        angleCount.remove(new Point(tr_.x, bl_.y));

        for(Integer times: angleCount.values()){
            if(times != 4 && times != 2) return false;
        }

        return true;
    }
}

class Point{
    final int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x * ((int)1e5 + 1) + y;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Point)) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public String toString() {
        return String.format("Point(%d):{%d,%d}", hashCode(), x, y);
    }
}
// @lc code=end

