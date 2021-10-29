package Leetcode.Delete_and_Earn;

import java.util.HashMap;

public class Solution {

    public static int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        int[] freq = new int[10001];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        dp[10000] = 10000 * freq[10000];
        dp[9999] = Math.max(9999 * freq[9999],dp[10000]);
        for(int i=4;i>=1;i--){
            dp[i] = Math.max(i*freq[i] + dp[i+2],dp[i+1]);
        }
        return dp[1];
    }

    public static void main(String[] args){
        System.out.println(deleteAndEarn(new int[]{1,1,1,2,4,5,5,5,6}));
    }
}
