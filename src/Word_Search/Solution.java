package Word_Search;


class Solution {

    public static boolean isValid(char[][] boards, int i, int j){
        if(i >= 0 && i < boards.length && j >= 0 && j < boards[i].length){
            return true;
        }
        return false;
    }

    public static boolean existRec(char[][] board, String word, int i, int j, int idx){
        if(!isValid(board,i,j) || board[i][j] == '.' || word.charAt(idx) != board[i][j]){
            return false;
        }
        if(idx == word.length()-1) return true;
        char c = board[i][j];
        board[i][j] = '.';
        boolean t4 = existRec(board,word,i,j-1,idx+1);
        boolean t2 = existRec(board,word,i-1,j,idx+1);
        boolean t3 = existRec(board,word,i,j+1,idx+1);
        boolean t1 = existRec(board,word,i+1,j,idx+1);
        boolean result = t1 || t2 || t3 || t4;
        board[i][j] = c;
        return result;
    }

    public static boolean exist(char[][] board, String word) {
        if(board.length < 1 || word.length() < 1){
            return false;
        }
        boolean result = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    result = existRec(board,word,i,j,0);
                    if(result == true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        char[][] board = {  {'A','B','C','E'},
                            {'S','F','E','S'},
                            {'A','D','E','E'}
        };
        String search = "ABCESEEEFS";
        System.out.println(exist(board,search));
    }
}