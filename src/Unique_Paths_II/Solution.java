package Unique_Paths_II;

public class Solution {
    public static int getWays(int i, int j, int[][] obstacleGrid, int[][] ways){
        if(i < 0 || j < 0 || i >= obstacleGrid.length || j >= obstacleGrid[0].length){
            return 0;
        }
        if(obstacleGrid[i][j] == 1){
            return 0;
        }
        return ways[i][j];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0){
            return 0;
        }
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[r-1][c-1] == 1){
            return 0;
        }
        int[][] ways = new int[r][c];
        for(int i=0;i<r;i++){
            if(obstacleGrid[i][0] == 0){
                ways[i][0] = 1;
            }else{
                break;
            }
        }
        for(int i=0;i<c;i++){
            if(obstacleGrid[0][i] == 0){
                ways[0][i] = 1;
            }else{
                break;
            }
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                ways[i][j] = getWays(i-1,j,obstacleGrid,ways) + getWays(i, j-1,obstacleGrid, ways);
            }
        }
        return ways[r-1][c-1];
    }

    public static void main(String[] args){
        int[][] obstacleGrid = {
                {0,0,0},
                {1,1,1},
                {0,0,0}
        };
        System.out.print(uniquePathsWithObstacles(obstacleGrid));
    }
}
