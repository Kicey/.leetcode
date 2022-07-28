import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    List<List<Integer>> pre;
    boolean[] vis;
    int n;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        pre = new ArrayList<>();
        for(int i = 0;i < numCourses;++i){
            pre.add(new ArrayList<>());
        }
        vis = new boolean[numCourses];
        n = numCourses;
        for(int[] prerequisite: prerequisites) {
            pre.get(prerequisite[0]).add(prerequisite[1]);
        }
        for(int i = 0;i < n;++i){
            if(!pre.get(i).isEmpty()) {
                if(!learnRecursively(i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean learnRecursively(int courseNum) {
        if(pre.get(courseNum).isEmpty()) {
            return true;
        }
        if(vis[courseNum]) {
            return false;
        }
        vis[courseNum] = true;
        boolean able = true;
        for(int preCourse: pre.get(courseNum)) {
            able = able && learnRecursively(preCourse);
        }
        if(able) {
            pre.get(courseNum).clear();
            return true;
        }
        return false;
    }
    
}
// @lc code=end

