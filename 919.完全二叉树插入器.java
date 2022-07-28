import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=919 lang=java
 *
 * [919] 完全二叉树插入器
 */

// @lc code=start
/**
 * Definition for a binary tree node.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class CBTInserter {

    Queue<TreeNode> que = new ArrayDeque<>();
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        initQue(root);
    }

    public void initQue(TreeNode root){
        que.add(root);
        while(!que.isEmpty()){
            TreeNode curNode = que.peek();
            if(curNode.left != null){
                que.add(curNode.left);
            }
            if(curNode.right != null) {
                que.add(curNode.right);
            }
            if(curNode.left != null && curNode.right != null) {
                que.remove();
            }else{
                break;
            }
        }
    }
    
    public int insert(int val) {
        TreeNode head = que.peek();
        if(head.left == null) {
            TreeNode newNode= new TreeNode(val);
            head.left = newNode;
            que.add(newNode);
            return head.val;
        }else{
            TreeNode newNode = new TreeNode(val);
            head.right = newNode;
            que.add(newNode);
            que.remove();
            return head.val;
        }
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
// @lc code=end

