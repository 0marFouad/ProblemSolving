package Image_Smoother;

public class Solution {
    public static int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[i].length;j++){
                int ileft = Math.max(0,i-1);
                int iright = Math.min(M.length-1,i+1);

                int jleft = Math.max(0,j-1);
                int jright = Math.min(M[i].length-1,j+1);
                double sum = 0;
                int num = 0;
                for(int ii=ileft;ii<=iright;ii++){
                    for(int jj=jleft;jj<=jright;jj++){
                        sum += M[ii][jj];
                        num++;
                    }
                }
                double x = sum/num;
                res[i][j] = (int) Math.floor(x);
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] in = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        imageSmoother(in);
        System.out.println("Omar");
    }
}
