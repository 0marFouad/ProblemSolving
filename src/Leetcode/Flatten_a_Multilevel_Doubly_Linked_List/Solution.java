package Leetcode.Flatten_a_Multilevel_Doubly_Linked_List;
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
public class Solution {
    public static Node flatten(Node head) {
        if(head == null){
            return null;
        }
        Node saved_head = head;
        while(head != null){
            Node insert_here = flatten(head.child);
            head.child = null;
            Node temp = head.next;
            head.next = insert_here;
            if(insert_here != null){
                insert_here.prev = head;
            }
            while(head.next != null){
                head = head.next;
            }
            head.next = temp;
            head = head.next;
        }
        return saved_head;
    }

    public static void main(String[] args){
        Node head = new Node(1,null,null,null);
        head.next = new Node(2,null,null,null);
        head.next.next = new Node(3,null,null,null);
        head.next.next.child = new Node(7,null,null,null);
        head.next.next.child.next = new Node(8,null,null,null);
        head.next.next.child.next.child = new Node(11,null,null,null);
        head.next.next.child.next.child.next = new Node(12,null,null,null);
        head.next.next.child.next.next = new Node(9,null,null,null);
        head.next.next.child.next.next.next = new Node(10,null,null,null);
        head.next.next.next = new Node(4,null,null,null);
        head.next.next.next.next = new Node(5,null,null,null);
        head.next.next.next.next.next = new Node(6,null,null,null);

        Node x = flatten(head);
        while(x != null){
            System.out.print(x.val + " ");
            x = x.next;
        }
    }

}
