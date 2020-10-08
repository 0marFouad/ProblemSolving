package Leetcode.Search_a_2D_Matrix_II;

public class Solution {

    public static boolean searchEfficient(int[][] matrix, int target,int rS,int rE,int cS,int cE){
        if(rS == rE && cS == cE){
            return matrix[rS][cS] == target;
        }
        if(rS > rE || cS > cE){
            return false;
        }
        int rM = rS + (rE - rS)/2;
        int cM = cS + (cE - cS)/2;
        if(matrix[rM][cM] == target){
            return true;
        }
        if(matrix[rM][cM] > target){
            return searchEfficient(matrix,target,rS,rM-1,cS,cE) || searchEfficient(matrix,target,rM,rE,cS,cM-1);
        }else{
            return searchEfficient(matrix,target,rS,rM,cM+1,cE) || searchEfficient(matrix,target,rM+1,rE,cS,cE);
        }
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rS = 0;
        int rE = matrix.length - 1;

        int cS = 0;
        int cE = matrix[0].length - 1;

        return searchEfficient(matrix,target,rS,rE,cS,cE);
    }

    public static void main(String[] args){
        int[][] m = {{1,   2,  3, 4, 5},{6,   7,  8, 9, 10},{11, 12, 13, 14, 15},{16, 17, 18, 19, 20},{21, 22, 23, 24, 25}};
        System.out.println(searchMatrix(m,5));
    }
}
