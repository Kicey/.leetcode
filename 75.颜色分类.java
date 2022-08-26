import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    Random random = new Random();

    public void sortColors(int[] nums) {
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        sort(boxedNums, 0, boxedNums.length, (a, b) -> {
            return a - b;
        });
        IntStream.range(0, boxedNums.length).forEach(i -> nums[i] = boxedNums[i].intValue());
    }

    // 三向切分
    private <T> void sort(T[] array, int start, int end, Comparator<T> comparator){
        if(start < end){
            int lt = start, i = start + 1, gt = end;
            int[] vi = new int[3];
            int len = end - start;
            vi[0] = start + random.nextInt(len); vi[1] = start + random.nextInt(len); vi[2] = start + random.nextInt(len);
            if(comparator.compare(array[vi[0]], array[vi[1]]) > 0){
                swapInt(vi, 0, 1);
            }
            if(comparator.compare(array[vi[1]], array[vi[2]]) > 0){
                swapInt(vi, 1, 2);
            }
            if(comparator.compare(array[vi[0]], array[vi[1]]) > 0){
                swapInt(vi, 0, 1);
            }
            swap(array, start, vi[1]);
            T v = array[start];
            while(i < gt){
                if(comparator.compare(array[i], v) < 0){
                    swap(array, i++, lt++);
                } else if(comparator.compare(array[i], v) > 0){
                    swap(array, i, --gt);
                } else{
                    ++i;
                }
            }
            sort(array, start, lt, comparator);
            sort(array, gt, end, comparator);
        }
    }

    private <T> void swap(T[] array, int a, int b){
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void swapInt(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
// @lc code=end

