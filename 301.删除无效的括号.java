import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 */

// @lc code=start
class Solution {

    long times = 0;
    Set<String> ans = new HashSet<>();
    StringBuilder cur = new StringBuilder();
    int toRemoveLeft = 0;
    int toRemoveRight = 0;
    
    int n;
    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        cur = new StringBuilder(s);
        for(int i = 0;i < s.length();++i){
            if(s.charAt(i) == '(') ++toRemoveLeft;
            if(s.charAt(i) == ')'){
                if(toRemoveLeft > 0) --toRemoveLeft;
                else ++toRemoveRight;
            }
        }
        
        
        if(toRemoveLeft == 0 && toRemoveRight == 0){
            /*
            if(isLegal(s)){
                return Arrays.asList(s);
            }else{
                return Arrays.asList(new String());
            }
            */
            return Arrays.asList(s);
        }
        

        //if(toRemove < 0) target = ')';
        //toRemove = Math.abs(toRemove);

        //System.out.println("toRemove:"+toRemove);
        //System.out.println(cur.toString());
        dfs(0);
        
        if(ans.isEmpty()) return Arrays.asList(new String());
        return new LinkedList<>(ans);
    }

    private void dfs(int index){
        
        if(toRemoveLeft == 0 && toRemoveRight == 0){
            //System.out.println("final");
            String temp = cur.toString();
            if(isLegal(temp)){
                ans.add(temp);
            }
            return;
        }

        if(index + toRemoveLeft + toRemoveRight > cur.length()){
            return;
        }
        
        if(cur.charAt(index) == '(' && toRemoveLeft > 0){
            //System.out.println("cur:"+cur.toString()+"EOF");
            cur.deleteCharAt(index);
            --toRemoveLeft;
            dfs(index);
            cur.insert(index, '(');
            ++toRemoveLeft;
        }else if(cur.charAt(index) == ')' && toRemoveRight > 0){
            cur.deleteCharAt(index);
            --toRemoveRight;
            dfs(index);
            cur.insert(index, ')');
            ++toRemoveRight;
        }
        dfs(index + 1);
    }

    private boolean isLegal(String s){
        int left = 0;
        for(int i = 0;i < s.length();++i){
            if(s.charAt(i) == '(') ++left;
            if(s.charAt(i) == ')') --left;
            if(left < 0) return false;
        }
        if(left != 0) return false;
        return true;
    }
}

// @lc code=end

