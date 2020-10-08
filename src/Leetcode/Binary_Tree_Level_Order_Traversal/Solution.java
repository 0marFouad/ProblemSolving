package Leetcode.Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qt = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            while(!q.isEmpty()){
                qt.add(q.remove());
            }
            while(!qt.isEmpty()){
                TreeNode n = qt.remove();
                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
                l.add(n.val);
            }
            res.add(l);
        }
        return res;
    }
}
