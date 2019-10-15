package Number_of_Islands;

import java.util.ArrayList;
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
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.print(numIslands(grid));
    }
}
