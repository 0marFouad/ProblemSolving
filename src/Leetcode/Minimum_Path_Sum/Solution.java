package Leetcode.Minimum_Path_Sum;

public class Solution {
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int acc = 0;
        for(int i=grid.length-1;i>=0;i--){
            dp[i][grid[0].length-1] = grid[i][grid[0].length-1] + acc;
            acc += grid[i][grid[0].length-1];

        }
        acc = 0;
        for(int i=grid[0].length-1;i>=0;i--){
            dp[grid.length-1][i] = grid[grid.length-1][i] + acc;
            acc += grid[grid.length-1][i];
        }
        for(int i=grid.length-2;i>=0;i--){
            for (int j=grid[0].length-2;j>=0;j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
