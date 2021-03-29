package Leetcode.Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.List;

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

class IntegerByRef{
    int val;
    IntegerByRef(int val){
        this.val = val;
    }
}

public class Solution {
    public static void solve(List<Integer> res,TreeNode root,int level,IntegerByRef maxLevel){
        if(level > maxLevel.val){
            res.add(root.val);
            maxLevel.val = level;
        }
        if(root.right != null){
            solve(res,root.right,level+1,maxLevel);
        }
        if(root.left != null){
            solve(res,root.left,level+1,maxLevel);
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        solve(ans,root,0,new IntegerByRef(-1));
        return ans;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        List<Integer> res = rightSideView(root);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
    }
}
