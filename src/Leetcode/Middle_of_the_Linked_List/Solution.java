package Leetcode.Middle_of_the_Linked_List;

import java.util.*;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null){
            if(fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }else{
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        System.out.print(middleNode(head).val);
    }
}
