package Leetcode.ReverseLinkedList;

import java.util.List;

public class Solution {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode saved;
    public static ListNode reverseList1(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            saved = head;
            return head;
        }

        ListNode nextList = reverseList1(head.next);
        if(nextList != null){
            nextList.next = head;
        }
        return head;

    }


    public static ListNode reverseListRec(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode solution = reverseList1(head);
        solution.next = null;
        return saved;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode first = head;
        if(first == null){
            return first;
        }
        ListNode second = head.next;
        ListNode bef = null;
        ListNode temp = null;
        while(second != null){
            temp = second.next;
            first.next = bef;
            bef = first;
            second.next = first;
            first = second;
            second = temp;
        }
        return first;
    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode rev = reverseListRec(root);
        System.out.print("OMar");
    }
}
