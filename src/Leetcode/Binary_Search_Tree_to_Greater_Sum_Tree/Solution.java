package Leetcode.Binary_Search_Tree_to_Greater_Sum_Tree;

public class Solution {

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public static int findSum(TreeNode root){
        int sum = 0;
        if(root.left != null){
            sum += findSum(root.left);
        }
        if(root.right != null){
            sum += findSum(root.right);
        }
        return sum + root.val;
    }

    public static class passByRef{
        Integer val;
        passByRef(int x){
            this.val = x;
        }
    }

    public static void changeTree(TreeNode root, passByRef passedVal){
        if(root.left != null){
            changeTree(root.left,passedVal);
        }
        int oldVal = root.val;
        root.val = passedVal.val;
        passedVal.val -= oldVal;
        if(root.right != null){
            changeTree(root.right,passedVal);
        }
    }

    public static TreeNode bstToGst(TreeNode root) {
        changeTree(root,new passByRef(findSum(root)));
        return root;
    }

    public static void printTree(TreeNode root){
        if(root.left != null){
            printTree(root.left);
        }
        System.out.print(root.val + " ");
        if(root.right != null){
            printTree(root.right);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root = bstToGst(root);
        printTree(root);
    }

}
