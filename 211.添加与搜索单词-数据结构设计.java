import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {

    static class Node implements Comparable<Node>{
        Character val;
        Boolean end = false;
        Map<Character, Node> map;
        
        Node(Character val){
            this.val = val;
            map = new HashMap<>();
        }

        @Override
        public int compareTo(Node node) {
            return val - node.val;
        }

    }

    Node root = new Node(null);

    public WordDictionary() {

    }
    
    public void addWord(String word) {
        Node cur = root;
        int i;
        for(i = 0;i < word.length();++i){
            char cc = word.charAt(i);
            if(! cur.map.containsKey(cc)){
                cur.map.put(cc, new Node(cc));
            }
            cur = cur.map.get(cc);
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(Node curNode, String word, int index){
        if(index == word.length()){
            return curNode.end;
        }
        char cc = word.charAt(index);
        if(curNode.map.size() == 0) return false;
        if(cc == '.'){
            for(Map.Entry<Character, Node> e : curNode.map.entrySet()){
                if(dfs(e.getValue(), word, index + 1)) return true;
            }
            return false;
        }
        if(!curNode.map.containsKey(cc)) return false;
        return dfs(curNode.map.get(cc), word, index + 1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

