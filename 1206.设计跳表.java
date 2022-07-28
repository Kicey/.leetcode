import java.util.Random;

/*
 * @lc app=leetcode.cn id=1206 lang=java
 *
 * [1206] 设计跳表
 */

// @lc code=start
// 跳表 p 取 1/2
class Skiplist {
    final Random random = new Random();
    static final int MAX_LEVEL = 32;

    static class Node {
        int key;
        Node[] next = new Node[MAX_LEVEL];

        Node() {
        }

        Node(int key) {
            this.key = key;
        }
    }

    int level;
    Node head;

    public Skiplist() {
        head = new Node(Integer.MIN_VALUE);
        level = 0;
    }

    // 查询并返回访问过的结点
    public Node[] searchNodes(int target) {
        Node[] visited = new Node[MAX_LEVEL];
        Node cur = head;
        for (int i = level; i >= 0; --i) {
            while (cur.next[i] != null && cur.next[i].key < target)
                cur = cur.next[i];
            visited[i] = cur;
        }
        return visited;
    }

    public boolean search(int target) {
        Node[] visitedNodes = searchNodes(target);
        if (visitedNodes[0].next[0] != null && visitedNodes[0].next[0].key == target) {
            return true;
        }
        return false;
    }

    public void add(int num) {
        Node[] visitedNodes = searchNodes(num);
        Node added = new Node(num);
        int curLevel;
        for (curLevel = 0; curLevel < MAX_LEVEL; ++curLevel) {
            if (visitedNodes[curLevel] != null) {
                added.next[curLevel] = visitedNodes[curLevel].next[curLevel];
                visitedNodes[curLevel].next[curLevel] = added;
            } else{
                head.next[curLevel] = added;
            }
            if (random.nextInt(2) == 1)
                break;
        }
        level = curLevel;
    }

    public boolean erase(int num) {
        Node[] visitedNodes = searchNodes(num);
        Node erased = visitedNodes[0].next[0];
        if (erased == null || erased.key != num)
            return false;
        for (int i = 0; i <= level; ++i) {
            if (visitedNodes[i].next[i].key != num)
                break;
            visitedNodes[i].next[i] = erased.next[i];
        }
        return true;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
// @lc code=end
