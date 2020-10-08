package Leetcode.Symmetric_Tree;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void inorder_traversal(TreeNode root, List<Integer> res){
        if(root == null){
            res.add(-1);
            return;
        }
        if(root.left == null && root.right == null){
            res.add(root.val);
            return;
        }
        inorder_traversal(root.left,res);
        res.add(root.val);
        inorder_traversal(root.right,res);
    }

    public static boolean isSymmetric(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder_traversal(root,res);
        int last = res.size()-1;
        for(int i=0;i<res.size();i++){
            if(res.get(i) != res.get(last)){
                return false;
            }
            last--;
        }
        return true;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(isSymmetric(root));
    }
}