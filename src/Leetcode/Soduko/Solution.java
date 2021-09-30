package Leetcode.Soduko;

import java.util.*;

public class Solution {

    public static String combine(int row, int col){
        return row +","+col;
    }

    public static int getRow(String cell){
        return Integer.valueOf(cell.split(",")[0]);
    }

    public static int getCol(String cell){
        return Integer.valueOf(cell.split(",")[1]);
    }

    public static int getBox(int row, int col){
        int boxRow = row/3;
        int boxCol = col/3;
        return boxRow*3 + boxCol;
    }

    public static void addNumberToCell(char[][] board,HashMap<String, HashSet<Integer>> impossibilities ,ArrayList<String> emptyCells,ArrayList<ArrayList<Integer>> cols, ArrayList<ArrayList<Integer>> rows, ArrayList<ArrayList<Integer>> boxes,String cell, int val){
        cols.get(getCol(cell)).add(val);
        rows.get(getRow(cell)).add(val);
        boxes.get(getBox(getRow(cell),getCol(cell))).add(val);
        emptyCells.remove(cell);
        for(int i=0;i<9;i++){
            String newCell1 = i + "," + getCol(cell);
            String newCell2 = getRow(cell) + "," + i;
            if(board[i][getCol(cell)] == '.'){
                if(impossibilities.get(newCell1) == null){
                    impossibilities.put(newCell1, new HashSet<>());
                }
                impossibilities.get(newCell1).add(val);
            }

            if(board[i][getCol(cell)] == '.') {
                if(impossibilities.get(newCell2) == null){
                    impossibilities.put(newCell2, new HashSet<>());
                }
                impossibilities.get(newCell1).add(val);
            }
        }
        int currentBox = getBox(getRow(cell),getCol(cell));
        int startRow = currentBox/3;
        startRow = startRow*3;
        int startCol = currentBox%3;
        startCol = startCol*3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                String newCell = i + "," + j;
                if(board[i][j] == '.'){
                    if(impossibilities.get(newCell) == null){
                        impossibilities.put(newCell, new HashSet<>());
                    }
                    impossibilities.get(newCell).add(val);
                }
            }
        }
    }

    public static void solveSudoku(char[][] board) {
        ArrayList<ArrayList<Integer>> cols = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> boxes = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<9;i++){
            cols.add(new ArrayList<>());
            rows.add(new ArrayList<>());
            boxes.add(new ArrayList<>());
        }
        ArrayList<String> emptyCells = new ArrayList<>();
        HashMap<String, HashSet<Integer>> impossibilities = new HashMap<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    emptyCells.add(combine(i,j));
                }else{
                    int val = (board[i][j]-'0');
                    rows.get(i).add(val);
                    cols.get(j).add(val);
                    boxes.get(getBox(i,j)).add(val);
                }
            }
        }
        for(int i=0;i<emptyCells.size();i++){
            String cell = emptyCells.get(i);
            for(int j=0;j<rows.get(getRow(cell)).size();j++){
                if(impossibilities.get(cell) == null){
                    impossibilities.put(cell, new HashSet<>());
                }
                impossibilities.get(cell).add(rows.get(getRow(cell)).get(j));
            }
            for(int j=0;j<cols.get(getCol(cell)).size();j++){
                if(impossibilities.get(cell) == null){
                    impossibilities.put(cell, new HashSet<>());
                }
                impossibilities.get(cell).add(cols.get(getCol(cell)).get(j));
            }
            for(int j=0;j<boxes.get(getBox(getRow(cell),getCol(cell))).size();j++){
                if(impossibilities.get(cell) == null){
                    impossibilities.put(cell, new HashSet<>());
                }
                impossibilities.get(cell).add(boxes.get(getBox(getRow(cell),getCol(cell))).get(j));
            }
        }
        while(emptyCells.size() > 0){
            int i = 0;
            Collections.sort(emptyCells, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.compare(impossibilities.get(o2).size(),impossibilities.get(o1).size());
                }
            });
            if(impossibilities.get(emptyCells.get(i)).size() == 8){
                for(int k=1;k<=9;k++){
                    if(!impossibilities.get(emptyCells.get(i)).contains(k)){
                        String cell = emptyCells.get(i);
                        addNumberToCell(board,impossibilities,emptyCells,cols,rows,boxes,emptyCells.get(i),k);
                        board[getRow(cell)][getCol(cell)] = (char)(k+'0');
                        impossibilities.remove(cell);
                        printBoard(board);
                        System.out.println();
                        break;
                    }
                }
            }
        }

    }

    public static void printBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        printBoard(board);
    }
}
