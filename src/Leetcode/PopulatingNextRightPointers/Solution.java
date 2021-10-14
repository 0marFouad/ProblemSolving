package Leetcode.PopulatingNextRightPointers;

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

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
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
        int count = 1;
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            for(int i=0;i<count-1;i++){
                Node extracted = qu.poll();
                extracted.next = qu.peek();
                if(extracted.left != null)
                    qu.add(extracted.left);
                if(extracted.right != null)
                    qu.add(extracted.right);
            }
            Node extracted = qu.poll();
            if(extracted.left != null)
                qu.add(extracted.left);
            if(extracted.right != null)
                qu.add(extracted.right);
            count *= 2;
        }
        return root;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connect(root);
        System.out.print("CHECKING");
    }

}
