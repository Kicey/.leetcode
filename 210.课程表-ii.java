import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> pre;
    boolean[] vis;
    boolean[] learned;
    int n;
    List<Integer> ans;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        pre = new ArrayList<>();
        ans = new ArrayList<>();
        vis = new boolean[n];
        learned = new boolean[n];
        for (int i = 0; i < numCourses; ++i) {
            pre.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            pre.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < n; ++i) {
            if (!learnRecursively(i)) {
                return new int[0];
            }
        }
        Integer[] ansArray = new Integer[n];
        ansArray = ans.toArray(ansArray);
        return Arrays.stream(ansArray).mapToInt(Integer::valueOf).toArray();
    }

    private boolean learnRecursively(int courseNum) {
        if (pre.get(courseNum).isEmpty()) {
            if (!learned[courseNum]) {
                learned[courseNum] = true;
                ans.add(courseNum);
            }
            return true;
        }
        if (vis[courseNum]) {
            return false;
        }
        vis[courseNum] = true;
        boolean able = true;
        for (int preCourseNum : pre.get(courseNum)) {
            able = able && learnRecursively(preCourseNum);
        }
        if (able) {
            pre.get(courseNum).clear();
            ans.add(courseNum);
            learned[courseNum] = true;
            return true;
        }
        return false;
    }
}
// @lc code=end
