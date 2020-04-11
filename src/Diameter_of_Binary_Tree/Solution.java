package Diameter_of_Binary_Tree;

public class Solution {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static int ans = 0;

    public static int rec(TreeNode root){
        if(root.left == null && root.right == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        if(root.left != null){
            left = 1 + rec(root.left);
        }
        if(root.right != null){
            right = 1 + rec(root.right);
        }
        ans = Math.max(ans, left + right);
        return Math.max(left,right);
    }


    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        rec(root);
        return ans;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
}
