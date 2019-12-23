package Path_Sum_II;

import java.util.ArrayList;
import java.util.List;

class Solution {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null && root.val == sum){
            List<Integer> s = new ArrayList<>();
            s.add(root.val);
            List<List<Integer>> ss = new ArrayList<>();
            ss.add(s);
            return ss;
        }
        if(root.left == null && root.right == null && root.val != sum){
            return new ArrayList<>();
        }
        List<List<Integer>> l = pathSum(root.left,sum-root.val);
        List<List<Integer>> r = pathSum(root.right,sum-root.val);
        for(int i=0;i<l.size();i++){
            l.get(i).add(0,root.val);
        }
        for(int i=0;i<r.size();i++){
            r.get(i).add(0,root.val);
            if(l.size() != 0){
                l.add(r.get(i));
            }
        }
        if(l.size() != 0){
            return l;
        }
        return r;
    }

    public static void main(String[] args){
        System.out.print("Omar");
    }
}