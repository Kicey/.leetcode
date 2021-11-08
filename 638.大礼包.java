import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @lc app=leetcode.cn id=638 lang=java
 *
 * [638] 大礼包
 */

// @lc code=start
class Solution {

    int n;
    List<Integer> price;
    List<List<Integer>> special;
    Map<List<Integer>,Integer> minPriceOn = new HashMap<>();
    int minPrice = 0;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.n = price.size();
        this.price = price;

        this.special = special.parallelStream().filter(list ->{
            int sum = 0;
            for(int i = 0;i < n;++i){
                sum += list.get(i) * price.get(i);
            }
            return sum > list.get(n);
        }).collect(Collectors.toList());

        Stream.iterate(0, i -> i + 1).limit(n).forEach(
            x ->{
                minPrice += needs.get(x) * price.get(x);
            }
        );
        
        return dfs(needs,  minPrice);
    }

    private int dfs(List<Integer> needs, int curPrice){

        if(minPriceOn.containsKey(needs)){
            return minPriceOn.get(needs);
        }

        int lastPrice = curPrice;

        for(int i = 0;i < special.size();++i){

            List<Integer> curSpecial = special.get(i);

            boolean flag = false;
            for(int j = 0;j < n;++j){
                if(curSpecial.get(j) > needs.get(j)){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;

            List<Integer> newNeeds = new ArrayList<>();
            for(int j = 0;j < n;++j){
                newNeeds.add(needs.get(j) - curSpecial.get(j));
            }
            int newPrice = 0;
            for(int j = 0;j < n;++j){
                newPrice += newNeeds.get(j) * price.get(j);
            }
            int remainingPrice = dfs(newNeeds, newPrice);
            lastPrice = Math.min(lastPrice, curSpecial.get(n) + remainingPrice);
        }

        minPriceOn.put(needs, lastPrice);
        return lastPrice;
    }

}
// @lc code=end

