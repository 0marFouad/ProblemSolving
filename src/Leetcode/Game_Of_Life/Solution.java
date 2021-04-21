package Leetcode.Game_Of_Life;

public class Solution {

    public static boolean isValid(int r,int c,int i,int j){
        if(i < 0 || i >= r || j<0 || j>= c){
            return false;
        }
        return true;
    }

    public static void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int count = 0;
                if(isValid(r,c,i-1,j) && board[i-1][j] > 0){
                    count++;
                }
                if(isValid(r,c,i+1,j) && board[i+1][j] > 0){
                    count++;
                }
                if(isValid(r,c,i-1,j-1) && board[i-1][j-1] > 0){
                    count++;
                }
                if(isValid(r,c,i-1,j+1) && board[i-1][j+1] > 0){
                    count++;
                }
                if(isValid(r,c,i+1,j-1) && board[i+1][j-1] > 0){
                    count++;
                }
                if(isValid(r,c,i+1,j+1) && board[i+1][j+1] > 0){
                    count++;
                }
                if(isValid(r,c,i,j-1) && board[i][j-1] > 0){
                    count++;
                }
                if(isValid(r,c,i,j+1) && board[i][j+1] > 0){
                    count++;
                }
                if(count == 3 && board[i][j] == 0){
                    board[i][j] = -3;
                }else if((count == 3 || count == 2) && board[i][j] == 1){
                    board[i][j] = 3;
                }else{
                    if(board[i][j] == 0){
                        board[i][j] = -2;
                    }else{
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(Math.abs(board[i][j]) == 3){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
