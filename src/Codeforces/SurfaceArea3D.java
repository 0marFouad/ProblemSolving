package Codeforces;

import java.util.List;

public class SurfaceArea3D {
    public static boolean isValid(int n,int m,int i,int j){
        if(i>=0&&i<n&&j>=0&&j<m){
            return true;
        }
        return false;
    }

    public static int surfaceArea(List<List<Integer>> A) {
        // Write your code here
        int[][] dir = {{0,-1},
                {-1,0},
                {0,1},
                {1,0}};

        int n = A.size();
        int m = n == 0 ? 0 : A.get(0).size();

        if(n == 0){
            return 0;
        }
        int ans = 2 * n * m;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<4;k++){
                    if(isValid(n,m,i+dir[k][0],j+dir[k][1])){
                        ans += Math.max(0,A.get(i).get(j) - A.get(i+dir[k][0]).get(j+dir[k][1]));
                    }else{
                        ans += A.get(i).get(j);
                    }
                }
            }
        }
        return ans;
    }
}
