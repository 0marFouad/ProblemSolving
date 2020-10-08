package Leetcode.LRU_Cache;

import java.util.HashMap;

public class LRUCache {

    private int size = 0;
    private int maxSize = 0;
    HashMap<Integer, Node> map;
    Node head = null;
    Node tail = null;

    private class Node{
        Node prev;
        int key;
        int val;
        Node next;
        Node(Node prev,int key,int val,Node next){
            this.key = key;
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    private void deleteNode(Node toDelete){
        Node before = toDelete.prev;
        Node after = toDelete.next;
        if(toDelete == head){
            head = head.next;
        }
        if(toDelete == tail){
            tail = tail.prev;
        }
        if(before != null){
            before.next = after;
        }
        if(after != null){
            after.prev = before;
        }
        size--;
        map.remove(toDelete.key);
    }

    private void addToTail(int value,int key){
        Node toInsert = new Node(null,key,value,null);
        if(head == null && tail == null){
            head = toInsert;
            tail = head;
        }else{
            toInsert.prev = tail;
            tail.next = toInsert;
            tail = toInsert;
        }
        size++;
        map.put(key,toInsert);
    }
    private int prioritize(int key){
        Node requestedNode = map.get(key);
        int k = key;
        deleteNode(requestedNode);
        addToTail(requestedNode.val,k);
        return requestedNode.val;
    }

    private int prioritize(int key,int value){
        Node requestedNode = map.get(key);
        int k = key;
        deleteNode(requestedNode);
        addToTail(value,k);
        return value;
    }

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            return prioritize(key);
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            prioritize(key,value);
        }else{
            addToTail(value,key);
        }
        if(size == maxSize+1){
            deleteNode(head);
        }
    }

    public static void main(String[] args){
        LRUCache c = new LRUCache(2);
        c.put(2,1);
        c.put(2,2);
        System.out.println(c.get(2));
        c.put(1,1);
        c.put(4,1);
        System.out.println(c.get(2));
    }
}
