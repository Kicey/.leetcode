import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {
    PriorityQueue<Integer> lessQueue = new PriorityQueue<>((a, b) -> {
        return - (a - b);
    });
    PriorityQueue<Integer> greaterQueue = new PriorityQueue<>();
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        if(lessQueue.isEmpty()){
            lessQueue.add(num);
            return;
        }
        if(lessQueue.size() == greaterQueue.size()){
            if(num > greaterQueue.peek()){
                greaterQueue.add(num);
                lessQueue.add(greaterQueue.poll());
            } else {
                lessQueue.add(num);
            }
        } else {
            if(num >= lessQueue.peek()){
                greaterQueue.add(num);
            } else {
                greaterQueue.add(lessQueue.poll());
                lessQueue.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(lessQueue.size() > greaterQueue.size()){
            return lessQueue.peek();
        }
        return ((double) lessQueue.peek() + greaterQueue.peek() )/ 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

