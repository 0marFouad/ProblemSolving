package Coin_Change_2;

import java.util.HashSet;

public class Solution {

    public static String getKey(int x, int y){
        int f = Math.min(x,y);
        int s = Math.max(x,y);
        return f + "," + s;
    }

    public static int change(int amount, int[] coins) {
        int[] mem = new int[amount+1];
        HashSet<String> saved = new HashSet<>();
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j] < i){
                    continue;
                }
                if(i == coins[j]){
                    mem[i]++;
                }
                if(i + coins[j] <= amount && mem[i] != 0){
                    mem[i + coins[j]] += mem[i];
                    saved.add(getKey(i,coins[j]));
                }
            }
        }
        return mem[amount];
    }

    public static void main(String[] args){
        int[] x = {1,2,5};
        System.out.println(change(5,x));
    }
}
