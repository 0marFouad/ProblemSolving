package Leetcode.Jump_Game_II;

class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[nums.length - 1] = 0;
        for(int i=nums.length-2;i>=0;i--){
            for(int j=1;j<=nums[i]&&i+j<nums.length;j++){
                if(dp[i+j] == Integer.MAX_VALUE){
                    continue;
                }
                dp[i] = Math.min(dp[i],1+dp[i+j]);
            }
        }
        return dp[0];
    }
}