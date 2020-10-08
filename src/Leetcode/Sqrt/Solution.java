package Leetcode.Sqrt;

public class Solution {
    public static int mySqrt(int x) {
        int l = 1;
        int r = x;
        int mid;
        while(l<=r){
            mid = (l + r) >> 1;
            if(Integer.MAX_VALUE/mid<mid){
                l=mid;
            }
            if(mid * mid < x){
                l = mid + 1;
            }else if(mid * mid > x){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        return l*l>x ? l-1:l;
    }

    public static void main(String[] args){
        System.out.print(mySqrt(2147395599));
    }

}
