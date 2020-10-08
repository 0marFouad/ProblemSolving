package Leetcode.power_x_n;

public class Solution {
    public static double myPowSol(double x, int n) {
        if(n == 1){
            return x;
        }
        if(n == 2){
            return x*x;
        }
        int n1 = n/2;
        int n2 = n-n1;
        double ans = myPow(x,n1);
        if(n%2 == 0){
            return ans * ans;
        }else{
            return x * ans * ans;
        }
    }

    public static double myPow(double x, int n){
        if(n == 0 || x == 1){
            return 1;
        }
        if( x == 0){
            return 0;
        }

        if(n < 0){
            x = 1/x;
            n = -n;
        }

        if(n%2==1){
            double tempNum = myPow(x,(n-1)/2);
            return x * tempNum * tempNum;
        }else{
            double tempNum = myPow(x,n/2);
            return tempNum*tempNum;
        }
    }

    public static void main(String[] args){
        System.out.print(myPow(2,-2147483647));
    }
}
