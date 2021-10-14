package Leetcode.MaxAreaofIsland;

public class Solution {

    public static boolean isValid(int i, int j, int r, int c){
        if(i < 0 || i>= r || j<0|| j>=c){
            return false;
        }
        return true;
    }

    public static int markIsland(int[][] grid, boolean[][] visited,int i,int j){
        if(!isValid(i,j,grid.length,grid[0].length) || grid[i][j] == 0){
            return 0;
        }

        if(visited[i][j]){
            return 0;
        }
        int count = 0;
        if(grid[i][j] == 1){
            count++;
        }
        visited[i][j] = true;
        count += markIsland(grid,visited,i+1,j);
        count += markIsland(grid,visited,i-1,j);
        count += markIsland(grid,visited,i,j+1);
        count += markIsland(grid,visited,i,j-1);

        return count;

    }


    public static int maxAreaOfIsland(int[][] grid) {
        int res = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                res = Math.max(res,markIsland(grid,visited,i,j));
            }
        }
        return res;
    }


    public static void main(String[] args){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] grid1 = {{1,1,1,0},{0,0,0,0},{1,1,1,1}};
        System.out.print(maxAreaOfIsland(grid));
    }
}
