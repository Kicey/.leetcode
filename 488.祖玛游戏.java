import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=488 lang=java
 *
 * [488] 祖玛游戏
 */

// @lc code=start
class Solution0 {
    final int Max = 0x3fffffff;
    int[] handRemain = new int[26];
    Map<String, Integer> assist = new HashMap<>();
    public int findMinStep(String board, String hand) {
        for(char c : hand.toCharArray()){
            ++handRemain[c - 'A'];
        }
        int res = dfs(board);
        return res == Max ? -1 : res;
    }

    private int dfs(String board){
        if(board.isEmpty()) return 0;
        int ret = Max;
        // 遍历插入位置
        for(int i = 0;i < board.length() + 1;++i){
            String nextBoard = null;
            for(int j = 0;j < 26;++j){
                if(handRemain[j] <= 0) continue;
                
                handRemain[j]--;
                
                nextBoard = board.substring(0, i) + (char)(j + 'A') + board.substring(i);
                if(assist.containsKey(nextBoard)){
                    ret = Math.min(ret, assist.get(nextBoard) + 1);
                }else{
                    nextBoard = deleteContinuesDuplicateFrom(nextBoard, i);
                    ret = Math.min(ret, dfs(nextBoard) + 1);
                }
                handRemain[j]++;
            }
        }
        assist.put(board, ret);
        return ret;
    }

    private String deleteContinuesDuplicateFrom(String str, int from){
        int l = from, r;
        while(str.length() > 2){
            char c = str.charAt(l);
            r = l + 1;
            while(l > 0 && str.charAt(l - 1) == c) --l;
            while(r < str.length() && str.charAt(r) == c) ++r;
            if(r - l < 3) break;
            str = str.substring(0, l) + str.substring(r);
            if(l == str.length()){
                l = l - 1;
            }
        }
        return str;
    }
    public static void main(String[] args) {
        Solution0 s = new Solution0();
        System.out.println(s.findMinStep("RBYYBBRRB","YRBGB"));
    }
}
// @lc code=end

