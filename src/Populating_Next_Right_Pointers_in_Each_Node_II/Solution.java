package Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            while(!q.isEmpty()){
                q2.add(q.remove());
            }
            while(!q2.isEmpty()){
                Node temp = q2.remove();
                temp.next = q2.peek();
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args){
        Node root = new Node(1,null,null,null);
        root.left = new Node(2,null,null,null);
        root.right = new Node(3,null,null,null);
        root.left.left = new Node(4,null,null,null);
        root.left.right = new Node(5,null,null,null);
        root.right.right = new Node(7,null,null,null);
        connect(root);
    }
}
