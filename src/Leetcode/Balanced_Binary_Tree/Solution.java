package Leetcode.Balanced_Binary_Tree;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode getHeights(TreeNode x){
        if(x == null){
            return null;
        }
        TreeNode l = getHeights(x.left);
        TreeNode r = getHeights(x.right);
        int ln = l == null ? 0 : l.val;
        int rn = r == null ? 0 : r.val;
        TreeNode cur = new TreeNode(1 + Math.max(ln,rn));
        cur.left = l;
        cur.right = r;
        return cur;
    }

    public static boolean testTree(TreeNode root){
        if(root == null){
            return true;
        }
        int ln = root.left == null ? 0 : root.left.val;
        int rn = root.right == null ? 0 : root.right.val;
        if(Math.abs(ln - rn) > 1){
            return false;
        }
        return testTree(root.left) && testTree(root.right);
    }

    public static boolean isBalanced(TreeNode root){
        TreeNode new_tree = getHeights(root);
        return testTree(new_tree);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        System.out.println(isBalanced(root));
    }
}