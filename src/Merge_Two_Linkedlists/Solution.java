package Merge_Two_Linkedlists;

public class Solution {
    public static class LNode{
        int data;
        LNode next;
        LNode(int data){
            this.data = data;
        }
    }

    public static LNode mergeLists(LNode head1, LNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        if(head1.data < head2.data){
            head1.next = mergeLists(head1.next,head2);
            return head1;
        }else{
            head2.next = mergeLists(head1,head2.next);
            return head2;
        }
    }

    public static void main(String[] args){
        LNode head1 = new LNode(6);
        head1.next = new LNode(91);
        LNode head2 = new LNode(7);
        head1 = mergeLists(head1,head2);
        while(head1 != null){
            System.out.println(head1.data);
            head1 = head1.next;
        }
    }
}
