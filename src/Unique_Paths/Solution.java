package Unique_Paths;

public class Solution {

    public static long C(int n,int r){
        r = Math.min(r,n - r);
        int n_r = Math.max(r,n-r);
        long res = 1;
        long fact_r = 1;
        for(int i=n;i>n_r;i--){
            res *= i;
            fact_r *= r;
            if(res%fact_r == 0){
                res /= fact_r;
                fact_r = 1;
            }
            r--;
        }
        return res/fact_r;
    }

    public static int uniquePaths(int m, int n) {
        return (int) C(n+m-2,n-1);
    }

    public static void main(String[] args){
        System.out.println(uniquePaths(100,100));
    }
}
