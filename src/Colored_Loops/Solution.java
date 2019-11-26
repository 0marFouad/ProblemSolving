package Colored_Loops;

public class Solution {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0},{-1, 0}};

    public static void main(String[] args) {
        char[][] grid1 ={{'A', 'A', 'Z', 'A'},
                {'Z', 'B', 'C', 'A'},
                {'A', 'A', 'A', 'A'}};

        char[][] grid2 ={{'A', 'A', 'Z', 'A'},
                {'B', 'B', 'C', 'A'},
                {'A', 'A', 'A', 'A'}};
        System.out.println(findCircle(grid1));
        System.out.println(findCircle(grid2));
    }

    private static boolean findCircle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(!dfs(grid, visited, i, j, new int[] {i, j}, grid[i][j]))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int[] parent, char parentVal) {
        visited[i][j] = true;
        for(int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == parentVal) {
                if(!visited[ni][nj]) {
                    if(!dfs(grid, visited, ni, nj, new int[] {i, j}, parentVal))
                        return false;
                }else if(visited[ni][nj] && !(ni == parent[0] && nj == parent[1])) {
                    return false;
                }
            }
        }
        visited[i][j] = false;
        return true;
    }
}
