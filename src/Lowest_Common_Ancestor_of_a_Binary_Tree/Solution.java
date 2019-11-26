package Lowest_Common_Ancestor_of_a_Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public static List<TreeNode> findPath(List<TreeNode> list,TreeNode root, TreeNode p){
        if(root == null){
            return null;
        }
        list.add(root);
        if(root == p){
            return list;
        }else{
            if(root.left == null && root.right == null){
                list.remove(root);
                return null;
            }
        }
        List<TreeNode> l = findPath(list,root.left,p);
        List<TreeNode> r = findPath(list,root.right,p);
        if(l==null && r==null){
            list.remove(root);
            return null;
        }
        if(l == null){
            return r;
        }
        return l;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> t1 = new ArrayList<>();
        List<TreeNode> t2 = new ArrayList<>();
        List<TreeNode> first = findPath(t1,root,p);
        List<TreeNode> second = findPath(t2,root,q);
        for(int i=1;i<Math.min(first.size(),second.size());i++){
            if(first.get(i) != second.get(i)){
                return first.get(i-1);
            }
        }
        return first.get(Math.min(first.size()-1,second.size()-1));
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        List<TreeNode> test = new ArrayList<>();
        List<TreeNode> path = findPath(test, root,root.left.right.right);
        for(int i=0;i<path.size();i++){
            System.out.println(path.get(i).val);
        }
    }


}
