package Leetcode.Target_Sum;

public class Solution {

    public static int solve(int[][] mem,boolean[][] vis,int[] nums,int i,int S,int sum){
        if(i == nums.length){
            if(S == 0){
                return 1;
            }
            return 0;
        }
        if(vis[i][S+sum]){
            return mem[i][S+sum];
        }
        vis[i][S+sum] = true;
        mem[i][S+sum] = solve(mem,vis,nums,i+1,S+nums[i],sum) + solve(mem,vis,nums,i+1,S-nums[i],sum);
        return mem[i][S+sum];
    }

    //Top Down
    public static int findTargetSumWays1(int[] nums, int S) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        sum += Math.abs(S);
        return solve(new int[nums.length][2*sum + 1],new boolean[nums.length][2*sum + 1],nums,0,S,sum);
    }

    //Bottom Up
    public static int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum < S){
            return 0;
        }
        sum += Math.abs(S);
        int[][] dp = new int[nums.length+1][2*sum + 1];
        dp[nums.length][0+sum] = 1;
        for(int i=nums.length;i>0;i--){
            for(int j=0;j<=2*sum;j++){
                if(dp[i][j] != 0){
                    if(j-nums[i-1]>=0){
                        dp[i-1][j-nums[i-1]] += dp[i][j];
                    }
                    if(j+nums[i-1] < dp[0].length){
                        dp[i-1][j+nums[i-1]] += dp[i][j];
                    }
                }
            }
        }
        return dp[0][S+sum];
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,1,1};
        int S = 3;
        System.out.println(findTargetSumWays2(nums,S));
    }
}
