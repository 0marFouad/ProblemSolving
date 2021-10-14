package Leetcode.RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static boolean isValid(int i, int j, int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length){
            return false;
        }
        return true;
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int good = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    good++;
                }
            }
        }

        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};

        int ans = 0;
        while(!q.isEmpty()){
            int saved = q.size();
            for(int i=0;i<saved;i++){
                int[] rottenCell = q.poll();
                int r = rottenCell[0];
                int c = rottenCell[1];
                for(int j=0;j<dirs.length;j++){
                    int newR = r + dirs[j][0];
                    int newC = c + dirs[j][1];
                    if(isValid(newR,newC,grid) && grid[newR][newC] == 1){
                        grid[newR][newC] = 2;
                        q.add(new int[]{newR, newC});
                        good--;
                    }
                }
            }
            if(!q.isEmpty())
                ans++;
        }
        if(good != 0){
            return -1;
        }
        return ans;
    }

    public static void main(String[] args){
        int[][] grid = {{0,2}};
        System.out.println(orangesRotting(grid));
    }
}
