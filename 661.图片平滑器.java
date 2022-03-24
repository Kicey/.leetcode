/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */

// @lc code=start
class Solution {

    int blockSum;
    int blockNum;

    int m, n;
    int[][] img;
    public int[][] imageSmoother(int[][] img) {

        this.img = img;
        m = img.length;
        n = img[0].length;

        int[][] ans = new int[m][n];
        
        blockSum = 0;
        blockNum = 0;
        init();
        for(int i = 0;i < m;++i){
            for(int j = 0;j < n;++j){
                ans[i][j] = blockSum / blockNum;
                rightShift(i, j);
            }
        }

        return ans;
    }

    private void init(){
        blockSum += img[0][0];
        blockNum = 1;
        if(n > 1){
            blockSum += img[0][1];
            blockNum += 1;
        } 
        if(m > 1){
            blockSum += img[1][0];
            blockNum += 1;
        }
        if(m > 1 && n > 1){
            blockSum += img[1][1];
            blockNum += 1;
        }
    }

    private void rightShift(int i, int j){
        if(j == n - 1){
            nextLine(i, j);
            return;
        }
        int preCol = j - 1;
        int topRow = i - 1 > 0 ? i - 1: 0;
        int bottomRow = i + 1 < m ? i + 1: m - 1;
        if(preCol >= 0){
            for(int x = topRow;x <= bottomRow;++x){
                blockSum -= img[x][preCol];
                blockNum--;
            }
        }
        int nxtCol = j + 2;
        if(nxtCol < n){
            for(int x = topRow;x <= bottomRow;++x){
                blockSum += img[x][nxtCol];
                blockNum++;
            }
        }
    }

    private void nextLine(int i, int j){
        if(i == m - 1 && j == n - 1){
            return;
        }
        int ni = i + 1;
        int topRow = ni - 1 > 0 ? ni - 1: 0;
        int bottomRow = ni + 1 < m ? ni + 1: m - 1;
        blockSum = 0;
        blockNum = 0;
        for(int x = topRow;x <= bottomRow;++x){
            blockSum += img[x][0];
            blockNum += 1;
            if(n > 1){
                blockSum += img[x][1];
                blockNum += 1;
            } 
        }
    }
}
// @lc code=end

