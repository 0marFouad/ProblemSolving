package Leetcode.House_Robber;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {

    public static int solve(int[] nums, int i, int[] vis){
        if(vis[i] != -1){
            return vis[i];
        }
        if(i >= nums.length){
            return 0;
        }
        int res = Math.max(nums[i] + solve(nums,i+2,vis),solve(nums,i+1,vis));
        vis[i] = res;
        return res;
    }

    public static int rob1(int[] nums) {
        int[] vis = new int[nums.length];
        for(int i=0;i<vis.length;i++){
            vis[i] = -1;
        }
        return solve(nums,0,vis);
    }

    public static int rob2(int[] nums){
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

    public static void main(String[] args){
        int[] nums = {2,7,9,3,1};
        System.out.print(rob2(nums));
    }
}
