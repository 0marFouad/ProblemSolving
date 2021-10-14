package Leetcode._01_Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static boolean isValid(int i, int j, int[][] mat){
        if(i < 0 || i>= mat.length || j < 0 || j >= mat[i].length){
            return false;
        }
        return true;
    }



    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        int[][] res = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                }else{
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()){
            int[] zero = q.poll();
            for(int i=0;i<dirs.length;i++){
                int row = zero[0] + dirs[i][0];
                int col = zero[1] + dirs[i][1];
                if(isValid(row,col,mat) && res[row][col] == Integer.MAX_VALUE){
                    res[row][col] = Math.min(res[row][col],res[zero[0]][zero[1]] + 1);
                    q.add(new int[]{row, col});
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] mat = {{0,1,1},{1,1,1},{1,1,1}};
        mat = updateMatrix(mat);
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

    }
}
