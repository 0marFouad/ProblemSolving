package Leetcode.Task_Scheduler;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int leastIntervalSlow(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i] - 'A']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i] == 0){
                continue;
            }
            pq.add(freq[i]);
        }
        int round = n+1;
        int res = 0;
        while(!pq.isEmpty()){
            PriorityQueue<Integer> temp = new PriorityQueue<>();
            int c = 0;
            while(!pq.isEmpty() && c<round){
                int mx = pq.poll();
                if(mx > 1){
                    mx--;
                    temp.add(mx);
                }
                c++;
            }
            while(!temp.isEmpty()){
                pq.add(temp.poll());
            }
            if(pq.isEmpty()){
                res += c;
            }else{
                res += round;
            }
        }
        return res;
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int mx = 0;
        int hm = 0;
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i] - 'A']++;
            mx = Math.max(freq[tasks[i] - 'A'],mx);
        }
        for(int i=0;i<26;i++){
            if(mx == freq[i]){
                hm++;
            }
        }
        n -= (hm-1);
        int slots = (mx - 1)*(n);

        int idles = Math.max(0, slots - tasks.length + hm*mx);
        return idles + tasks.length;
    }

    public static void main(String[] args){
        char[] d = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        System.out.println(leastInterval(d,n));

    }
}
