package Leetcode.MergeTwoBinaryTrees;

public class Solution {
      public class TreeNode {
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


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
          TreeNode newOne;
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }

        newOne = new TreeNode(root1.val + root2.val);
        newOne.left = mergeTrees(root1.left,root2.left);
        newOne.right = mergeTrees(root1.right,root2.right);

        return newOne;

    }

    public static void main(String[] args){

    }
}
