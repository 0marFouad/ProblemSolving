package Range_Sum_Query_2D_Immutable;
class NumMatrix {
    int[][] mat;
    int[][] cum_mat;
    public NumMatrix(int[][] matrix) {
        this.mat = matrix;
        if(matrix.length > 0){
            cum_mat = new int[matrix.length][matrix[0].length];
            cum_mat[0][0] = mat[0][0];
            for(int i=1;i<matrix[0].length;i++){
                cum_mat[0][i] += mat[0][i] + cum_mat[0][i-1];
            }
            for(int i=1;i<matrix.length;i++){
                cum_mat[i][0] += mat[i][0] + cum_mat[i-1][0];
            }

            for(int i=1;i<matrix.length;i++){
                for (int j=1;j<matrix[i].length;j++){
                    cum_mat[i][j] += cum_mat[i-1][j] + cum_mat[i][j-1] - cum_mat[i-1][j-1] + mat[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = cum_mat[row2][col2];
        int r1 = row1 - 1;
        int c1 = col1 - 1;
        if(r1 >= 0){
            sum -= cum_mat[r1][col2];
        }
        if(c1 >= 0){
            sum -= cum_mat[row2][c1];
        }
        if(row1 >= 1 && col1 >= 1){
            sum += cum_mat[row1-1][col1-1];
        }
        return sum;
    }

    public static void main(String[] args){
        int[][] mat = {{-4,-5}};
        NumMatrix x = new NumMatrix(mat);
        System.out.println(x.sumRegion(0,0,0,0));
    }
}
