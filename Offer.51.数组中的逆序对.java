import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
    int n;
    int uniqueN;
    int m;
    int[] c;
    Map<Integer, Integer> sparseTableMap = new HashMap<>();
    public int reversePairs(int[] nums) {
        n = nums.length;
        
        // 去重，排序
        int[] distinctArr = IntStream.of(nums).distinct().toArray();
        Arrays.sort(distinctArr);
        uniqueN = distinctArr.length;

        // 使用稀疏表，将每个值映射到稀疏表中的位置，不能确定值的范围，使用 HashMap
        for(int i = 0;i < uniqueN;++i){
            sparseTableMap.put(distinctArr[i], i + 1);
        }
        m = uniqueN + 1;
        c = new int[min2power(m)];
        int ans = 0;
        for(int i = n - 1;i >= 0;--i){
            int num = nums[i];
            int index = sparseTableMap.get(num);
            add(index, 1);
            ans += sum(index - 1);
        }
        return ans;
    }

    private int lowBit(int x){
        return x & ( -x );
    }

    private int min2power(int x){
        int ret = 1;
        while(x > ret){
            ret = ret << 1;
        }
        return ret;
    }

    private void add(int index, int v){
        while(index < m){
            c[index] += v;
            index += lowBit(index);
        }
    }

    private int sum(int index){
        int sum = 0;
        while(index > 0){
            sum += c[index];
            index -= lowBit(index);
        }
        return sum;
    }
}