package Last_Stone_Weight;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size() > 1){
            int f = pq.poll();
            int s = pq.poll();
            if(f != s){
                pq.add(Math.max(f,s) - Math.min(f,s));
            }
        }
        if(pq.size() == 0){
            return 0;
        }
        return pq.peek();
    }

    public static void main(String[] args){
        int[] stones = {2,2};
        System.out.println(lastStoneWeight(stones));
    }
}
