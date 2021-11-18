import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 */

// @lc code=start
class MapSum {

    Map<String, Integer> map = new HashMap<>();

    public MapSum() {

    }
    
    public void insert(String key, int val) {
        map.put(key,val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(Map.Entry<String, Integer> e: map.entrySet()){
            if(e.getKey().startsWith(prefix)){
                sum += e.getValue();
            }
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

