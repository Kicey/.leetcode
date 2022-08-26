import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=782 lang=java
 *
 * [782] 变为棋盘
 */

// @lc code=start
class Solution {
    int n;
    List<Integer> rows = new ArrayList<>();
    boolean[] rowTypes;
    int rowTypeCnt0 = 0, rowTypeCnt1 = 0;
    List<Integer> cols = new ArrayList<>();
    boolean[] colTypes;
    int colTypeCnt0 = 0, colTypeCnt1 = 0;
    boolean rowFirst = false;
    boolean colFirst = false;
    public int movesToChessboard(int[][] board) {
        n = board.length;
        rowTypes = new boolean[n];
        colTypes = new boolean[n];
        for(int[] row: board){
            int rowFlag = 0;
            for(int i = 0;i < n;++i){
                if(row[i] == 1){
                    rowFlag |= (1 << i);
                }
            }
            rows.add(rowFlag);
        }
        int std = rows.get(0);
        int reverse = 0;
        for(int i = 0;i < n;++i){
            if(((std >> i) & 1) == 0){
                reverse |= (1 <<i);
            }
        }
        for(int i = 0;i < n;++i){
            if(rows.get(i) == std){
                rowTypes[i] = true;
                ++rowTypeCnt0;
            } else if(rows.get(i) == reverse){
                rowTypes[i] = false;
                ++rowTypeCnt1;
            } else {
                return -1;
            }
        }
        for(int col = 0;col < n;++col){
            int colFlag = 0;
            for(int row = 0;row < n;++row){
                if(board[row][col] == 1){
                    colFlag |= (1 << row);
                }
            }
            cols.add(colFlag);
        }
        std = cols.get(0);
        reverse = 0;
        for(int i = 0;i < n;++i){
            if(((std >> i) & 1) == 0){
                reverse |= (1 <<i);
            }
        }
        for(int i = 0;i < n;++i){
            if(cols.get(i) == std){
                colTypes[i] = true;
                ++colTypeCnt0;
            } else if(cols.get(i) == reverse){
                colTypes[i] = false;
                ++colTypeCnt1;
            } else {
                return -1;
            }
        }
        if(n % 2 == 0){
            if(rowTypeCnt0 != rowTypeCnt1 || colTypeCnt0 != colTypeCnt1){
                return -1;
            }
            rowFirst = rowTypes[0];
            colFirst = colTypes[0];
        } else {
            if(Math.abs(rowTypeCnt0 - rowTypeCnt1) != 1 || Math.abs(colTypeCnt0 - colTypeCnt1) != 1){
                return -1;
            }
            if(rowTypeCnt0 > rowTypeCnt1){
                rowFirst = true;
            }
            if(colTypeCnt0 > colTypeCnt1){
                colFirst = true;
            }
        }
        int ans = 0;
        int rowDif = 0, colDif = 0;
        for(int i = 0;i < n;i += 2){
            if(rowTypes[i] != rowFirst){
                ++rowDif;
            }
            if(colTypes[i] != colFirst){
                ++colDif;
            }
        }
        if(n % 2 != 0){
            ans = rowDif + colDif;
        } else {
            ans = Math.min(n / 2 - rowDif, rowDif) + Math.min(n / 2 - colDif, colDif);
        }
        return ans;
    }
}
// @lc code=end

