import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    int n, len;
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] vis;
    List<List<Integer>> pre = new ArrayList<>();
    Set<Integer> cur = new HashSet<>();
    Set<Integer> next = new HashSet<>();
    int begin, end;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(beginWord) < 0){
            wordList.add(beginWord);
        }
        if(wordList.indexOf(endWord) < 0){
            return new ArrayList<>();
        }
        begin = wordList.indexOf(beginWord);
        end = wordList.indexOf(endWord);
        n = wordList.size();
        len = beginWord.length();
        for(int i = 0;i < n;++i){
            graph.add(new ArrayList<>());
            pre.add(new ArrayList<>());
        }
        vis = new boolean[n];
        for(int i = 0;i < n;++i){
            for(int j = i + 1;j< n;++j){
                if(connected(wordList.get(i), wordList.get(j))){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        if(graph.get(begin).isEmpty()){
            return new ArrayList<>();
        }
        cur.add(begin);
        vis[begin] = true;
        bfs();
        if(pre.get(end).isEmpty()){
            return new ArrayList<>();
        }
        List<List<String>> curPath = new ArrayList<>();
        List<List<String>> nextPath = new ArrayList<>();
        Set<Integer> curPre = new HashSet<>();
        Set<Integer> nextPre = new HashSet<>();
        curPath.add(new ArrayList<>());
        curPre.add(end);
        while(!curPre.isEmpty()){
            nextPath.clear();
            nextPre.clear();
            for(int preNode: curPre){
                for(List<String> path: curPath){
                    String preWord = wordList.get(preNode);
                    if(!path.isEmpty() && !connected(preWord, path.get(0))) {
                        continue;
                    }
                    List<String> newPath = new ArrayList<>();
                    newPath.add(wordList.get(preNode));
                    newPath.addAll(path);
                    nextPath.add(newPath);
                }
                nextPre.addAll(pre.get(preNode));
            }
            Set<Integer> temp = curPre;
            curPre = nextPre;
            nextPre = temp;

            List<List<String>> tempPath = curPath;
            curPath = nextPath;
            nextPath = tempPath;
        }
        return curPath;
    }

    private void bfs(){
        while(!cur.isEmpty()){
            next.clear();
            for(int node: cur){
                for(int nextNode: graph.get(node)){
                    if(!vis[nextNode]){
                        pre.get(nextNode).add(node);
                        next.add(nextNode);
                    }
                }
            }
            for(Integer node: next){
                vis[node] = true;
            }
            Set<Integer> temp = cur;
            cur = next;
            next = temp;
        }
    }

    private boolean connected(String a, String b){
        int difCnt = 0;
        for(int i = 0;i < len;++i){
            if(a.charAt(i) != b.charAt(i)){
                ++difCnt;
            }
        }
        return difCnt == 1;
    }
}
// @lc code=end

