/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
    int[] data;
    int front = 0, end = 0;
    boolean isEmpty = true;
    public MyCircularQueue(int k) {
        data = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull())return false;
        data[end] = value;
        end = (end + 1) % data.length;
        isEmpty = false;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty) return false;
        front = (front + 1) % data.length;
        if(front == end) isEmpty = true;
        return true;
    }
    
    public int Front() {
        if(isEmpty) return -1;
        return data[front];
    }
    
    public int Rear() {
        if(isEmpty) return -1;
        return data[(end - 1 + data.length) % data.length];    
    }
    
    public boolean isEmpty() {
        return isEmpty;
    }
    
    public boolean isFull() {
        if(isEmpty) return false;
        return front == end;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

