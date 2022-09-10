import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1656 lang=java
 *
 * [1656] 设计有序流
 */

// @lc code=start
class OrderedStream {
    int index = 0;
    String[] data;
    public OrderedStream(int n) {
        data = new String[n];
    }
    
    public List<String> insert(int idKey, String value) {
        data[idKey - 1] = value;
        if(data[index] != null){
            List<String> ret = new ArrayList<>();
            while(index < data.length && data[index] != null){
                ret.add(data[index++]);
            }
            return ret;
        }
        return new ArrayList<>();
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
// @lc code=end

