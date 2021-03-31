package Leetcode.Kth_Smallest_Element_in_a_BST;



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

class BooleanContainer{
    boolean canTake;
    BooleanContainer(boolean canTake){
        this.canTake = canTake;
    }
}

class IntegerContainer{
    int current;
    IntegerContainer(int current){
        this.current = current;
    }
}



public class Solution {

    public static int solve(TreeNode root,int k,BooleanContainer canTake,IntegerContainer current){
        if(!canTake.canTake && root.left == null){
            canTake.canTake = true;
        }
        int l = -1;
        if(root.left != null){
            l = solve(root.left,k,canTake,current);
        }
        if(canTake.canTake){
            current.current++;
        }
        int me = -1;
        if(canTake.canTake && k == current.current){
            me = root.val;
        }
        int r = -1;
        if(root.right != null){
            r = solve(root.right,k,canTake,current);
        }
        return Math.max(me,Math.max(l,r));
    }

    public static int kthSmallest(TreeNode root, int k) {
        return solve(root,k,new BooleanContainer(false),new IntegerContainer(0));
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        System.out.print(kthSmallest(root,7));
    }
}
