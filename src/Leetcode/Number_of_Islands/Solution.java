package Leetcode.Number_of_Islands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static int countIslands(char[][] grid, List<List<Integer>> vis, int i,int j){
        if(i>=vis.size() || j >= vis.get(0).size() || i < 0 || j < 0){
            return 0;
        }
        if(grid[i][j] == '0' || vis.get(i).get(j) == 1){
            return 0;
        }
        vis.get(i).set(j,1);
        int c = 1;
        return c + countIslands(grid,vis,i+1,j) + countIslands(grid,vis,i,j-1) + countIslands(grid,vis,i-1,j) + countIslands(grid,vis,i,j+1);
    }

    public static int DimensionReduction(int row,int col,int cols){
        return row*cols + col;
    }

    public static int find(int[] data,int[] sz,int row,int col,int cols){
        int getPoint = DimensionReduction(row,col,cols);
        while(getPoint != data[getPoint]){
            getPoint = data[getPoint];
        }
        return getPoint;
    }

    public static void union(int[] data,int[] sz,int row1,int col1,int row2,int col2,int cols){
        int getPoint1 = find(data,sz,row1,col1,cols);
        int getPoint2 = find(data,sz,row2,col2,cols);
        if(getPoint1 != getPoint2){
            if(sz[getPoint1] > sz[getPoint2]){
                data[getPoint2] = getPoint1;
                sz[getPoint1] += sz[getPoint2];
            }else{
                data[getPoint1] = getPoint2;
                sz[getPoint2] += sz[getPoint1];
            }
        }
    }

    public static boolean isValid(char[][] grid,int i,int j){
        if(i < 0 || j < 0){
            return false;
        }
        if(i >= grid.length){
            return false;
        }
        if(j >= grid[0].length){
            return false;
        }
        return true;
    }

    public static int numIslands1(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] data = new int[rows*cols];
        int[] sz = new int[rows*cols];

        for(int i=0;i<rows*cols;i++){
            data[i] = i;
            sz[i] = 1;
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                if(isValid(grid,i-1,j) && grid[i-1][j] == '1'){
                    union(data,sz,i,j,i-1,j,cols);
                }
                if(isValid(grid,i+1,j) && grid[i+1][j] == '1'){
                    union(data,sz,i,j,i+1,j,cols);
                }
                if(isValid(grid,i,j-1) && grid[i][j-1] == '1'){
                    union(data,sz,i,j,i,j-1,cols);
                }
                if(isValid(grid,i,j+1) && grid[i][j+1] == '1'){
                    union(data,sz,i,j,i,j+1,cols);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<cols*rows;i++){
            int r = i/cols;
            int c = i%cols;
            if(grid[r][c] == '0'){
                continue;
            }
            if(i == data[i]){
                ans++;
            }
        }
        return ans;
    }


    public static int numIslands(char[][] grid) {
        List<List<Integer>> visited = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            List<Integer> toInsert = new ArrayList<>();
            for(int j=0;j<grid[i].length;j++){
                toInsert.add(0);
            }
            visited.add(toInsert);
        }
        int result = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(countIslands(grid,visited,i,j) > 0){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        char[][] grid = {{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
        //char[][] grid = {{'1'},{'1'}};
        System.out.print(numIslands1(grid));
    }
}
