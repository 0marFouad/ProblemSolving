package Leetcode.Spiral_Matrix_II;

public class Solution {
    public static int[][] generateMatrix(int n) {
        int num = 1;
        int[][] res = new int[n][n];
        int halfN = (n+1)/1 - 1;
        for(int i=0;i<=halfN;i++){
            for(int j=i;j<=n-1-i;j++){
                res[i][j] = num;
                num++;
            }
            for(int j=i+1;j<=n-1-i;j++){
                res[j][n-1-i] = num;
                num++;
            }
            for(int j=n-2-i;j>i;j--){
                res[n-1-i][j] = num;
                num++;
            }
            for(int j=n-1-i;j>i;j--){
                res[j][i] = num;
                num++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int n = 2;
        int[][] m = generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

}
