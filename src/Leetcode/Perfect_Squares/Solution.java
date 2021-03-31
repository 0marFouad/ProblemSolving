package Leetcode.Perfect_Squares;


public class Solution {

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        int i = 1;
        int counter = 3;
        while(i<=n){
            dp[i] = 1;
            i += counter;
            counter += 2;
        }
        for(i=2;i<=n;i++){
            if(dp[i] != Integer.MAX_VALUE){
                continue;
            }
            for(int j=1;j*j<i;j++){
                dp[i] = Math.min(dp[i],dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        for(int i=1;i<=20;i++){
            System.out.print(i+" ");
            System.out.println(numSquares(i));
        }
    }
}
