package Coin_Change;

import java.util.HashSet;

public class Solution {
    public static int coinChange(int[] coins, int amount) {
        int[] mem = new int[amount + 1];
        mem[0] = 0;
        for(int i=1;i<=amount;i++){
            mem[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i + coins[j] >= 0 && i + coins[j] <= amount && mem[i] != Integer.MAX_VALUE){
                    mem[coins[j] + i] = Math.min(mem[coins[j] + i],mem[i]+1);
                }
            }
        }
        if(mem[amount] == Integer.MAX_VALUE){
            return -1;
        }else{
            return mem[amount];
        }
    }

    public static void main(String[] args){
        int[] x = {1,2,5};
        System.out.println(coinChange(x,11));
    }
}
