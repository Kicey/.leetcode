import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=828 lang=java
 *
 * [828] 统计子串中的唯一字符
 */

// @lc code=start
class Solution {
    List<ArrayList<Integer>> indexs = new ArrayList<>();
    {
        for(int i = 0;i < 26;++i){
            indexs.add(new ArrayList<>());
        }
        for(int i = 0;i < 26;++i){
            indexs.get(i).add(-1);
        }
    }

    public int uniqueLetterString(String s) {
        for(int i = 0;i < s.length();++i){
            char c = s.charAt(i);
            indexs.get(c - 'A').add(i);
        }
        for(int i = 0;i < 26;++i){
            indexs.get(i).add(s.length());
        }
        int ans = 0;
        for(int i = 0;i < s.length();++i){
            char c = s.charAt(i);
            ArrayList<Integer> theIndex = indexs.get(c - 'A');
            int indexOfIndex = Collections.binarySearch(theIndex, i);
            int leftSize = 1, rightSize = 1;
            leftSize += (i - theIndex.get(indexOfIndex - 1)) - 1;
            rightSize += (theIndex.get(indexOfIndex + 1) - i - 1);
            System.out.println(leftSize * rightSize);
            ans += leftSize * rightSize;
        }
        return ans;
    }
}
// @lc code=end

