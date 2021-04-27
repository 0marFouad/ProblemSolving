package Leetcode.Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int spiral(int[][] matrix,int sr,int sc,int rows,int cols,List<Integer> res){
        for(int i=sc;i<=cols;i++){
            res.add(matrix[sr][i]);
        }
        if(sr == rows){
            return res.size();
        }
        for(int i=sr+1;i<=rows;i++){
            res.add(matrix[i][cols]);
        }
        if(sc == cols){
            return res.size();
        }
        for (int i=cols-1;i>=sc;i--){
            res.add(matrix[rows][i]);
        }
        for(int i=rows-1;i>sr;i--){
            res.add(matrix[i][sc]);
        }
        return res.size();
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int halfR = (rows+1)/2 - 1;
        List<Integer> res = new ArrayList<>();
        int sz = 0;
        int maxSz = rows*cols;
        for(int i=0;i<=halfR&&sz<maxSz;i++){
            sz = spiral(matrix,i,i,rows - 1 - i,cols - 1 - i,res);
        }
        return res;
    }

}
