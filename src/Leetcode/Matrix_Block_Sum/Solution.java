package Leetcode.Matrix_Block_Sum;

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

    public static int[][] matrixBlockSumFaster(int[][] mat, int K) {
        if(mat.length < 1 || K == 0){
            return mat;
        }
        int[][] cum = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                cum[i][j] = mat[i][j];
                if(j>0){
                    cum[i][j] += cum[i][j-1];
                }
            }
        }
        for(int i=1;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                cum[i][j] += cum[i-1][j];
            }
        }
        int[][] res = new int[mat.length][mat[0].length];
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                int fromI = Math.max(0,i-K) - 1;
                int fromJ = Math.max(0,j-K) - 1;
                int toI = Math.min(mat.length-1,i + K);
                int toJ = Math.min(mat[i].length-1,j + K);
                res[i][j] = cum[toI][toJ];
                if(fromI >= 0){
                    res[i][j] -= cum[fromI][toJ];
                }
                if(fromJ >= 0){
                    res[i][j] -= cum[toI][fromJ];
                }
                if(fromI >= 0 && fromJ >= 0){
                    res[i][j] += cum[fromI][fromJ];
                }
            }
        }
        return res;
    }


    public static void main(String[] args){
        int[][] inp = {{67,64,78},{99,98,38},{82,46,46},{6,52,55},{55,99,45}};
        int[][] out = matrixBlockSumFaster(inp,3);
        for(int i=0;i<out.length;i++){
            for (int j=0;j<out[i].length;j++){
                System.out.print(out[i][j] + " ");
            }
            System.out.println();
        }
    }

}
