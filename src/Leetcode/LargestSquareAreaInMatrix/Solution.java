package Leetcode.LargestSquareAreaInMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
            }
        }

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
            }
        }
        int max = 1;
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.print(maximalSquare(matrix));
    }
}
