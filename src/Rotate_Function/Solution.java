package Rotate_Function;

class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length <= 1){
            return 0;
        }
        int num = 0;
        int tot = 0;
        for(int i=0;i<A.length;i++){
            num += A[i]*i;
            tot += A[i];
        }
        int mx = 0;
        mx = num;
        for(int i=A.length-1;i>=0;i--){
            int t = num;
            t += tot - (A.length)*A[i];
            mx = Math.max(mx,t);
            num = t;
        }
        return mx;
    }
}