package Leetcode.Reverse_Linked_List_II;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null){
            return head;
        }
        left--;
        right--;
        int i = 0;
        ListNode last1 = null;
        ListNode first2 = null;
        ListNode last2 = null;
        ListNode first3 = null;
        ListNode cur = head;
        ListNode save = cur;
        while(i < left){
            last1 = cur;
            cur = cur.next;
            i++;
            save = cur;
        }
        first2 = cur;
        while(i<=right){
            last2 = cur;
            cur = cur.next;
            i++;
        }
        first3 = cur;
        cur = save;
        ListNode cur2 = save.next;
        while(cur2 != null && cur != null && cur2 != first3){
            ListNode temp = cur2.next;
            cur2.next = cur;
            cur = cur2;
            cur2 = temp;
        }
        if(last1 != null){
            last1.next = last2;
        }else{
            head = last2;
        }
        if(first2 != null){
            first2.next = first3;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        head = reverseBetween(head,1,2);
        System.out.print(head.val);
    }
}
