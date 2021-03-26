package Leetcode.Number_Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static int solve(int round, int[] cards,ArrayList<Boolean> vis){
        if(round == 0){
            return 0;
        }
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<cards.length;i++){
            if(vis.get(i)){
                for(int j=0;j<cards.length;j++){
                    if(i!=j && vis.get(j)){
                        vis.set(i,false);
                        vis.set(j,false);
                        mx = Math.max(mx,round*gcd(cards[i],cards[j]) +  solve(round-1,cards,vis));
                        vis.set(i,true);
                        vis.set(j,true);
                    }
                }
            }
        }
        return mx;
    }

    public static int maxTotalScore(int n, int[] cards) {
        ArrayList<Boolean> vis = new ArrayList<>();
        for(int i=0;i<cards.length;i++){
            vis.add(true);
        }
        return solve(n,cards,vis);
    }

    public static void main(String[] args){
        int[] nums = {8,5,6,25,6,16};
        System.out.println(maxTotalScore(3,nums));
    }
}
