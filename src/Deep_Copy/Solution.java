package Deep_Copy;

import java.util.HashMap;

public class Solution {

    public static class ALNode{
        public int value;
        public ALNode next;
        public ALNode arbitrary;

        public ALNode (int val){
            this.value = val;
            this.next = null;
            this.arbitrary = null;
        }

        public ALNode (){
            this.value = -1;
            this.next = null;
            this.arbitrary = null;
        }
    }


    public static ALNode createCopyOfNode(ALNode givenNode){
        if(givenNode == null){
            return null;
        }
        return new ALNode(givenNode.value);
    }

    public static ALNode deepCopy(ALNode head){
        if(head == null){
            return null;
        }
        ALNode myCopy = createCopyOfNode(head);
        ALNode iteratorOriginal = head;
        ALNode iteratorCopy = myCopy;
        HashMap<ALNode,ALNode> map = new HashMap<>();
        map.put(iteratorOriginal,iteratorCopy);
        while(iteratorOriginal != null){
            iteratorCopy.next = createCopyOfNode(iteratorOriginal.next);
            iteratorCopy = iteratorCopy.next;
            iteratorOriginal = iteratorOriginal.next;
            map.put(iteratorOriginal,iteratorCopy);
        }
        iteratorCopy = myCopy;
        iteratorOriginal = head;
        while(iteratorOriginal != null){
            if(iteratorOriginal.arbitrary != null){
                iteratorCopy.arbitrary = map.get(iteratorOriginal.arbitrary);
            }
            iteratorCopy = iteratorCopy.next;
            iteratorOriginal = iteratorOriginal.next;
        }
        return myCopy;
    }

    public static void main(String[] args){
        ALNode head = new ALNode(5);
        head.next = new ALNode(7);
        head.next.next = new ALNode(9);
        head.next.next.arbitrary = head;

        ALNode copy = deepCopy(head);
        System.out.println(copy.hashCode());
    }

}
