/*
 * @lc app=leetcode.cn id=794 lang=java
 *
 * [794] 有效的井字游戏
 */

// @lc code=start
class Solution {
    public boolean validTicTacToe(String[] board) {
        int num_x = 0;
        int num_o = 0;
        for(String row: board){
            for(char e: row.toCharArray()){
                if(e=='X'){
                    num_x++;
                }
                else if(e == 'O'){
                    num_o++;
                }
            }
        }
        if(num_x - num_o != 0 && num_x - num_o != 1) return false;
        int cnt = 0;
        for(int i = 0;i < 3;++i){
            String row = board[i];
            if(row.charAt(0) != ' '){
                int j = 1;
                for(;j < 3;++j){
                    if(row.charAt(j) != row.charAt(j - 1)) break;
                }
                if(j == 3){
                    cnt++;
                    if(row.charAt(0) == 'X' && num_o == num_x) return false;
                    if(row.charAt(0) == 'O' && num_o != num_x) return false;
                }
            }
        }
        if(cnt > 1) return false;
        cnt = 0;
        for(int i = 0;i < 3;++i){
            if(board[0].charAt(i) != ' '){
                int j = 1;
                for(;j < 3;++j){
                    if(board[j].charAt(i) != board[j - 1].charAt(i)) break;
                }
                if(j == 3){
                    cnt++;
                    if(board[0].charAt(i) == 'X' && num_o == num_x) return false;
                    if(board[0].charAt(i) == 'O' && num_o != num_x) return false;
                }
            }
        }
        if(cnt > 1) return false;
        if(board[1].charAt(1) != ' '){
            if((board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) || board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)){
                if(board[1].charAt(1) == 'X' && num_o == num_x) return false;
                if(board[1].charAt(1) == 'O' && num_o != num_x) return false;
            }
            
        }
        return true;
    }
}
// @lc code=end

