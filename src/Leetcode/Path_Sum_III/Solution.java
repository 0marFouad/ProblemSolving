package Leetcode.Path_Sum_III;

import java.util.HashMap;
import java.util.HashSet;

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

class IntegerWrapper{
    int val;
    IntegerWrapper(int val){
        this.val = val;
    }
}

public class Solution {

    public static int pathSum1(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }

    public static int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        IntegerWrapper count = new IntegerWrapper(0);
        helper(root, 0, sum, preSum,count);
        return count.val;
    }
    public static void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum,IntegerWrapper count) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - target)) {
            count.val += preSum.get(currSum - target);
        }

        if (!preSum.containsKey(currSum)) {
            preSum.put(currSum, 1);
        } else {
            preSum.put(currSum, preSum.get(currSum)+1);
        }

        helper(root.left, currSum, target, preSum,count);
        helper(root.right, currSum, target, preSum,count);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(pathSum(root,3));
    }

}
