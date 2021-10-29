package Leetcode.BeautifulArrangement;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public static boolean isVisited(int visited, int bit){
        return ((1 << (bit - 1)) & visited) != 0;
    }

    public static int visit(int visited, int bit){
        return (visited ^ (1 << (bit-1)));
    }

    public static int unvisit(int visited, int bit){
        return (visited ^ (1 << (bit-1)));
    }

    public static int solve(int n, int visited, int taken, int idx, HashMap<Integer, Integer> mem){
        if(taken == n){
            return 1;
        }
        if(idx > n){
            return  0;
        }
        if(mem.containsKey(visited*((int)Math.pow(2,15)) + idx)){
            return mem.get(visited*((int)Math.pow(2,15)) + idx);
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(isVisited(visited,i)){
                continue;
            }
            if(Math.max(idx,i) % Math.min(idx,i) == 0) {
                visited = visit(visited,i);
                ans += solve(n, visited, taken + 1, idx + 1,mem);
                visited = unvisit(visited,i);
            }
        }
        mem.put(visited*((int)Math.pow(2,15)) + idx,ans);
        return ans;
    }


    public static int countArrangement(int n) {
        int visited = 0;
        HashMap<Integer, Integer> mem = new HashMap<>();
        return solve(n,visited,0,1,mem);
    }


    public static void main(String[] args){
        System.out.print(countArrangement(9));

    }
}
