package Matrix_Block_Sum;

public class Solution {

    public static int[][] matrixBlockSum(int[][] mat, int K) {
        if(mat.length < 1 || K == 0){
            return mat;
        }
        int[][] res = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                int cur = mat[i][j];
                for(int ii=Math.max(0,i-K);ii<Math.min(i+K+1,mat.length);ii++){
                    for(int jj=Math.max(0,j-K);jj<Math.min(j+K+1,mat[i].length);jj++){
                        res[ii][jj] += cur;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] inp = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] out = matrixBlockSum(inp,2);
        for(int i=0;i<out.length;i++){
            for (int j=0;j<out[i].length;j++){
                System.out.print(out[i][j] + " ");
            }
            System.out.println();
        }
    }

}
