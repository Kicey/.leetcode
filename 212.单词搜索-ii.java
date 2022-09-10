import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    static class Trie {
        Trie[] next = new Trie[26];
        int[] cnt = new int[26];
        String s;
    }
    int n, m;
    boolean[][] vis;
    int[][] direct = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Trie root;
    char[][] board;
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        n = board.length;
        m = board[0].length;
        vis = new boolean[n][m];
        root = new Trie();
        for(String word: words){
            addToTrie(root, word);
        }
        for(int i = 0;i < n;++i){
            for(int j = 0;j < m;++j){
                dfs(root, i, j);
            }
        }
        return ans;
    }

    private void dfs(Trie pre, int x, int y){
        if(pre == null) return;
        vis[x][y] = true;
        char c = board[x][y];
        int index = c - 'a';
        if(pre.cnt[index] == 0){
            vis[x][y] = false;
            return;
        }
        if(pre.next[index].s != null){
            ans.add(pre.next[index].s);
            delete(pre.next[index].s);
        }
        for(int i = 0;i < 4;++i){
            int nx = x + direct[i][0];
            int ny = y + direct[i][1];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                continue;
            }
            if(vis[nx][ny]){
                continue;
            }
            dfs(pre.next[index], nx, ny);
        }
        vis[x][y] = false;
    }

    private void addToTrie(Trie root, String word){
        Trie pre = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            ++pre.cnt[index];
            if(pre.next[index] == null){
                pre.next[index] = new Trie();
            }
            pre = pre.next[index];
        }
        pre.s = word;
    }

    private void delete(String word){
        deleteRecurse(root, word, 0);
    }

    private boolean deleteRecurse(Trie root, String word, int i){
        if(i == word.length()){
            if(root.s != null){
                root.s = null;
                return true;
            }
            return false;
        }
        int index = word.charAt(i) - 'a';
        if(root.cnt[index] == 0){
            return false;
        }
        boolean deleted = deleteRecurse(root.next[index], word, i + 1);
        if(deleted){
            --root.cnt[index];
        }
        if(root.cnt[index] == 0){
            root.next[index] = null;
        }
        return true;
    }
}
// @lc code=end

