package Leetcode.House_Robber_II;

public class Solution {
    public static int robI(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    public static int rob(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 0){
            return 0;
        }
        int[] first = new int[nums.length-1];
        for(int i=0;i< nums.length-1;i++){
            first[i] = nums[i];
        }
        int res = robI(first);
        for(int i=0;i< nums.length-1;i++){
            first[i] = nums[i+1];
        }
        res = Math.max(res,robI(first));
        return res;
    }
}
