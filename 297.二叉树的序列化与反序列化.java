/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Codec {

    String[] nodes;
    int curIndex;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "-";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(root.val));
        String left = serialize(root.left);
        stringBuilder.append('_').append(left);
        String right = serialize(root.right);
        stringBuilder.append('_').append(right);
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        nodes = data.split("_");
        curIndex = 0;
        return deserialize();
    }

    private TreeNode deserialize() {
        if(nodes[curIndex].equals("-")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[curIndex]));
        ++curIndex;
        TreeNode left = deserialize();
        ++curIndex;
        TreeNode right = deserialize();
        root.left = left;
        root.right = right;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

