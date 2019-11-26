package Serialize_and_Deserialize_BST;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode getOne = q.remove();
            if(getOne == null){
                str.append(",X");
                continue;
            }
            if(str.toString().length() > 0){
                str.append("," + getOne.val);
            }else{
                str.append(getOne.val);
            }
            if(getOne.left == null){
                q.add(null);
            }else{
                q.add(getOne.left);
            }
            if(getOne.right == null){
                q.add(null);
            }else{
                q.add(getOne.right);
            }
        }
        return str.toString();
    }

    public static TreeNode createNode(String x){
        if(x.equals("X")){
            return null;
        }
        return new TreeNode(Integer.parseInt(x));
    }


    public static TreeNode solve(String[] nodes,int idx){
        if(idx >= nodes.length){
            return null;
        }
        TreeNode root = createNode(nodes[idx]);
        if(root == null){
            return root;
        }
        root.left = solve(nodes,idx+1);
        root.right = solve(nodes,idx+2);
        return root;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return solve(nodes,0);
    }

    public static void main(String[] args){
        TreeNode x = new TreeNode(2);
        x.left = new TreeNode(1);
        x.right = new TreeNode(3);
        System.out.println(serialize(x));
        System.out.println(deserialize(serialize(x)).val);
    }
}
