package Leetcode.Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class Solution {

    public static Node solve(Node node, HashMap<Node,Node> vis){
        if(vis.containsKey(node)){
            return vis.get(node);
        }
        Node x = new Node(node.val);
        vis.put(node,x);
        for(int i=0;i<node.neighbors.size();i++){
            x.neighbors.add(solve(node.neighbors.get(i),vis));
        }
        return x;
    }

    public static Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        return solve(node,new HashMap<>());
    }

    public static void main(String[] args){
        Node node = new Node(1);
        Node x2 = new Node(2);
        Node x3 = new Node(3);
        Node x4 = new Node(4);
        x2.neighbors.add(node);
        x2.neighbors.add(x3);
        x3.neighbors.add(x2);
        x3.neighbors.add(x4);
        x4.neighbors.add(x3);
        x4.neighbors.add(node);
        node.neighbors.add(x2);
        node.neighbors.add(x4);
        Node copy = cloneGraph(node);
        System.out.print(copy.val);
    }
}
