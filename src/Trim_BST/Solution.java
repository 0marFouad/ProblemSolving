package Trim_BST;

class Solution {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return root;
        }
        if(root.val < L || root.val > R){
            TreeNode l = trimBST(root.left,L,R);
            TreeNode r = trimBST(root.right,L,R);
            if(l == null){
                return r;
            }
            if(r == null){
                return l;
            }
            TreeNode ptr = l;
            while(ptr.right != null){
                ptr = ptr.right;
            }
            ptr.right = r;
            return l;
        }

        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }
}
