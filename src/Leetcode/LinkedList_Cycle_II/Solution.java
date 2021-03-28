package Leetcode.LinkedList_Cycle_II;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class Solution {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                fast = null;
            }
            if(slow == fast){
                break;
            }
        }
        if(slow == null || fast == null){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        ListNode temp = head.next;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next = temp;
        ListNode res = detectCycle(head);
    }
}
