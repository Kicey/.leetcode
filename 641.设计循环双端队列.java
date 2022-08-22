/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    int[] data;
    int n;
    int front = 0, last = 0;
    public MyCircularDeque(int k) {
        data = new int[k + 1];
        n = k + 1;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        front = (front + n - 1) % n;
        data[front] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        data[last] = value;
        last = (last + n + 1) % n;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front + n + 1) % n;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        last = (last + n - 1) % n;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return data[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return data[(last + n - 1) % n];
    }
    
    public boolean isEmpty() {
        return front == last;
    }
    
    public boolean isFull() {
        return (front + n - 1) % n == last;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

