package Leetcode.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.HashMap;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTreeRec(int[] preorder,int p_start,int p_end, int[] inorder, int i_start,int i_end, HashMap<Integer,Integer> indices){
        if(p_start>p_end || p_start>=preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        if(p_start == p_end){
            return root;
        }
        int idx = indices.get(preorder[p_start]);
        root.left = buildTreeRec(preorder, p_start+1, p_start+idx-i_start,inorder,i_start, idx-1,indices);
        root.right = buildTreeRec(preorder, p_start+idx-i_start+1, p_end,inorder,idx+1, i_end,indices);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            indices.put(inorder[i],i);
        }
        return buildTreeRec(preorder,0,preorder.length-1,inorder,0,inorder.length-1,indices);
    }
}