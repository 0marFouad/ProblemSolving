package Rotate_Image;

public class Solution {
    public static void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length/2;i++){
            for(int j=i;j<matrix[0].length - i - 1;j++){
                int r1 = i;
                int c1 = j;

                int r2 = r1 + j - i;
                int c2 = matrix[0].length - 1 - i;

                int r3 = matrix.length - 1 - i;
                int c3 = matrix[0].length - 1 - c1;

                int r4 = matrix.length - 1 - j;
                int c4 = i;

                int temp1 = matrix[r2][c2];
                matrix[r2][c2] = matrix[r1][c1];
                int temp2 = matrix[r3][c3];
                matrix[r3][c3] = temp1;
                int temp3 = matrix[r4][c4];
                matrix[r4][c4] = temp2;
                matrix[r1][c1] = temp3;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
