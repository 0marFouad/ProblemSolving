package Add_Two_Numbers_II;

public class Solution {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static class wrapper {
        ListNode node;
        int remainder;

        wrapper(int x, ListNode n){
            remainder = x;
            node = n;
        }
    }

    public static int getLength(ListNode l){
        int len = 0;
        while(l!=null){
            len++;
            l = l.next;
        }
        return len;
    }

    public static wrapper solve(ListNode l1, ListNode l2){
        if(l1.next != null){
            wrapper s = solve(l1.next, l2.next);
            ListNode n = new ListNode((l1.val + l2.val + s.remainder)%10);
            n.next = s.node;
            wrapper newNode = new wrapper((l1.val + l2.val + s.remainder)/10, n);
            return newNode;
        }else{
            wrapper newNode = new wrapper((l1.val + l2.val)/10, new ListNode((l1.val + l2.val)%10));
            return newNode;
        }
    }

    public static wrapper diffLength(ListNode l, ListNode s, wrapper r){
        if(l == s){
            return r;
        }
        wrapper rr = diffLength(l.next,s,r);
        int rem = (l.val + rr.remainder)/10;
        l.val = (l.val + rr.remainder)%10;
        ListNode ll = new ListNode(l.val);
        ll.next = rr.node;
        wrapper ret = new wrapper(rem, ll);
        return ret;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        if(len1 == len2){
            wrapper res = solve(l1,l2);
            if(res.remainder == 0){
                return res.node;
            }else{
                ListNode rem = new ListNode(res.remainder);
                rem.next = res.node;
                return rem;
            }
        }

        if(len1 < len2){
            ListNode l2temp = l2;
            for(int i=len2;i>len1;i--){
                l2 = l2.next;
            }
            wrapper res = solve(l1,l2);
            wrapper rem = diffLength(l2temp, l2, res);
            if(rem.remainder != 0){
                ListNode n = new ListNode(rem.remainder);
                n.next = rem.node;
                return n;
            }else{
                return rem.node;
            }
        }

        if(len1 > len2){
            ListNode l1temp = l1;
            for(int i=len1;i>len2;i--){
                l1 = l1.next;
            }
            wrapper res = solve(l1,l2);
            wrapper rem = diffLength(l1temp, l1, res);
            if(rem.remainder != 0){
                ListNode n = new ListNode(rem.remainder);
                n.next = rem.node;
                return n;
            }else{
                return rem.node;
            }
        }
        return null;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = addTwoNumbers(l1,null);
        while(l3 != null){
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
    }
}
