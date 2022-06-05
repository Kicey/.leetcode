/*
 * @lc app=leetcode.cn id=478 lang=java
 *
 * [478] 在圆内随机生成点
 */

// @lc code=start
class Solution {

    private double redius;
    private double xC;
    private double yC;

    public Solution(double radius, double x_center, double y_center) {
        this.redius = radius;
        this.xC = x_center;
        this.yC = y_center;
    }
    
    public double[] randPoint() {
        double angle = Math.random() * Math.PI * 2;
        double rho = Math.sqrt( Math.random() * redius * redius);
        double x = xC + rho * Math.cos(angle);
        double y = yC + rho * Math.sin(angle);
        return new double[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
// @lc code=end

