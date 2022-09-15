import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=321 lang=java
 *
 * [321] 拼接最大数
 */

// @lc code=start
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = null;
        for(int i = 0;i <= k;++i){
            int[] subSeq1 = maxSequence(nums1, i);
            int[] subSeq2 = maxSequence(nums2, k - i);
            int[] merged = maxMerge(subSeq1, subSeq2);
            if(ans == null){
                ans = merged;
            } else {
                if(Arrays.compare(ans, merged) < 0){
                    ans = merged;
                }
            }
        }
        return ans;
    }

    private int[] maxSequence(int[] nums, int size){
        int n = nums.length;
        int ableToDelete = n - size;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < n;++i){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() < num && ableToDelete > 0){
                stack.pop();
                --ableToDelete;
            }
            stack.add(num);
        }
        int[] ret = new int[size];
        for(int i = size -1;i >= 0;--i){
            ret[i] = stack.pop();
        }
        return ret;
    }

    private int[] maxMerge(int[] nums1, int[] nums2){
        List<int[]> cntList1 = cntList(nums1);
        List<int[]> cntList2 = cntList(nums2);
        int[] merged = new int[nums1.length + nums2.length];
        int mergedIndex = 0;
        int i0 = 0, i1 = 0;
        while(i0 < cntList1.size() || i1 < cntList2.size()){
            if(i0 == cntList1.size()){
                merged[mergedIndex++] = cntList2.get(i1)[0];
                i1 = nextIndex(cntList2, i1);
                continue;
            }
            if(i1 == cntList2.size()){
                merged[mergedIndex++] = cntList1.get(i0)[0];
                i0 = nextIndex(cntList2, i0);
                continue;
            }
            if(cntList1.get(i0)[0] < cntList2.get(i1)[0]){
                merged[mergedIndex++] = cntList2.get(i1)[0];
                i1 = nextIndex(cntList2, i1);
            }
            if(cntList1.get(i0)[0] > cntList2.get(i1)[0]){
                merged[mergedIndex++] = cntList1.get(i0)[0];
                i0 = nextIndex(cntList1, i0);
            }
            
        }
        return merged;
    }

    private int nextIndex(List<int[]> list, int index){
        --list.get(index)[1];
        if(list.get(index)[1] == 0){
            return index + 1;
        }
        return index;
    }

    private List<int[]> cntList(int[] nums){
        int n = nums.length;
        List<int[]> cntList = new ArrayList<>();
        for(int i = 0;i < n;++i){
            int num = nums[i];
            if(cntList.isEmpty() || cntList.get(cntList.size() - 1)[0] != num){
                cntList.add(new int[]{num, 1});
            } else {
                cntList.get(cntList.size() - 1)[1]++;
            }
        }
        return cntList;
    }
}
// @lc code=end

