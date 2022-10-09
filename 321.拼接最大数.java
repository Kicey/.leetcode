import java.util.Arrays;
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
        for(int i = 0;i <= nums1.length;++i){
            if(k - i > nums2.length || k - i < 0) {
                continue;
            }
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

    /**
     * 返回长度为 {@param size} 的最大数
     * @param nums
     * @param size
     * @return
     */
    private int[] maxSequence(int[] nums, int size){
        int n = nums.length;
        int ableToDelete = n - size;
        Stack<Integer> stack = new Stack<>();
        // 单调栈处理
        for(int i = 0;i < n;++i){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() < num && ableToDelete > 0){
                stack.pop();
                --ableToDelete;
            }
            if(stack.size() < size) stack.add(num);
            else --ableToDelete;
        }
        // if(size == 1) System.out.printf("size: %s\n", stack.size());
        int[] ret = new int[size];
        // System.out.printf("array: %s, size: %d, stack.size: %d\n", Arrays.toString(nums), size, stack.size());
        for(int i = size - 1;i >= 0;--i){
            ret[i] = stack.pop();
        }
        return ret;
    }

    // 将两个数组合并
    private int[] maxMerge(int[] numsa, int[] numsb){
        int lena = numsa.length, lenb = numsb.length;
        int[] merged = new int[lena + lenb];
        int mergedIndex = 0;
        int ia = 0, ib = 0;
        while(ia < lena && ib < lenb){
            int compareRet = compare(numsa, ia, numsb, ib);
            int added = 0;
            if(compareRet >= 0){
                added = numsa[ia++];
            } else {
                added = numsb[ib++];
            }
            merged[mergedIndex++] = added;
        }
        for(;ia < lena;){
            merged[mergedIndex++] = numsa[ia++];
        }
        for(;ib < lenb;){
            merged[mergedIndex++] = numsb[ib++];
        }
        // System.out.println(Arrays.toString(numsa));
        // System.out.println(Arrays.toString(numsb));
        return merged;
    }

    private int compare(int[] a, int ia, int[] b, int ib){
        int lena = a.length, lenb = b.length;
        for(;ia < lena && ib < lenb;++ia, ++ib){
            if(a[ia] != b[ib]){
                return a[ia] - b[ib];
            }
        }
        if(ia != lena && ib == lenb){
            return 1;
        }
        if(ib != lenb && ia == lena){
            return -1;
        }
        return 0;
    }
}
// @lc code=end

